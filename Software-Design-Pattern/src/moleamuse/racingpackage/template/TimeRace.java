package moleamuse.racingpackage.template;

import moleamuse.mementopackage.RecordList;
import moleamuse.mementopackage.ScoreOriginator;
import singletonlazyinitialization.MoleManor;

import java.util.Random;

/**
 * 竞速赛车
 */
public class TimeRace extends AbstractRacing{

    public TimeRace(){
        super(1);
    }

    @Override
    protected boolean checkTicket(int ticket){
        System.out.println("正在检票......");
        if(ticket==0) {
            System.out.println("票数不足，无法参加竞速赛，请先购买票！！");
            return false;
        }
        else{
            ticket--;
            System.out.println("检票成功！\n目前剩余票数为：" + ticket);
            return true;
        }
    }

    @Override
    protected void RacingProcess(int Score) {
        System.out.println("\n竞速赛正式开始！");
        Random random=new Random();
        int r=0;
        for(int i=0;i<5;i++) {
            r= random.nextInt(10)+10;
            try {
                System.out.println("小摩尔["+MoleManor.getPlayer().getMoleName()+"]正在进行第"+(i+1)+"圈......");
                Thread.sleep(200*(r));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("小摩尔["+MoleManor.getPlayer().getMoleName()+"]完成第"+(i+1)+"圈，"+"用时"+r*6+"秒!!");
            Score+=r*6;
            try {
                Thread.sleep(400);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            score(Score);
        }
    }

    @Override
    protected int getScore(int Score) {
        if(Score < 540){

            System.out.println("\n"+"小摩尔["+MoleManor.getPlayer().getMoleName()+"]在规定的时间内成功完成比赛！！");
            System.out.println("小摩尔["+MoleManor.getPlayer().getMoleName()+"]的最终的成绩为：" + Score + "秒");
            System.out.println("再接再厉！！");

            /**
             * 添加备忘录
             */
            ScoreOriginator scoreOriginator = new ScoreOriginator();
            scoreOriginator.setRecord((1000 - Score) / 50,"摩摩竞速赛");
            RecordList.getInstance().add(scoreOriginator.saveRecordToMemento());

            return (1000 - Score) / 50;
        } else{
            System.out.println("\n"+"小摩尔["+MoleManor.getPlayer().getMoleName()+"]在规定的时间内未完成比赛！！");
            System.out.println("成绩无效，再接再厉！！");

            /**
             * 添加备忘录
             */
            ScoreOriginator scoreOriginator = new ScoreOriginator();
            scoreOriginator.setRecord(0,"摩摩竞速赛");
            RecordList.getInstance().add(scoreOriginator.saveRecordToMemento());

            return 0;
        }
    }
}
