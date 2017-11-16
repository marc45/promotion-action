package com.promotion.action.generic;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class SuppressWarning {

    private int size = 10;

    public static void main(String[] args) {

        @SuppressWarnings("unchecked") Set<Lark> sets = new HashSet();
        Lark lark = new Lark();
        lark.setId(1);

        sets.add(lark);
        System.out.println(sets);

        //List<String>[] stringLists = new List<String>[1];

    }

    private static class Lark {
        private Integer id;

        public Integer getId() {
            return id;
        }

        public void setId(Integer id) {
            this.id = id;
        }
    }
}
