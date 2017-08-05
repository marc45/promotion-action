package com.promotion.action.guava;

import com.google.common.collect.Iterables;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.google.common.primitives.Ints;

import java.util.List;
import java.util.Map;

/**
 * Created by shifeifei on 2017/8/5.
 */
public class Demo {

    public static void main(String[] args) {
        List<String> list = Lists.newArrayList();
        list.add("a");
        list.add("b");
        list.add("c");

        System.out.println(list.toString());

        Map<String, Object> map = Maps.newHashMap();
        map.put("a", 1);
        map.put("b", 2);

        System.out.println(map.toString());

        List<String> stringList = Lists.newArrayList("a", "b", "c", "d");
        System.out.println(stringList);

        Iterable<Integer> concatenated = Iterables.concat(Ints.asList(1, 2, 3), Ints.asList(4, 5, 6));
        for (Integer integer : concatenated) {
            System.out.println(integer);
        }



    }
}
