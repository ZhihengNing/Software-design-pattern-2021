package moleamuse.test;

import moleamuse.tictactoepackage.object.AbstractChess;
import moleamuse.tictactoepackage.TictactoeFactory;

public class FlyweightTest {
    /**
     * @test
     */
    public static void test(){
        System.out.println("----调用享元模式ing----");

        TictactoeFactory f = TictactoeFactory.getInstance();
        AbstractChess chess1 = f.getChessObject('W');
        AbstractChess chess2 = f.getChessObject('W');

        System.out.println(chess1 == chess2);

    }

    public static void main(String[] args) {

        FlyweightTest.test();
    }
}
