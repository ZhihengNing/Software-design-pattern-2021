package molemall.pattern.visitor;

import molemall.other.shops.ClothesShop;
import molemall.other.shops.cart.ShoppingCart;
import molemall.pattern.abstractFactory.AbstractClothes;

public class ClothesLeaseVisitor implements ClothesVisitor {
    @Override
    public <T extends ShoppingCart> void visit(T t) {
        //System.out.println("您选择了租赁");//租赁接口放置
        Double lPrice=t.printLeaseReceipt();
    }

}
