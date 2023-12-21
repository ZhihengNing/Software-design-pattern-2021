package singletonlazyinitialization.test;

import singletonlazyinitialization.MoleManor;

public class LazyinitializationTest {
    /**
     * @test
     */
    public static void test(){
        MoleManor.getInstance().showMessage();
    }

    public static void main(String[] args) {
        test();
    }
}
