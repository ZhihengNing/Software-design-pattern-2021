package molemall.other.commodities.clothes;

import molemall.pattern.abstractFactory.AbstractClothes;
import molemall.pattern.bridge.ClothesColor;
import molemall.pattern.visitor.ClothesVisitor;

public class Tshirt extends AbstractClothes {


    public void setColor(ClothesColor color)
    {
        this.color = color;
    }

    public Tshirt()
    {
        this.item="衬衫";
        this.color=null;
        this.style="nbber";
        this.price=70.0;
    }

    public  Tshirt(ClothesColor color, Double price)
    {
        this.item="衬衫";
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
