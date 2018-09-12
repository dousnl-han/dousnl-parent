package org.dousnl.netty.websocket;

import org.jboss.logging.Logger;
import org.jboss.logging.Logger.Level;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelFutureListener;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.handler.codec.http.DefaultFullHttpResponse;
import io.netty.handler.codec.http.FullHttpRequest;
import io.netty.handler.codec.http.websocketx.CloseWebSocketFrame;
import io.netty.handler.codec.http.websocketx.PingWebSocketFrame;
import io.netty.handler.codec.http.websocketx.PongWebSocketFrame;
import io.netty.handler.codec.http.websocketx.TextWebSocketFrame;
import io.netty.handler.codec.http.websocketx.WebSocketFrame;
import io.netty.handler.codec.http.websocketx.WebSocketServerHandshaker;
import io.netty.handler.codec.http.websocketx.WebSocketServerHandshakerFactory;
import io.netty.util.CharsetUtil;
import io.netty.handler.codec.http.*;

import static io.netty.handler.codec.http.HttpResponseStatus.BAD_REQUEST;  
import static io.netty.handler.codec.http.HttpVersion.HTTP_1_1;

import java.util.Date;


public class WebSocketServerHandler extends SimpleChannelInboundHandler<Object>{

	private static final Logger logger=Logger.getLogger(WebSocketServerHandshaker.class.getName());
	
	private WebSocketServerHandshaker  handshaker;
	
	@Override
	protected void channelRead0(ChannelHandlerContext ctx, Object msg) throws Exception {
		//传统的Http接入
		if (msg instanceof FullHttpRequest) {
			handleHttpRequest(ctx,(FullHttpRequest) msg);
		}
		//WebSocket接入
		else if(msg instanceof WebSocketFrame){
			handleWebSocketFrame(ctx,(WebSocketFrame) msg);
		}
		
	}
	@Override
	public void channelReadComplete(ChannelHandlerContext ctx) throws Exception {
	    ctx.flush();	
	}
    private void handleHttpRequest(ChannelHandlerContext ctx, FullHttpRequest req) {
		//如果Http解码失败，返回Http异常
    	if (! req.getDecoderResult().isSuccess() || (!"websocket".equals(req.headers().get("Upgrade")))) {
			sendHttpResponse(ctx,req,new DefaultFullHttpResponse(HTTP_1_1, BAD_REQUEST));
			return;
		}
    	//构造握手响应返回，本机测试
    	WebSocketServerHandshakerFactory factory=new WebSocketServerHandshakerFactory(
    			"ws://localhost:8080/websocket", null, false);
    	handshaker=factory.newHandshaker(req);
	}
    private void handleWebSocketFrame(ChannelHandlerContext ctx, WebSocketFrame frame) {
	    //判断是否关闭链路的指令
    	if (frame instanceof CloseWebSocketFrame) {
			handshaker.close(ctx.channel(), (CloseWebSocketFrame)frame.retain());
			return;
		}
    	//判断是否是Ping消息
    	if(frame instanceof PingWebSocketFrame){
    		ctx.channel().write(new PongWebSocketFrame(frame.content().retain()));
			return;
    	}
    	//本例程仅支持文本消息，不支持二进制消息
    	if (!(frame instanceof TextWebSocketFrame)) {
			String.format("%s frame types not supported", frame.getClass().getName());
		}
    	//返回应答消息
    	String request=((TextWebSocketFrame) frame).text();
    	if (logger.isInfoEnabled()) {
			logger.info(String.format("%s received %s", ctx.channel(), request));
		}
    	ctx.channel().write(new TextWebSocketFrame(request)+", 欢迎使用Netty WebSocket服务，现在时刻："+new Date().toString());
	}
	@SuppressWarnings("deprecation")
	private void sendHttpResponse(ChannelHandlerContext ctx, FullHttpRequest req,
			DefaultFullHttpResponse res) {
		//返回应答给客户端
		if (res.getStatus().code()!=200) {
			ByteBuf buf=Unpooled.copiedBuffer(res.getStatus().toString(), CharsetUtil.UTF_8);
			res.content().writeBytes(buf);
			buf.release();
			HttpUtil.setContentLength(res,res.content().readableBytes());
		}
		//如果是非Kepp-Alive,关闭连接
	    ChannelFuture fluse = ctx.channel().writeAndFlush(res);
	    if (! HttpUtil.isKeepAlive(req) || res.getStatus().code()!=200) {
			fluse.addListener(ChannelFutureListener.CLOSE);
		}
	}
	@Override
	public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
		cause.printStackTrace();
		ctx.close();
	}
}
