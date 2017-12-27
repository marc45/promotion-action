package com.promotion.action.pattern.observer.player;

public class Client {
    public static void main(String[] args) {

        Subject subject = new BattleSubject("海豹突击队");

        Player player1 = new Player("杨过");
        subject.join(player1);
        Player player2 = new Player("乔峰");
        subject.join(player2);
        Player player3 = new Player("张无忌");
        subject.join(player3);
        System.out.println("------------------------------------------------");
        //战队某个成员遭受攻击
        player1.beAttacked(subject);
        System.out.println("------------------------------------------------");
    }
}


