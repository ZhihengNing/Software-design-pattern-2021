package framework.composite;

import java.util.ArrayList;

//组合模式：菜单和菜单选项的组合
public abstract class Component {

    public abstract String getName();

    public void add(Component... component){
        System.out.println("");
    }

    //获取上一级菜单
    public abstract Menu getLast();

    public void printMenu(){
        System.out.println("");
    }

    //设置上一级菜单
    public void setLastMenu(Menu lastMenu){
        System.out.println("");
    }
    public abstract Component moveTo(int index);

    public ArrayList<Component> getMenu(){return null;}
}
