package com.promotion.action.equals;

public class TestFruit {

    public static void main(String[] args) {

        Fruit f = new Fruit();


        Apple a = new Apple();

        System.out.println(f.equals(a));
        System.out.println(a.equals(f));

    }
}
