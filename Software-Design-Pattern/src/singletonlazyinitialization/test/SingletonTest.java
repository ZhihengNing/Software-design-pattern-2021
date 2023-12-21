package singletonlazyinitialization.test;

import singletonlazyinitialization.MoleManor;

public class SingletonTest {
    /**
     * @test
     */
    public static void test(){
        MoleManor m1 = MoleManor.getInstance();
        MoleManor m2 = MoleManor.getInstance();
        System.out.println(m1 == m2);
    }

    public static void main(String[] args) {
         test();
    }
}
