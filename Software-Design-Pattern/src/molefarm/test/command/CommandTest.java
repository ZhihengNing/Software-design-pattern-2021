package molefarm.test.command;

import framework.simplefactory.Mole;
import molefarm.common.MoleFarmWarehouse;
import molefarm.pattern.command.Command;
import molefarm.pattern.command.conc.FertilizerCommand;
import molefarm.pattern.command.conc.SeedCommand;

public class CommandTest {
    public static void test(){
        Command fertilizerCommand = new FertilizerCommand();
        Command seedCommand = new SeedCommand();
        System.out.println("----调用命令模式ing----");
        MoleFarmWarehouse warehouse = MoleFarmWarehouse.getInstance(new Mole());
        ((FertilizerCommand) fertilizerCommand).setMoleFarmWarehouse(warehouse);
        System.out.println("正在向商店购买1份高级肥料");
        boolean result = fertilizerCommand.execute("高级肥料", 1);
        System.out.println(result==false?"抱歉，摩尔豆余额不足，购买失败":"恭喜，购买成功！");
        //seedCommand.execute("小麦种子",-1);
    }
    public static void main(String[] args) {
        test();
    }
}
