package chatroom.test;

import chatroom.robotpackage.Robot;

import java.util.InputMismatchException;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class MultipletonTest {
    /**
     * @test
     */
    public static void test(){
        System.out.println("----调用多例模式ing----");

        String npc1 = "我是" + Robot.getInstance("菩提大伯").getRobotName();
        String npc2 = "我是" + Robot.getInstance("么么公主").getRobotName();
        String npc3 = "我是" + Robot.getInstance("瑞琪").getRobotName();
        System.out.println(npc1 + "\n" + npc2 + "\n" + npc3);

        try {
            Robot r = Robot.getInstance("小摩尔");
        } catch (NoSuchElementException e) {
            System.out.println("Exception thrown  :" + e);
        }
    }

    public static void main(String[] args) {

        MultipletonTest.test();
    }
}
