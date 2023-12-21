package framework.simplefactory;

import backpack.MVC.Backpack;
import exceptionhandle.ExceptionHandle;

import java.util.Scanner;

public class MoleCreator {

    private MoleCreator() {}
    private static MoleCreator instance = new MoleCreator();
    public static MoleCreator getInstance(){
        return instance;
    }

    /**
     * 创建角色
     * @return
     */
    public Mole createMole(){
        Scanner input = new Scanner(System.in);
        //用于异常处理

        ExceptionHandle exceptionHandle=new ExceptionHandle();

        int roleNum=0, colorNum=0;

        System.out.println("请输入你的名字：");
        String name = input.nextLine();

        String role = "Molele";
        String color = "Red";

        while(roleNum==0){
            System.out.println("选择你的角色：[1]Molele [2]Momo [3]Kura");
            roleNum=exceptionHandle.exception();
            switch(roleNum){
                case 1:
                    role="Molele";
                    break;
                case 2:
                    role="Momo";
                    break;
                case 3:
                    role="Kura";
                    break;
                default:
                    roleNum=0;
                    break;
            }
        }

        while(colorNum==0){
            System.out.println("选择外观颜色：[1]Red [2]Green [3]Blue");
            colorNum = exceptionHandle.exception();
            switch(colorNum){
                case 1:
                    color="Red";
                    break;
                case 2:
                    color="Green";
                    break;
                case 3:
                    color="Blue";
                    break;
                default:
                    colorNum=0;
                    break;
            }
        }

        MoleFactory moleFactory = new MoleFactory();
        Mole mole = moleFactory.createMole(role,color);
        Backpack backpack=new Backpack();

        mole.setMoleName(name);
        mole.setMoney(2000);
        mole.setTicket(2);
        mole.setScore(0);
        mole.setBackpack(backpack);

        return mole;
    }


}
