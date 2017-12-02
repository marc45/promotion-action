package com.promotion.action.equals;

public class Apple extends Fruit {
    private String name;
    @Override
    public boolean equals(Object o) {
        if (null == o) return false;
        if (this == o) return true;
        if (!(o instanceof Apple)) return false;
        if (!super.equals(o)) return false;
        Apple apple = (Apple) o;
        return name.equals(apple.name);
    }
    public String getName() {
        return name;
    }

    @Override
    public int hashCode() {
        return name != null ? name.hashCode() : 0;
    }
}
