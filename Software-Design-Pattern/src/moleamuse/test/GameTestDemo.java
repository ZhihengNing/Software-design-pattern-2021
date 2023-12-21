package moleamuse.test;

import moleamuse.GameMaker;
import moleamuse.mementopackage.RecordList;
import moleamuse.mementopackage.ScoreOriginator;
import singletonlazyinitialization.MoleManor;


public class GameTestDemo {

    public static void main(String[] args) {

        MoleManor moleManor = MoleManor.getInstance();
        moleManor.test();

        ScoreOriginator scoreOriginator = new ScoreOriginator();
        RecordList pointRecordList = RecordList.getInstance();
        GameMaker gameMaker = new GameMaker();


        gameMaker.playTictactoe();

        gameMaker.playCooking();


        gameMaker.playRacing();


        System.out.println("\n开始打印得分备忘录内容...");
        pointRecordList.printList();
    }
}
