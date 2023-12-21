package framework.composite;

import java.util.ArrayList;

public class MenuOption extends Component {
    // 菜单操作类

    private String name;
    private Menu lastMenu;

    public MenuOption(String name) {
        this.name = name;
        this.lastMenu = null;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void add(Component... component) {
        super.add(component);
    }

    @Override
    public Menu getLast() {
        return lastMenu;
    }


    @Override
    public void printMenu() {
        super.printMenu();
    }

    @Override
    public void setLastMenu(Menu lastMenu) {
        this.lastMenu = lastMenu;
    }

    @Override
    public ArrayList<Component> getMenu() {
        return null;
    }

    @Override
    public Component moveTo(int index){return this;}

}
