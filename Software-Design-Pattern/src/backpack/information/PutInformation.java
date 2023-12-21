package backpack.information;

import backpack.MVC.BackpackController;
import backpack.MVC.BackpackView;
import framework.simplefactory.Mole;
public class PutInformation {
    public void showMoleInformation(Mole mole,BackpackController controller){
        System.out.println("\n小摩尔基础属性：");
        System.out.println("名称："+mole.getMoleName());
        System.out.println("角色："+mole.getMoleRole().getRole());
        System.out.println("颜色："+mole.getMoleColor().getColor());
        System.out.println("摩尔豆："+mole.getMoney());
        System.out.println("游戏积分："+mole.getScore());
        System.out.printf("%-15s\t%s\n","背包物品" ,"数量");
        System.out.printf("%-15s\t%d\n","游乐园门票" ,mole.getTicket());
        controller.updateView();
        System.out.print("\n\n\n");
    }
}
