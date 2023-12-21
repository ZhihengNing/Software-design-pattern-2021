package moleamuse.racingpackage.template;

import moleamuse.mementopackage.RecordList;
import moleamuse.mementopackage.ScoreOriginator;
import singletonlazyinitialization.MoleManor;

import java.util.Random;

/**
 * 障碍赛
 */
public class ObstacleRace extends AbstractRacing{

    public ObstacleRace(){
        super(3);
    }
    @Override
    protected boolean checkTicket(int ticket){
        System.out.println("正在检票......");
        if(ticket==0) {
            System.out.println("票数不足，无法参加障碍赛，请先购买票！！");
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
        System.out.println("\n障碍赛正式开始！");
        Random random=new Random();
        int r=0;
        for(int i=0;i<7;i++) {
            try {
                System.out.println("小摩尔["+MoleManor.getPlayer().getMoleName()+"]来到第"+(i+1)+"关......");
                Thread.sleep(1500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            r= random.nextInt(15);
            if(r>(i+1)) {
                System.out.println("小摩尔["+MoleManor.getPlayer().getMoleName()+"]成功通过第" + (i + 1) + "关!!");
                Score++;
                score(Score);
            }else{
                System.out.println("小摩尔["+MoleManor.getPlayer().getMoleName()+"]在第" + (i + 1) + "关失误，胜败乃兵家常事，摩尔请从新来过！！");
                break;
            }
            try {
                Thread.sleep(400);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
    }

    @Override
    protected int getScore(int Score) {
        if(Score == 7){

            System.out.println("\n"+"小摩尔["+MoleManor.getPlayer().getMoleName()+"]成功通过障碍赛！！");
            System.out.println("小摩尔["+MoleManor.getPlayer().getMoleName()+"]的最终的成绩为：" + Score + "（满分为7分）");
            System.out.println("请收下膝盖！！");

            /**
             * 添加备忘录
             */
            ScoreOriginator scoreOriginator = new ScoreOriginator();
            scoreOriginator.setRecord(Score * 2,"摩摩障碍赛");
            RecordList.getInstance().add(scoreOriginator.saveRecordToMemento());

            return Score * 2;
        } else{
            System.out.println("\n"+"小摩尔["+MoleManor.getPlayer().getMoleName()+"]止遗憾步障碍赛第"+ (Score + 1) + "关!!");
            System.out.println("最终的成绩为："+Score+"（满分为7分）");
            System.out.println("再接再厉！！");

            /**
             * 添加备忘录
             */
            ScoreOriginator scoreOriginator = new ScoreOriginator();
            scoreOriginator.setRecord(Score,"摩摩障碍赛");
            RecordList.getInstance().add(scoreOriginator.saveRecordToMemento());

            return Score;
        }
    }
}
