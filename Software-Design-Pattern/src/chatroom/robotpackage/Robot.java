package chatroom.robotpackage;

import chatroom.Chatroom;

import java.util.*;

/**
 * NPC
 */
public enum Robot implements Runnable {

    /**
     * 使用枚举类型实现多例模式
     * 3个NPC：菩提大伯，么么公主，瑞琪
     */
    UnclePuti("菩提大伯"), PrincessMeme("么么公主"), Ruiqi("瑞琪");


    /**
     * 获取一个NPC的单例
     * @param robotName
     * @return
     */
    public static Robot getInstance(String robotName){
        return switch (robotName){
            case "菩提大伯" -> UnclePuti;
            case "么么公主" -> PrincessMeme;
            case "瑞琪" -> Ruiqi;
            default->throw new NoSuchElementException("找不到该NPC!");
        };
    }

    //终止线程标识符
    public volatile boolean exit = false;

    private Thread t;

    //NPC名字
    private String RobotName;

    private String[] randMessage = {"", "今天天气不错", "中午吃什么", "我要去游乐园","你好呀"};
    private Random random = new Random();


    /**
     * 私有构造函数
     * @param name
     */
    Robot(String name) {
        RobotName = name;
        randMessage[0] = "我是" + name;
    }

    private String BuildMessage(){
        int r = random.nextInt(4);
        return randMessage[r];
    }

    private void sendMessage(String message){
        Chatroom.getInstance().addMessage(RobotName, message);
    }

    public String getRobotName() {
        return RobotName;
    }

    /**
     * NPC操作：向聊天室添加消息
     */
    public void run() {

        try {
            while (exit) {

                String str = BuildMessage();

                //获取线程锁
                Chatroom.getInstance().Lock();
                //发送信息
                try {
                    sendMessage(str);
                } finally {
                    Chatroom.getInstance().unLock();//解锁
                }

                Thread.sleep(1000);
            }
        }catch (InterruptedException e) {
            System.out.println("Thread " +  RobotName + " interrupted.");
        }


    }


    /**
     * 启动NPC
     */
    public void start () {

        if (t == null) {
            t = new Thread (this, RobotName);
            t.start ();
            exit = true;
        }

    }

    public void stop() {exit = false;}
}
