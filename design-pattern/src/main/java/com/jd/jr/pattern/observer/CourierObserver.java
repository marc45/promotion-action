package com.jd.jr.pattern.observer;

/**
 * Created by shifeifei on 2017/5/2.
 * 快递员观察者
 */
public class CourierObserver implements Observer {

    private String username;

    public void update(String message) {
        System.out.println(message);
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof CourierObserver)) return false;

        CourierObserver that = (CourierObserver) o;

        return username.equals(that.username);
    }

    @Override
    public int hashCode() {
        return username.hashCode();
    }
}
