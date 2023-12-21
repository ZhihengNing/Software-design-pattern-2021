package molemall.other.commodities.clothes;

import molemall.pattern.abstractFactory.AbstractClothes;
import molemall.pattern.bridge.ClothesColor;
import molemall.pattern.visitor.ClothesVisitor;

public class Jeans extends AbstractClothes {


    public void setColor(ClothesColor color)
    {
        this.color = color;
    }

    public Jeans()
    {
        this.item="牛仔裤";
        this.color=null;
        this.style="nbber";
        this.price=120.0;
    }

    public  Jeans(ClothesColor color, Double price)
    {
        this.item="牛仔裤";
        this.style="nbber";
        this.price=price;
        setColor(color);
    }
    public Double getPrice() {
        return price;
    }
    public String getItem() {
        return item;
    }
    public String getColor(){return color.color;}
    public void setItem(){this.item=this.color.color+this.item;}
    @Override
    public void Purchase() {
        System.out.printf("You have bought a "+this.color.color+" "+this.item);
    }

    @Override
    public void transfer() {
        System.out.printf("You have transferred a "+this.color.color+" "+this.item);
    }

}
