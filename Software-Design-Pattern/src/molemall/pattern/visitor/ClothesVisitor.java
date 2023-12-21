package molemall.pattern.visitor;

import molemall.other.shops.cart.ShoppingCart;
import molemall.pattern.abstractFactory.AbstractClothes;

public interface ClothesVisitor {
    public <T extends ShoppingCart> void visit(T t);
//    public void visit(Jackets jackets);
//    public void visit(Tshirt tshirt);
//    public void visit(Jeans jeans);
//    public void visit(Shorts shorts);

}
