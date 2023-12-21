package molemall.other.commodities.clothes;

import molemall.pattern.abstractFactory.AbstractClothes;
import molemall.pattern.bridge.ClothesColor;
import molemall.pattern.visitor.ClothesVisitor;

/**
 * 夹克
 */
public class Jackets extends AbstractClothes {


    public void setColor(ClothesColor color)
    {
        this.color = color;
    }

    public Jackets()
    {
        this.item="夹克";
        this.color=null;
        this.style="upper";
        this.price=200.0;
    }

    public  Jackets(ClothesColor color, Double price)
    {
        this.item="夹克";
        this.style="upper";
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
