package framework.test;

import framework.interpreter.BuyTicket;
import framework.simplefactory.Mole;
import singletonlazyinitialization.MoleManor;

public class InterpreterTest {
    /**
     * @test
     */
    public static void test(){
        System.out.println("----调用解释器模式ing----");

        MoleManor moleManor=MoleManor.getInstance();
        moleManor.test();
        Mole mole= MoleManor.getPlayer();
        BuyTicket by = new BuyTicket(mole);
        by.changeTicket(1);
    }

    public static void main(String []args){
        InterpreterTest.test();
    }
}
