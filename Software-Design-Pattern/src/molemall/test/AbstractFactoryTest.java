package molemall.test;

import molemall.pattern.abstractFactory.AbstractFactory;
import molemall.pattern.abstractFactory.AbstractFood;
import molemall.pattern.abstractFactory.factory.FoodFactory;

public class AbstractFactoryTest {
    public static void test(){
        System.out.println("----调用抽象工厂模式ing----");
        System.out.println("商品种类：食品 服装");
        System.out.println("选择食品种类");
        System.out.println("食品种类：汉堡 苏打水 西瓜");
        System.out.println("选择汉堡");
        AbstractFactory Factory=new FoodFactory();
        AbstractFood food=Factory.CreateFood("Hamburger",0);
        food.Purchase();
        /*while(true)
        {
            System.out.println("请输入你要购买商品的种类：[1]食品 [2]服装");
            Scanner input=new Scanner(System.in);
            int Select = input.nextInt();
            if(Select==1)
            {
                AbstractFactory Factory=new FoodFactory();
                while(true)
                {
                    System.out.println("请输入你要购买的食品：[1]汉堡 [2]苏打水 [3]西瓜");
                    Scanner input1=new Scanner(System.in);
                    ExceptionHandle exceptionHandle = new ExceptionHandle();
                    int Select1 = exceptionHandle.exception();
                    if(Select1==1)
                    {
                        AbstractFood food=Factory.CreateFood("Hamburger",0);
                        food.Purchase();
                        break;
                    }
                    else if(Select1==2)
                    {
                        AbstractFood food=Factory.CreateFood("Soda",0);
                        food.Purchase();
                        break;
                    }
                    else if(Select1==3)
                    {
                        AbstractFood food=Factory.CreateFood("Watermelon",0);
                        food.Purchase();
                        break;
                    }
                    else
                    {
                        System.out.println("没有该食品，请重新输入！");
                    }
                }
                break;
            }
            else if(Select==2)
            {
                AbstractFactory Factory=new ClothesFactory();
                while(true)
                {
                    System.out.println("请输入你要购买的服装：[1]夹克 [2]牛仔裤 [3]短裤 [4]T恤");
                    Scanner input1=new Scanner(System.in);
                    ExceptionHandle exceptionHandle = new ExceptionHandle();
                    int Select1 = exceptionHandle.exception();
                    if(Select1==1)
                    {
                        AbstractClothes clothes=Factory.CreateClothes("Jacket",0.00,null);
                        clothes.Purchase();
                        break;
                    }
                    else if(Select1==2)
                    {
                        AbstractClothes clothes=Factory.CreateClothes("Jean",0.00,null);
                        clothes.Purchase();
                        break;
                    }
                    else if(Select1==3)
                    {
                        AbstractClothes clothes=Factory.CreateClothes("Short",0.00,null);
                        clothes.Purchase();
                        break;
                    }
                    else if(Select1==4)
                    {
                        AbstractClothes clothes=Factory.CreateClothes("Tshirt",0.00,null);
                        clothes.Purchase();
                        break;
                    }
                    else
                    {
                        System.out.println("没有该服装，请重新输入！");
                    }
                }
                break;
            }
            else
            {
                System.out.println("没有该种类商品，请重新选择！");
            }
        }

         */
        System.out.println("\n");
    }
    public static void main(String[] args) {
      test();
    }
}
