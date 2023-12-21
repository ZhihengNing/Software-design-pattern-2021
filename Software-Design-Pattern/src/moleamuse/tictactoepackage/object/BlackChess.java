package moleamuse.tictactoepackage.object;

public class BlackChess extends AbstractChess {

    //初始化*棋子
    public BlackChess(){
        super("*");
        System.out.println("黑棋创建成功!!");
    }

    public void Point(int point){
        this.point=point;
    }

}
