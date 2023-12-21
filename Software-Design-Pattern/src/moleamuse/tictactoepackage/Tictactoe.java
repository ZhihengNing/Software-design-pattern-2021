package moleamuse.tictactoepackage;

import exceptionhandle.ExceptionHandle;
import moleamuse.Game;
import moleamuse.mementopackage.RecordList;
import moleamuse.mementopackage.ScoreOriginator;
import framework.simplefactory.*;
import moleamuse.tictactoepackage.object.AbstractChess;
import moleamuse.tictactoepackage.object.ChessBoard;
import singletonlazyinitialization.MoleManor;

import java.util.*;



public class Tictactoe implements Game {

    private Mole mole = MoleManor.getPlayer();

    /**
     * 检票
     * @return
     */
    private boolean checkTicket() {
        System.out.println("\n正在检票......");
        if(mole.getTicket() == 0) {
            System.out.println("票数不足，无法进行井字棋游戏，请先购买票！！");
            return false;
        }
        else{
            mole.setTicket(mole.getTicket() - 1);
            System.out.println("检票成功！\n目前剩余票数为：" + mole.getTicket());
            return true;
        }
    }

    @Override
    public void Play() {

        //初始化棋子
        System.out.println("\n启动摩摩井字棋！");

        //检票
        if (!checkTicket()){
            System.out.println("\n正在退出摩摩井字棋......\n成功退出，已返回游乐园！\n");
            return;
        }

        System.out.println("\n开始初始化！");
        //创造井字棋工厂
        TictactoeFactory tictactoeFactory = TictactoeFactory.getInstance();

        //生成棋子对象
        AbstractChess abstractChess = null;
        abstractChess = tictactoeFactory.getChessObject('B');
        abstractChess = tictactoeFactory.getChessObject('W');

        //初始化棋盘
        ChessBoard chessBoard = null;
        chessBoard = tictactoeFactory.getChessBoard();

        //用于输入异常处理
        int s=-1;
        ExceptionHandle exceptionHandle=new ExceptionHandle();

        //初始化摩尔选择的棋子
        System.out.println("请选择你的棋子，1代表黑棋，2代表白棋");
        int chesstype = 0;
        while (chesstype == 0) {

            /**
             * 异常处理
             */
            while(s==-1)
            {

                s = exceptionHandle.exception();
                switch (s) {
                    case 1:
                        chesstype = 1;
                        System.out.println("你已选择黑棋！");
                        break;
                    case 2:
                        chesstype = 2;
                        System.out.println("你已选择白棋！");
                        break;
                    default:
                        System.out.println("输入错误，请重新选择：");
                        s=-1;
                        break;
                }
            }
        }

        //记录结果
        int result = 0;
        //记录坐标
        int point = 0;

        System.out.println("初始化成功，游戏开始！！！\n");

        //显示棋盘
        chessBoard.show();

        Random random = new Random();

        /**
         * 游戏由“*”方先落子，因此分为两种情况
         */
        while(result == 0)
        {
            //情况一：摩尔选择“⚪”
            if(chesstype == 2) {
                try {
                    System.out.println("电脑正在思考中......");
                    Thread.sleep(800);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                abstractChess = tictactoeFactory.getChessObject('B');

                int r = 0;

                //电脑放置棋子
                do {
                    r = random.nextInt(8) + 1;
                }
                while(tictactoeFactory.getchess(r, abstractChess, chessBoard) == false);

                abstractChess.Point(r);

                chessBoard.show();

                //判断结果
                result = tictactoeFactory.getresult(r, abstractChess, chessBoard);
                if(result != 0)
                    break;



                //转为摩尔方
                abstractChess = tictactoeFactory.getChessObject('W');

                //选择要走的坐标
                do {
                    point=0;
                    /**
                     * 异常处理
                     */

                    System.out.println("请输入要走的坐标:");
                    point=exceptionHandle.exception();
                }
                while (tictactoeFactory.getchess(point, abstractChess, chessBoard) == false);

                abstractChess.Point(point);

                chessBoard.show();

                result = tictactoeFactory.getresult(point, abstractChess, chessBoard);
            }

            //情况二：摩尔选择“*”
            else {

                abstractChess = tictactoeFactory.getChessObject('B');

                //选择要走的坐标
                do {
                    point=0;
                    /**
                     * 异常处理
                     */
                    System.out.println("请输入要走的坐标:");
                    point=exceptionHandle.exception();
                }
                while (tictactoeFactory.getchess(point, abstractChess, chessBoard) == false);
                abstractChess.Point(point);

                //输出棋盘
                chessBoard.show();

                //判断结果
                result = tictactoeFactory.getresult(point, abstractChess, chessBoard);
                if(result != 0)
                    break;

                try {
                    System.out.println("电脑正在思考中......");
                    Thread.sleep(800);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                //电脑方
                abstractChess=tictactoeFactory.getChessObject('W');

                int r = 0;
                do {
                    r = random.nextInt(8) + 1;
                }
                while(tictactoeFactory.getchess(r, abstractChess, chessBoard) == false);

                abstractChess.Point(r);

                chessBoard.show();

                result = tictactoeFactory.getresult(r, abstractChess, chessBoard);
                abstractChess=tictactoeFactory.getChessObject('B');
            }
        }

        //获取游戏积分
        int score = 0;
        if (result == 3) {score = 5;}
        if (result == chesstype) {score = 10;}
        mole.setScore(score + mole.getScore());
        System.out.println("小摩尔["+MoleManor.getPlayer().getMoleName()+"]此次获得游戏积分：" + score + ", 总积分为：" + mole.getScore());

        /**
         * 添加备忘录
         */
        ScoreOriginator scoreOriginator = new ScoreOriginator();
        scoreOriginator.setRecord(score,"摩摩井字棋");
        RecordList.getInstance().add(scoreOriginator.saveRecordToMemento());

        System.out.println("\n正在退出摩摩井字棋......\n成功退出，已返回游乐园！\n");


    }

}