package org.dousnl.netty.serializable.protobuf;

import org.dousnl.netty.serializable.protobuf.SubscribeReqProto.SubscribeReq;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;

public class SubReqServerHandler extends ChannelInboundHandlerAdapter{

	@Override
	public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
		SubscribeReqProto.SubscribeReq req=(SubscribeReq) msg;
		 if("Lilinfeng".equalsIgnoreCase(req.getUserName())){
	            System.out.println("Service accept client subscribe req:["+req.toString()+"]");
	            //ctx.writeAndFlush(resp(req.getSubReqID()));
	        }
	}
	private SubscribeRespProto.SubscribeResp resp(int subReqID){
		SubscribeRespProto.SubscribeResp.Builder builder=
				SubscribeRespProto.SubscribeResp.newBuilder();
        builder.setSubReqID(subReqID);
        builder.setRespCode(0);
        builder.setDesc("Netty book order successd,3 days later,sent to the address");
        return builder.build();
    }
	@Override
	public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
		cause.printStackTrace();
		ctx.close();
	}
}
