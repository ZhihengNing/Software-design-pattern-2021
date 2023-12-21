package molemall.pattern.bridge;

import exceptionhandle.ExceptionHandle;
import molemall.other.commodities.clothes.Jackets;
import molemall.other.commodities.clothes.Jeans;
import molemall.other.commodities.clothes.Shorts;
import molemall.other.commodities.clothes.Tshirt;
import molemall.pattern.abstractFactory.AbstractClothes;

import java.util.Scanner;

public class BridgeTestDemo {
    public static void main(String[] args)
    {
        AbstractClothes clothes=null;
        ClothesColor color=null;
        while(true)
        {
            System.out.println("请选择服装：[1]夹克 [2]牛仔裤 [3]短裤 [4]T恤");
            Scanner input=new Scanner(System.in);
            ExceptionHandle exceptionHandle = new ExceptionHandle();
            int Select = exceptionHandle.exception();
            if(Select==1)
            {
                clothes=new Jackets();
                break;
            }
            else if(Select==2)
            {
                clothes=new Jeans();
                break;
            }
            else if(Select==3)
            {
                clothes=new Shorts();
                break;
            }
            else if(Select==4)
            {
                clothes=new Tshirt();
                break;
            }
            else
            {
                System.out.println("请选择正确的服装！");
            }
        }
        while(true)
        {
            System.out.println("请选择颜色：[1]红色 [2]蓝色 [3]黄色");
            Scanner input=new Scanner(System.in);
            ExceptionHandle exceptionHandle = new ExceptionHandle();
            int Select = exceptionHandle.exception();
            if(Select==1)
            {
                color=new Red();
                break;
            }
            else if(Select==2)
            {
                color=new Blue();
                break;
            }
            else if(Select==3)
            {
                color=new Yellow();
                break;
            }
            else
            {
                System.out.println("请输入正确的颜色！");
            }
        }
        clothes.color=color;
        System.out.println("你购买了一件"+clothes.color.color+clothes.getItem());
    }
}
