package moleamuse.test;

import moleamuse.GameMaker;
import moleamuse.mementopackage.RecordList;


public class MementoTest {

    /**
     * @test
     */
    public static void test(){
        System.out.println("----调用备忘录模式ing----");

        RecordList r = RecordList.getInstance();
        r.printList();

        GameMaker.getInstance().playtestGame1();
        GameMaker.getInstance().playtestGame2();

        r.printList();
        r.getRecord(1);
        r.getRecord(3);

    }

    public static void main(String[] args) {
        MementoTest.test();
    }
}
