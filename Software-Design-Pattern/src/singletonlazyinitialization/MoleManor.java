package singletonlazyinitialization;

import backpack.MVC.*;
import backpack.information.PutInformation;
import framework.blackboard.BlackboardUI;
import framework.composite.*;
import framework.simplefactory.*;
import chatroom.robotpackage.*;
import chatroom.*;
import moleamuse.GameUI;
import molefarm.FarmProcess;
import molemall.MallProcess;

import java.util.Scanner;


public class MoleManor {
    //创建一个MoleManor的一个静态对象
    private static Mole player;

    //菜单
    private static Component currentMenu;

    /**
     * 天气情况
     */
    String[] weathers={"晴天","雨天","阴天"};
    String weather=weathers[(int)(Math.random()*3)];

    //构造函数为private，该类不会被实例化
    private MoleManor(){
    }

    public static MoleManor getInstance(){return SingletonHolder.getInstance();}
    //输出测试信息
    public void showMessage(){
        System.out.println("MoleManor is created successfully!");
    }

    /**
     * 测试用例！！！！
     * @test
     */
    public void test() {
        MoleFactory moleFactory = new MoleFactory();
        player = moleFactory.createMole("Momo","Red");
        player.setMoleName("test");
        player.setMoney(2000);
        player.setTicket(2);
        player.setScore(0);
    }



    public void flowController() throws CloneNotSupportedException{
        System.out.println("欢迎来到摩尔庄园！\n\n\n");
        Scanner input = new Scanner(System.in);

        /**
         * 创建角色
         */
        player = MoleCreator.getInstance().createMole();
        System.out.println("\n角色创建成功，正在进入摩尔大厅！！！\n\n\n");

        /**
         * 添加NPC
         */
        NPCList.getInstance().start();

        /**
         * 主菜单
         */
        currentMenu = MenuList.getInstance().meanMenu();

        /**
         * 公告
         */
        BlackboardUI blackboard = new BlackboardUI();
        blackboard.showBlackboard();

        /**
         * 背包信息
         */
        BackpackView backpackView = new BackpackView();
        BackpackController controller = new BackpackController(player.getBackpack(), backpackView);
        PutInformation putInformation = new PutInformation();


        while(true){

            printMenu();

            int i = input.nextInt();

            moveTo(i - 1);

            switch(i){
                case 1:
                    System.out.println("\n正在进入摩尔游乐园！");
                    GameUI gamemaker = new GameUI();
                    gamemaker.playGame();
                    break;
                case 2:
                    System.out.println("欢迎来到摩尔农场！\n");
                    FarmProcess farmProcess = FarmProcess.newInstance();
                    farmProcess.process();
                    break;
                case 3:
                    System.out.println("欢迎来到摩尔商场！\n");
                    MallProcess mallProcess=MallProcess.newInstance();
                    mallProcess.process();
                    break;
                case 4:
                    System.out.println("\n正在进入摩尔聊天室！");
                    ChatUI chatroom = new ChatUI();
                    chatroom.chatting();
                    break;
                case 5:
                    System.out.println("\n正在显示广告牌内容！");
                    blackboard.showBlackboard();
                    break;
                case 6:
                    System.out.println("\n正在显示摩尔的基本信息！");
                    putInformation.showMoleInformation(player,controller);;
                    break;
                case 0:
                    goback();
                    System.out.println("\n您即将离开摩尔庄园，再见是为了更好的重逢！");
                    //终止NPC线程
                    NPCList.getInstance().stop();
                    return;
                default:
                    break;
            }

            goback();

        }
    }

    public static Mole getPlayer() {
        return player;
    }


    /**
     * 延迟初始化
     * 需要才创建，保证线程安全
     */
    private static class SingletonHolder{
        private static MoleManor instance = new MoleManor();
        public static MoleManor getInstance() {
            return instance;
        }
    }

    /**
     * 菜单切换，打印操作
     * @param index
     */
    public static void moveTo(int index){
        currentMenu = currentMenu.moveTo(index);
    }

    public static void goback(){
        currentMenu = currentMenu.getLast();
    }

    public static void printMenu(){
        currentMenu.printMenu();
    }

}
