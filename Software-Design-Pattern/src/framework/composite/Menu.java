package framework.composite;

import java.util.ArrayList;

public class Menu extends Component {
    //菜单类，下可包含菜单和操作

    private String menuName;
    private Menu lastMenu;
    private ArrayList<Component> menu;

    public Menu(String menuName) {
        this.menuName = menuName;
        this.lastMenu = null;
        this.menu = new ArrayList<Component>();
    }

    @Override
    public String getName() {
        return menuName;
    }

    @Override
    public void add(Component... component) {
        for (Component i : component){
            menu.add(i);
            i.setLastMenu(this);
        }
    }

    @Override
    public void printMenu() {
        //打印菜单
        System.out.println("----- " + this.menuName + " -----");

        // 循环打印选项
        int i = 0;
        for (Component item : menu) {
            i++;
            System.out.print(i + " ----- " + item.getName());
            if (item.getMenu() != null) {
                System.out.print("*");
            }
            System.out.println();
        }
        if (lastMenu != null) System.out.println("0 ----- 返回" + lastMenu.getName());
        else System.out.println("0 ----- 退出游戏");
    }

    public Menu getLast() {
        // root menu returns null
        return lastMenu;
    }

    @Override
    public void setLastMenu(Menu lastMenu) {
        this.lastMenu = lastMenu;
    }

    @Override
    public ArrayList<Component> getMenu() {
        return menu;
    }

    /**
     *
     */
    @Override
    public Component moveTo(int index){
        if (index >= menu.size() || index < 0) {return menu.get(0);}
        return menu.get(index);
    }
}
