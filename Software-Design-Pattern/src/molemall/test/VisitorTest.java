package molemall.test;

import framework.simplefactory.Mole;
import molemall.other.commodities.clothes.Jackets;
import molemall.other.commodities.clothes.Jeans;
import molemall.other.commodities.clothes.Shorts;
import molemall.other.commodities.clothes.Tshirt;
import molemall.other.shops.cart.ShoppingCart;
import molemall.pattern.abstractFactory.AbstractClothes;
import molemall.pattern.visitor.ClothesLeaseVisitor;
import molemall.pattern.visitor.ClothesPurchaseVisitor;
import molemall.pattern.visitor.ClothesVisitor;

import java.util.ArrayList;
import java.util.List;

public class VisitorTest {
    private static final ShoppingCart clothesPurchaseCart = ShoppingCart.newInstance();
    private static final ShoppingCart clothesLeaseCart = ShoppingCart.newInstance();
    private static List<AbstractClothes> clothesList= new ArrayList<>();

    public static void test(){
        System.out.println("----调用访问者模式ing----");
        clothesList.add(new Jackets());
        clothesList.add(new Tshirt());
        clothesList.add(new Jeans());
        clothesList.add(new Shorts());
        for(int i=0;i<clothesList.size();i++){
            clothesPurchaseCart.loadClothes(clothesList.get(i),1);
            clothesLeaseCart.loadClothes(clothesList.get(i),1);
        }
        ClothesVisitor Pvisitor=new ClothesPurchaseVisitor();
        clothesPurchaseCart.accept(Pvisitor);//访问者模式
        ClothesVisitor Lvisitor=new ClothesLeaseVisitor();
        clothesLeaseCart.accept(Lvisitor);//访问者模式
    }
    public static void main(String[] args){//测试用
        test();
    }
}
