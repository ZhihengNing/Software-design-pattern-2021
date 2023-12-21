package framework.simplefactory;

import framework.simplefactory.color.Color;
import framework.simplefactory.role.Role;
import backpack.MVC.*;

import java.util.Map;

//摩尔角色相关信息
public class Mole {
    private String MoleName;      //名字
    private Role MoleRole;      //角色
    private Color MoleColor;      //颜色
    private double money;      //摩尔豆
    private int ticket;      //游乐园票数
    private int score;      //游戏积分
    private Backpack backpack;//背包

    public Mole(){
    }

    //set和get函数
    public void setMoleName(String moleName){
        MoleName=moleName;
    };
    public String getMoleName(){return MoleName;}

    public void setMoleColor(Color moleColor) {
         MoleColor=moleColor;
    }
    public Color getMoleColor(){return MoleColor;}

    public void setMoleRole(Role moleRole){
        MoleRole=moleRole;
    }
    public Role getMoleRole(){return MoleRole;}

    public void setMoney(double money){
        this.money=money;
    }
    public double getMoney(){return money;}

    public void setTicket(int ticket){
        this.ticket=ticket;
    }
    public int getTicket(){return ticket;}

    public void setScore(int score){this.score=score;}
    public int getScore(){return score;}

    public void setBackpack(Backpack backpack){this.backpack=backpack;}
    public Backpack getBackpack(){return backpack;}

}
