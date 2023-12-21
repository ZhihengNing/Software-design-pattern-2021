package moleamuse;


import exceptionhandle.ExceptionHandle;
import framework.interpreter.BuyTicket;
import moleamuse.mementopackage.RecordList;
import singletonlazyinitialization.MoleManor;

import java.util.Scanner;

public class GameUI {

    private GameMaker gameMaker = GameMaker.getInstance();
    BuyTicket by;


    public GameUI(){
    }

    public void playGame(){

        while(true){

            MoleManor.printMenu();

            Scanner scan = new Scanner(System.in);
            ExceptionHandle exceptionHandle = new ExceptionHandle();
            int i = exceptionHandle.exception();

            MoleManor.moveTo(i - 1);

            switch(i){
                case 1:
                    gameMaker.playCooking();
                    break;
                case 2:
                    System.out.println("\n正在进入摩摩赛车场！");
                    gameMaker.playRacing();
                    break;
                case 3:
                    gameMaker.playTictactoe();
                    break;
                case 4:
                    RecordList.getInstance().printList();
                    break;
                case 5:
                    by = new BuyTicket(MoleManor.getPlayer());
                    by.buyTicket();
                    break;
                case 0:
                    MoleManor.goback();
                    System.out.println("\n已离开游乐园，即将返回摩尔大厅！！！\n\n\n");
                    return;
                default:
                    break;
            }

            MoleManor.goback();

        }
    }
}