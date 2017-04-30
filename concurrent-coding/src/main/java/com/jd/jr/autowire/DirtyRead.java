package com.jd.jr.autowire;

/**
 * Created by shifeifei on 2017/4/29.
 */
public class DirtyRead {

    private String username = "z3";
    private String password = "123";


    public synchronized void setValue(String username, String password) {
        this.username = username;
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        this.password = password;

        System.out.println("setValue最终结果: username=" + username + ",password=" + password);
    }

    public synchronized void getValue() {
        System.out.println("getValue方法结果: username=" + this.username + ",password=" + password);
    }

    public static void main(String[] args) {
        final DirtyRead dr = new DirtyRead();
        new Thread(new Runnable() {
            public void run() {
                dr.setValue("w5", "456");
            }
        }).start();

        dr.getValue();
    }
}
