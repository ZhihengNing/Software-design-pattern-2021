package moleamuse.tictactoepackage.object;

public class WhiteChess extends AbstractChess{

    //初始化⚪棋子
    public WhiteChess(){
        super("⚪");
        System.out.println("白棋创建成功!!");
    }

    public void Point(int point){
        this.point=point;
    }

}
