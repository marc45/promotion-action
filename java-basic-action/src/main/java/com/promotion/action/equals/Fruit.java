package com.promotion.action.equals;

import java.io.Serializable;

public class Fruit implements Serializable {
    private String name;
    @Override
    public boolean equals(Object o) {
        if (null == o) return false;
        if (this == o) return true;
        if (!(o instanceof Fruit)) return false;
        Fruit fruit = (Fruit) o;
        return name.equals(fruit.name);
    }
    public String getName() {
        return name;
    }
}
