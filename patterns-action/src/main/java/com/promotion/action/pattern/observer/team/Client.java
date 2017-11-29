package com.promotion.action.pattern.observer.team;

public class Client {


    public static void main(String[] args) {


        AllyControlCenter acc = new ConcreteAllyControlCenter("战狼特种大队");

        Observer player1, player2, player3, player4;

        player1 = new Player("杨过");
        acc.attach(player1);

        player2 = new Player("令狐冲");
        acc.attach(player2);

        player3 = new Player("乔峰");
        acc.attach(player3);

        player4 = new Player("张无忌");
        acc.attach(player4);

        //某成员遭受攻击
        player1.beAttacked(acc);
    }
}
