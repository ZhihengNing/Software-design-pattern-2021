package moleamuse.cookingpackage;

import exceptionhandle.ExceptionHandle;
import framework.simplefactory.Mole;
import moleamuse.cookingpackage.prototype.AbstractMeal;
import moleamuse.Game;
import moleamuse.mementopackage.RecordList;
import moleamuse.mementopackage.ScoreOriginator;
import singletonlazyinitialization.MoleManor;

import java.util.Scanner;

public class Cooking implements Game {

    private Mole mole = MoleManor.getPlayer();

    @Override
    public void Play() {
        System.out.println("\n进入摩尔厨房!");
        Scanner input = new Scanner(System.in);

        int index = 0;

        MealCache.loadCache();

        while(true){
            System.out.println("\n请输入你想做的菜：[1]宫保鸡丁 [2]糖醋里脊 [3]酸菜鱼");

            String type = input.nextLine();

            AbstractMeal clonedmeal = (AbstractMeal) MealCache.getMeal(type);
            if (clonedmeal == null) {
                System.out.println("\n厨房里没有你想做的菜哦！");
            } else {
                clonedmeal.cook();
                index ++;
            }


            System.out.println("\n是否拿走奖励，离开厨房？[0]离开厨房 [1]继续做菜");

            ExceptionHandle exceptionHandle = new ExceptionHandle();
            int choice = exceptionHandle.exception();
            if(choice != 1)  break;
        }

        mole.setScore(mole.getScore() + index);
        System.out.println("\n小摩尔["+MoleManor.getPlayer().getMoleName()+"]此次获得游戏积分：" + index + ", 总积分为：" + mole.getScore());

        mole.setMoney(mole.getMoney() + 100 * index);
        System.out.println("小摩尔["+MoleManor.getPlayer().getMoleName()+"]此次获得摩尔豆：" + 100 * index + ", 总摩尔豆为：" + mole.getMoney());

        /**
         * 添加备忘录
         */
        ScoreOriginator scoreOriginator = new ScoreOriginator();
        scoreOriginator.setRecord(index,"摩摩厨房");
        RecordList.getInstance().add(scoreOriginator.saveRecordToMemento());

        System.out.println("\n正在退出摩尔厨房......\n成功退出，已返回游乐园！\n");
    }
}
