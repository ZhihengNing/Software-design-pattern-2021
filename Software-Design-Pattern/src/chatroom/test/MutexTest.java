package chatroom.test;

import chatroom.Chatroom;
import chatroom.robotpackage.NPCList;

public class MutexTest {
    /**
     * @test
     */
    public static void test(){
        System.out.println("----调用互斥模式ing----");

        NPCList.getInstance().start();

        try{
            Thread.sleep(2000);
        }catch (InterruptedException e){
            System.out.println(e);
        }

        Chatroom.getInstance().showMessage();

        NPCList.getInstance().stop();
    }

    public static void main(String[] args) {
        MutexTest.test();
    }
}
