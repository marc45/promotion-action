package com.promotion.action.equals;

import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;

public class HashMapTest {


    public static void main(String[] args) {

        Map map = new LinkedHashMap();

        map.put("a",1);
        map.put("f",3);

        map.put("d",2);
        map.put("g",5);
        map.put("h",6);

        Iterator iter = map.entrySet().iterator();
        while (iter.hasNext()) {
            Map.Entry entry = (Map.Entry) iter.next();
            System.out.println(entry.getKey() + ":" + entry.getValue());
        }


    }

}