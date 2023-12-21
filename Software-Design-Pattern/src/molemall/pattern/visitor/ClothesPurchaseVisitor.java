package molemall.pattern.visitor;

import molemall.other.shops.ClothesShop;
import molemall.other.shops.cart.ShoppingCart;

public class ClothesPurchaseVisitor implements ClothesVisitor {
    @Override
    public <T extends ShoppingCart> void visit(T t) {
        //System.out.println("您选择了购买");//购买接口放置
        Double pPrice=t.printPurchaseReceipt();
    }

}

