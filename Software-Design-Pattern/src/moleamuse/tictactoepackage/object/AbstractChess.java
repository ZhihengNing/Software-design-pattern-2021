package moleamuse.tictactoepackage.object;

public abstract class AbstractChess {

    //棋子坐标
    protected int point;
    //棋子类别（*|⚪）
    protected String chess;

    public AbstractChess(String chess){
        this.chess=chess;
    }

    //显示棋子信息
    public void show() {
        System.out.println(this.chess);
    }

    public abstract void Point(int point);

    public String showChess(){
        return chess;
    }

}