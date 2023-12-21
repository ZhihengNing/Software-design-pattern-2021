package molemall.other.shops;

import molemall.pattern.abstractFactory.AbstractFood;
import molemall.pattern.abstractFactory.factory.FoodFactory;
import molemall.other.commodities.food.Hamburger;
import molemall.other.commodities.food.Soda;
import molemall.other.commodities.food.Watermelon;
import molemall.pattern.decorator.Beef;
import molemall.pattern.decorator.Codfish;
import molemall.pattern.decorator.Shrimp;
import molemall.other.shops.cart.ShoppingCart;
import molemall.other.utils.JsonUtils;

import java.util.*;

/**
 * 食品店
 *
 */
public class FoodShop extends Shop{
    private static final FoodFactory foodFactory = FoodFactory.newInstance();
    private static final ShoppingCart foodCart = ShoppingCart.newInstance();
    private static final Map<String, String> map = JsonUtils.searchMapper();

    private List<AbstractFood> foodList= new ArrayList<>();


    private static volatile FoodShop foodShop = new FoodShop();

    public static synchronized FoodShop newInstance() {
        return foodShop;
    }

    private FoodShop() {
        foodList.add(new Hamburger());
        foodList.add(new Soda());
        foodList.add(new Watermelon());
    }
    public static void createFood(String name){
        AbstractFood food;
        food=foodFactory.create( map.get(name));
        if(name.equals("汉堡"))
        {
            System.out.println("你想要在汉堡中加料么？（按y加料）");
            Scanner input=new Scanner(System.in);
            String in = input.next();
            if (in.equals("y"))
            {
                showMaterial();
                System.out.println("要在汉堡中加入哪个小料呢（要加钱哦）：");
                String materialName = input.next();
                if(materialName.equals("牛肉"))
                {
                    food= new Beef(new Hamburger());
                }
                else if(materialName.equals("鳕鱼"))
                {
                    food= new Codfish(new Hamburger());
                }
                else if(materialName.equals("鲜虾"))
                {
                    food= new Shrimp(new Hamburger());
                }
                else if(materialName.equals("不加了"))
                {
                    materialName="";
                }
                else
                {
                    System.out.println("没有这个小料哦");
                    materialName="";
                }
                System.out.println("请输入你要购买"+materialName+"汉堡的数量");
            }
            else System.out.println("请输入你要购买"+name+"的数量");
        }
        else
        {
            System.out.println("请输入你要购买"+name+"的数量");
        }
        while(true){
        Scanner input=new Scanner(System.in);
        int num=input.nextInt();
        if(num<=0){
            System.out.println("输入数量应为正数");
            continue;
        }
        foodCart.loadFood(food,num);
        break;
        }
    }
    public void checkout(){
        foodCart.printReceipt();
        Double realPrice=foodCart.getPrice();
        foodCart.consume(realPrice,"food");//消费确认
    }

    public void showFoodShop() {
        System.out.println("食品店售卖情况如下：\n");
        System.out.print("食品名称\t\t");
        for (int i =0;i< foodList.size(); i++) {
            System.out.print(String.format("%-10s",foodList.get(i).getItem()));
        }
        System.out.print("\n食品价格\t\t");
        for (int i =0;i< foodList.size(); i++) {
            System.out.print(String.format("%-11s",foodList.get(i).getPrice()));
        }

    }
    public static void showMaterial()
    {
        System.out.println("小料名称    牛肉     鳕鱼    鲜虾   不加了");
        System.out.println("额外加价    11.0    8.0    8.0    0.0 \n");
    }
}
