package com.promotion.action;

import java.util.Random;

public class FinalTest {
    /*编译期常量，必须要进行初始化，且不可更改*/
    private final String final_01 = "chenssy";
    /*构造器常量，在实例化一个对象时被初始化*/
    private final String final_02;
    /*运行期常量，使用随机数来初始化*/
    private final int final_03 = new Random().nextInt(50);
    /*引用类型常量*/
    public final Person final_04 = new Person("chen_ssy");

    FinalTest(String final_02) {
        this.final_02 = final_02;
    }
    public String toString() {
        return "final_01 = " + final_01 + "   final_02  = " + final_02 + "   final_03 = " + final_03 +
                "   final_04 = " + final_04.getName();
    }
    public static void main(String[] args) {
        FinalTest final1 = new FinalTest("cm");
        System.out.println("第一次运行：" + final1);
        FinalTest final2 = new FinalTest("zj");
        System.out.println("第一次运行：" + final2);
        final2.final_04.setName("chenssy");
        System.out.println("修改引用：" + final2);

    }
}

class Person {
    private String name;

    Person(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
