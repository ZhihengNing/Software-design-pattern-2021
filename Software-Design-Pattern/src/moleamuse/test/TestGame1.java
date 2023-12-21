package moleamuse.test;

import moleamuse.Game;
import moleamuse.mementopackage.RecordList;
import moleamuse.mementopackage.ScoreOriginator;

public class TestGame1 implements Game {
    @Override
    public void Play() {
        System.out.println("playing game1...");
        ScoreOriginator scoreOriginator = new ScoreOriginator();
        scoreOriginator.setRecord(10,"game1");
        RecordList.getInstance().add(scoreOriginator.saveRecordToMemento());
    }

}
