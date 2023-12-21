package moleamuse.racingpackage.template;

import exceptionhandle.ExceptionHandle;
import framework.simplefactory.Mole;
import singletonlazyinitialization.MoleManor;

import java.security.PublicKey;
import java.util.Scanner;

public abstract class AbstractRacing{

    private Mole mole = MoleManor.getPlayer();
    private int ticket;
    private int score;
    private int type;

    public AbstractRacing(int type) {
        this.type = type;
        this.ticket = mole.getTicket();
        this.score = 0;
    }

    public void score(int score){this.score = score;}


    /**
     * 检票
     */
    protected abstract boolean checkTicket(int ticket);


    /**
     * 准备阶段
     */
    public void Prepare(){
        ExceptionHandle exceptionHandle=new ExceptionHandle();
        System.out.println("\n请摩尔系好安全带，戴好头盔，游戏马上开始！！");
        System.out.println("输入1：确保安全带系好");
        Scanner input=new Scanner(System.in);
        int s=0;
        s=exceptionHandle.exception();
        while(s!=1){
            System.out.println("还未系好安全带，请重新输入");
            s=exceptionHandle.exception();
        }
        System.out.println("输入2：确保头盔戴好");
        s=exceptionHandle.exception();
        while(s!=2){
            System.out.println("还未戴好头盔，请重新输入");
            s=exceptionHandle.exception();
        }
        System.out.println("输入3：确认游戏开始");
        s=exceptionHandle.exception();
        while(s!=3){
            System.out.println("输入3：确认开始比赛");
            s=exceptionHandle.exception();
        }
    }

    /**
     * 不同赛车不同过程
     */
    protected abstract void RacingProcess(int score);

    /**
     * 获取得分
     */
    protected abstract int getScore(int score);

    /**
     * 整个过程模板
     */
    public void StartRacing(){

        if(checkTicket(ticket)==false) {
            System.out.println("\n正在返回摩摩赛车城...\n");
            return;
        }


        mole.setTicket(--ticket);

        Prepare();

        RacingProcess(score);

        score = getScore(score);
        mole.setScore(mole.getScore() + score);
        System.out.println("小摩尔[" + MoleManor.getPlayer().getMoleName() + "]此次获得游戏积分：" + score + ", 总积分为：" + mole.getScore());

        System.out.println("正在返回摩摩赛车城...\n");
    }


    /**
     * @test
     */
    public void test(){
        score = getScore(score);
    }


}