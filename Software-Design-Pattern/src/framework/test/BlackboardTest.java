package framework.test;


import framework.blackboard.*;

public class BlackboardTest {
    /**
     * @test
     */
    public static void test(){
        System.out.println("----调用黑板模式ing----");

        Blackboard blackboard = new Blackboard();

        Control control = new Control(blackboard);
        control.addNotice("test");
        control.addAllNotice();

        blackboard.show();
    }

    public static void main(String[] args){
        BlackboardTest.test();
    }
}
