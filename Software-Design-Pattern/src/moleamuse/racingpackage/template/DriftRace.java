package moleamuse.racingpackage.template;

import moleamuse.mementopackage.RecordList;
import moleamuse.mementopackage.ScoreOriginator;
import singletonlazyinitialization.MoleManor;

import java.util.Random;

/**
 * 漂移赛车
 */
public class  DriftRace extends AbstractRacing{

    public DriftRace(){
        super(2);
    }

    @Override
    protected boolean checkTicket(int ticket){
        System.out.println("正在检票......");
        if(ticket==0) {
            System.out.println("票数不足，无法参加漂移赛，请先购买票！！");

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
        System.out.println("\n漂移赛正式开始！");
        Random random=new Random();
        int r=0;
        for(int i=0;i<10;i++) {

            try {
                System.out.println("小摩尔["+MoleManor.getPlayer().getMoleName() +"]进入弯道！！");
                Thread.sleep(800);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            r = random.nextInt(3) % 2;
            if (r == 0) {
                Score++;
                score(Score);
                System.out.println("小摩尔["+MoleManor.getPlayer().getMoleName()+"]成功完成一次漂移！！");
            } else
                System.out.println("小摩尔["+MoleManor.getPlayer().getMoleName()+"]此次漂移失败，再接再厉！！");

            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
    }

    @Override
    protected int getScore(int Score) {

        System.out.println("\n"+"小摩尔["+MoleManor.getPlayer().getMoleName()+"]完成此次漂移赛");
        System.out.println("小摩尔["+MoleManor.getPlayer().getMoleName()+"]的最终的分为："+Score+"（满分10分）");
        System.out.println("再接再厉！！");

        /**
         * 添加备忘录
         */
        ScoreOriginator scoreOriginator = new ScoreOriginator();
        scoreOriginator.setRecord(Score,"摩摩漂移赛");
        RecordList.getInstance().add(scoreOriginator.saveRecordToMemento());

        return Score;
    }
}
