package moleamuse.tictactoepackage;

import moleamuse.tictactoepackage.object.AbstractChess;
import moleamuse.tictactoepackage.object.BlackChess;
import moleamuse.tictactoepackage.object.ChessBoard;
import moleamuse.tictactoepackage.object.WhiteChess;

import java.util.Hashtable;

public class TictactoeFactory {

    //单例模式工厂
    private static TictactoeFactory tictactoeFactory = new TictactoeFactory();

    //缓存存放共享对象
    private final Hashtable<Character, AbstractChess> cache = new Hashtable<Character, AbstractChess>();

    //私有化构造方法
    private TictactoeFactory(){
    }

    //获得单例工厂
    public static TictactoeFactory getInstance(){
        return tictactoeFactory;
    }



    /**
     *根据字符获得棋子
     */


    public AbstractChess getChessObject(char c){

        //从缓存中获得棋子对象实例
        AbstractChess abstractChess = this.cache.get(c);

        if(abstractChess == null){

            //缓存中没有棋子对象实例信息，则创造实例，并放入缓存
            switch(c){
                case'B':
                    abstractChess = new BlackChess();
                    break;
                case'W':
                    abstractChess = new WhiteChess();
                    break;
                default:
                    break;
            }

            //非法字符检测
            if(abstractChess != null){
                //放入缓存
                this.cache.put(c, abstractChess);
            }
        }

        return abstractChess;
    }

    //获取棋盘
    public ChessBoard getChessBoard(){

        ChessBoard chessBoard=new ChessBoard();

        return chessBoard;

    }

    //填入棋子
    public Boolean getchess(int point, AbstractChess abstractChess, ChessBoard chessBoard){

        if(point < 1 || point > 9){
            System.out.println("坐标越界！！请输入1——9！！");
            return false;
        }


        int x = (point - 1) / 3;
        int y = (point - 1) % 3;

        if(chessBoard.getchessboard(x, y) != "⚪" && chessBoard.getchessboard(x,y) != "*"){
            chessBoard.putchess(x, y, abstractChess.showChess());
            return true;
        }
        else{
            System.out.println("此坐标已有棋子！！");
            return false;
        }

    }


    //获取结果
    public int getresult(int point, AbstractChess abstractChess, ChessBoard chessBoard){
        return  chessBoard.result(point, abstractChess.showChess());
    }

}
