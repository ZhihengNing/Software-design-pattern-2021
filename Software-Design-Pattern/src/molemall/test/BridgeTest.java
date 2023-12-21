package molemall.test;

import molemall.other.commodities.clothes.Jackets;
import molemall.pattern.abstractFactory.AbstractClothes;
import molemall.pattern.bridge.ClothesColor;
import molemall.pattern.bridge.Red;

public class BridgeTest {
    public static void test(){
        System.out.println("----调用桥接模式ing----");
        AbstractClothes clothes=null;
        ClothesColor color=null;
        System.out.println("服装种类：夹克 牛仔裤 短裤 T恤");
        System.out.println("选择夹克");
        System.out.println("颜色：红色 蓝色 黄色");
        System.out.println("选择红色");
        clothes=new Jackets();
        color=new Red();
        clothes.color=color;
        System.out.println("你购买了一件"+clothes.color.color+clothes.getItem());
    }
    public static void main(String[] args) {
        test();
    }
}
