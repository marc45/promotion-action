package com.promotion.action.equals;

import java.util.*;


public class LinkedHashMap<K, V> extends HashMap<K, V> implements Map<K, V> {

    public static void main(String[] args) {

        Hashtable<String, String> hashtable = new Hashtable<String, String>();
        hashtable.put("a", "1");
        hashtable.put("b", "2");
        hashtable.put("c", "3");



        Iterator<Entry<String, String>> iterator = hashtable.entrySet().iterator();
        while (iterator.hasNext()) {
            Entry<String, String> entry = iterator.next();
            System.out.println(entry.getKey() + "=" + entry.getValue());
        }

        Enumeration<String> e = hashtable.keys();
        while (e.hasMoreElements()) {
            String key = e.nextElement();
            System.out.println(key + "=" + hashtable.get(key));
        }


    }


}

