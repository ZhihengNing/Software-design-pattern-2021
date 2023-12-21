package molemall.test;

import molemall.other.commodities.food.Hamburger;
import molemall.other.shops.FoodShop;
import molemall.other.shops.cart.ShoppingCart;
import molemall.other.utils.JsonUtils;
import molemall.pattern.abstractFactory.AbstractFood;
import molemall.pattern.abstractFactory.factory.FoodFactory;
import molemall.pattern.decorator.Beef;
import molemall.pattern.decorator.Codfish;
import molemall.pattern.decorator.Shrimp;

import java.util.Map;

public class DecoratorTest//汉堡装饰购买测试
{
    private static final ShoppingCart foodCart = ShoppingCart.newInstance();
    private static final FoodFactory foodFactory = FoodFactory.newInstance();
    private static final Map<String, String> map = JsonUtils.searchMapper();
    public static void test(){
        FoodShop foodShop = FoodShop.newInstance();
        ShoppingCart foodCart = ShoppingCart.newInstance();
        System.out.println("----调用装饰器模式ing----");
        System.out.println("欢迎进入食品店购买汉堡！");
        AbstractFood food;
        System.out.println("\n汉堡小料如下：");
        System.out.println("小料名称    牛肉     鳕鱼    鲜虾   不加了");
        System.out.println("额外加价    11.0    8.0    8.0    0.0 \n");
        System.out.println("在汉堡中加入牛肉，购买两个！");
        food = new Beef(new Hamburger());
        foodCart.loadFood(food, 2);
        System.out.println("在汉堡中加入鳕鱼，购买三个！");
        food = new Codfish(new Hamburger());
        foodCart.loadFood(food, 3);
        System.out.println("在汉堡中加入鲜虾，购买四个！");
        food = new Shrimp(new Hamburger());
        foodCart.loadFood(food, 4);
        System.out.println("在汉堡中不加小料，购买一个！");
        food = foodFactory.create(map.get("汉堡"));
        foodCart.loadFood(food, 1);
        foodCart.printReceipt();//打印小票
        //System.out.println("\n——————结束test装饰器模式——————");
    }
    public static void main(String[] args) {
        test();
    }
}
