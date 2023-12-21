package moleamuse.tictactoepackage.object;

public class ChessBoard {

    protected String[][] chessboard={{"1","2","3"},{"4","5","6"},{"7","8","9"}};
    protected int num = 0;

    /**
     * 判断结果的数组
     * 每一位的数字代表棋子个数，’*‘棋子加一，’⚪‘棋子减一
     * 每一位分别代表：第一行，第二行，第三行，第一列，第二列，第三列，对角线，逆对角线，已有棋子数
     */

    protected int[] result = {0,0,0,0,0,0,0,0};

    public ChessBoard() {
        System.out.println("棋盘创建成功!!");
    }

    public String getchessboard(int i,int j){
        return chessboard[i][j];
    }

    public void putchess(int i,int j,String chess){
        chessboard[i][j]=chess;
    }

    //返回棋子个数
    public int shownum(){
        return num;
    }

    //打印棋盘
    public void show(){

        for (int i = 0; i < 3; i++){
            for (int j = 0; j <3 ; j++){

                System.out.print(chessboard[i][j]);

                if(j != 2)
                    System.out.print("|");
                else
                    System.out.print('\n');

            }
        }
        System.out.print('\n');

    }

    //判断结果
    public int result(int point,String chess){

        int x = (point - 1) / 3;
        int y = (point - 1) % 3;

        num++;

        switch(chess){
            case "*":

                result[x]++;
                result[y + 3]++;

                if(x == y)
                    result[6]++;
                if((x + y) == 2)
                    result[7]++;

                break;

            case "⚪":

                result[x]--;
                result[y + 3]--;

                if(x == y)
                    result[6]--;
                if((x + y)==2)
                    result[7]--;

                break;
        }

        /**
         * 判断哪方获胜
         * 出现3为’*‘方获胜
         * 出现-3为’⚪‘方获胜
         */
        for(int i = 0; i < 8; i++){

            if(result[i] == 3){
                System.out.println("游戏结束，’*‘方获胜！！");
                return 1;
            }
            else if(result[i] == -3){
                System.out.println("游戏结束，’⚪‘方获胜！！");
                return 2;
            }

        }
        //判断是否为平局
        if(num == 9){
            System.out.println("游戏结束，平局！！");
            return 3;
        }
        else return 0;

    }
}
