package com.dousnl.demo;

import java.util.Arrays;

public class StreamTest {

    public static void main(String[] args){
        String [] str ={"aaa","bbb","ccc"};
        String[] split = "aaa".split("");
        for (String s:split){
            System.out.println("s:"+s);
        }

        System.out.println();
        Arrays.asList(str).stream().map(e->e.split("")).forEach(System.out::println);
        Arrays.stream(str).map(e->e.split("")).flatMap(e->Arrays.stream(e)).forEach(System.out::println);
    }
}
