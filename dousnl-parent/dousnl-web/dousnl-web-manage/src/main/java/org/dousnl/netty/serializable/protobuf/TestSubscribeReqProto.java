package org.dousnl.netty.serializable.protobuf;

import java.util.ArrayList;
import java.util.List;

import com.google.protobuf.InvalidProtocolBufferException;

public class TestSubscribeReqProto {
	
	private static byte[] encode(SubscribeReqProto.SubscribeReq req){
        return req.toByteArray();
    }
    
    private static SubscribeReqProto.SubscribeReq decode(byte[] body) 
            throws InvalidProtocolBufferException {
        return SubscribeReqProto.SubscribeReq.parseFrom(body);
    }
    
    private static SubscribeReqProto.SubscribeReq createSubscribeReq(){
        SubscribeReqProto.SubscribeReq.Builder builder = 
                SubscribeReqProto.SubscribeReq.newBuilder();
        builder.setSubReqID(1);
        builder.setUserName("Lilinfeng");
        builder.setProductName("netty book");
        List<String> address = new ArrayList<>();
        address.add("NanJing YuHuaTai");
        address.add("beijin lilili");
        address.add("asdfasdf");
        builder.addAllAddress(address);
        return builder.build();
    }
    
    /*public static void main(String[] args) throws InvalidProtocolBufferException {
            SubscribeReqProto.SubscribeReq req = createSubscribeReq();
            System.out.println("befor encode:" + req.toString());
            SubscribeReqProto.SubscribeReq req2 = decode(encode(req));
            System.out.println("After decode :"+req.toString());
            System.out.println("assert equal : ==>" + req2.equals(req));
    }*/
}
