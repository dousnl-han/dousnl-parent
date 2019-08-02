package com.dousnl.autho;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.dousnl.autho.domain.User;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.UUID;

/**
 * TODO
 *
 * @author hanliang
 * @version 1.0
 * @date 2019/7/29 16:43
 */
public class Test {
    public static String generateTimestamp() {
        return (new SimpleDateFormat("YYYYMMddHHmmss")).format(new Date());
    }
    public static String get16UUID() {
        UUID id = UUID.randomUUID();
        String[] idd = id.toString().split("-");
        return idd[0] + idd[1] + idd[2];
    }
    public static void main(String[] args) {
        String s = generateTimestamp();
        System.out.println(s);
       // int i = Integer.parseInt(s) + 1;
        String format = (new DecimalFormat("0000")).format((long) 1);
        System.out.println(format);
        JSONObject json= JSON.parseObject("{\"username\":\"123\",\"password\":\"32wdd\"}");
        User o = JSON.parseObject(json.toString(), User.class);
        System.out.println("user:"+o.toString());
        System.out.println();
        int second = LocalDateTime.now().getSecond();
        System.out.println(second);
        System.out.println(String.format("%s%02d%s", "MA35PU38X",second,get16UUID()));

        Long a=8L,b=6L;
        Long c = new BigDecimal(555).negate().longValue();
        System.out.println(b.compareTo(a));
        System.out.println(c);
        String str="asdasd dasds";
        System.out.println("System.lineSeparator():" + str.replaceAll(System.lineSeparator(),""));
    }
}
