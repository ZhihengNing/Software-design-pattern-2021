package molefarm.test.proxy;

import framework.simplefactory.Mole;
import molefarm.common.MoleFarmWarehouse;
import molefarm.pattern.command.Command;
import molefarm.pattern.command.conc.FertilizerCommand;
import molefarm.pattern.proxy.Proxy;

public class ProxyTest {
    public static void test(){
        Proxy proxy = new Proxy();
        Command fertilizerCommand = new FertilizerCommand();
        MoleFarmWarehouse warehouse = MoleFarmWarehouse.getInstance(new Mole());
        ((FertilizerCommand) fertilizerCommand).setMoleFarmWarehouse(warehouse);
        proxy.setFertilizerCommand((FertilizerCommand)fertilizerCommand);
        System.out.println("----调用代理模式ing----");
        System.out.println("正在向商店购买10份中级肥料");
        boolean result = proxy.fertilizerPurchase("中级肥料", 10);
        System.out.println(result==false?"抱歉，摩尔豆余额不足，购买失败":"恭喜，购买成功！");
        //proxy.seedPurchase("草莓种子",-1);
    }
    public static void main(String[] args) {
        test();
    }
}
