package chatroom;

import chatroom.mutex.*;

import java.util.*;

/**
 * 中介者模式：聊天室
 */
public class Chatroom {

    private static Chatroom instance = new Chatroom();
    private Chatroom(){}
    public static Chatroom getInstance(){
        return instance;
    }

    private LinkedList<String> MessageList = new LinkedList<String>();

    /**
     * 消息互斥锁
     * 只有一个NPC能进入聊天室添加消息
     */
    private final static Lock lock = new Mutex();


    /**
     * 上锁
     * @throws InterruptedException
     */
    public static void Lock() throws InterruptedException {lock.acquire();}

    /**
     * 解锁
     */
    public static void unLock() {lock.release();}

    /**
     * 添加消息
     * @param username
     * @param message
     */
    public void addMessage(String username, String message){

        MessageList.addLast(new Date().toString()
                + " [" + username +"] : " + message);

        //队列中只支持30条消息
        if(MessageList.size() > 30){
            MessageList.removeFirst();
        }
    }

    /**
     * 显示消息
     */
    public void showMessage(){

        Iterator<String> it = MessageList.iterator();

        try{
            while (it.hasNext()) {
                System.out.println(it.next());
            }
        }catch (ConcurrentModificationException e)
        {
            System.out.println("Exception thrown  :" + e);
        }

    }
}
