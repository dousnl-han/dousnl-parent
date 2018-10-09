package org.dousnl.test.sortmap;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.TreeMap;

/**
 * @description:TreeMap/LinkedHashMap
 * @author:56096
 * @date:2018/10/9 10:55
 */
public class KetSetTest {
    /*
     * @author:56096
     * @date:2018/10/9 11:08
     * @param
     * @return
     **/
    public static void main(String[] args){

        Map<String,Integer> tree =new TreeMap<String, Integer>();
        tree.put("a",1);
        tree.put("c",3);
        tree.put("d",4);
        tree.put("b",2);
        for (String key:tree.keySet()){
            System.out.println(tree.get(key));
        }
        System.out.println("******************");
        LinkedHashMap<String,Integer> link=new LinkedHashMap<String,Integer>();
        link.put("a",1);
        link.put("c",3);
        link.put("d",4);
        link.put("b",2);
        for (String key:link.keySet()){
            System.out.println(link.get(key));
        }
    }
}
