package framework.blackboard;

public class BlackboardUI {
    /**
     * 显示公告内容
     */
    public void showBlackboard(){

        Blackboard blackboard = new Blackboard();

        Control control = new Control(blackboard);
        control.addNotice("今天商场的衣服又搞促销啦！");
        control.addNotice("游乐园的小游戏欢迎大家来玩哟！");
        control.addNotice("商场的汉堡好吃又便宜，快去品尝吧！");
        control.addNotice("农场的土地又翻新啦，快去种植作物吧！");
        control.addAllNotice();

        blackboard.show();
        System.out.println();
    }
}