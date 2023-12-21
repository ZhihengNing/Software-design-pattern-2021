package molemall.test;

import molemall.other.shops.ClothesShop;
import molemall.other.shops.cart.ShoppingCart;
import molemall.other.utils.JsonUtils;
import molemall.pattern.abstractFactory.factory.ClothesFactory;

import java.util.Map;

public class ClothesFilterTest {
    private static final ClothesFactory clothesFactory = ClothesFactory.newInstance();
    private static final ShoppingCart clothesPurchaseCart = ShoppingCart.newInstance();
    private static final ShoppingCart clothesLeaseCart = ShoppingCart.newInstance();
    private static final Map<String, String> map = JsonUtils.searchMapper();
    public static void test(){
        ClothesShop clothesShop = ClothesShop.newInstance();
        ShoppingCart Cart = ShoppingCart.newInstance();
        System.out.println("----调用过滤器模式ing----");
        System.out.println("欢迎进入服装店！");
        System.out.println("服装店售卖情况如下：\n");
        clothesShop.showClothesShop();
        System.out.println("\n\n1.按照价格≤100过滤");
        clothesShop.filterClothes(0,100);
        System.out.println("\n\n2.按照价格≥120过滤");
        clothesShop.filterClothes(120,99999);
        System.out.println("\n\n3.按照价格在50-150过滤");
        clothesShop.filterClothes(50,150);
        //System.out.println("\n——————结束test过滤器模式——————");
    }
    public static void main(String[] args) {
        test();
    }
}
