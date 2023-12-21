package molemall.other.commodities.food;

import molemall.pattern.abstractFactory.AbstractFood;

public class Watermelon extends AbstractFood {

    protected double price;
    protected String item;

    public Watermelon(double price)
    {
        this.price=price;
        this.item="西瓜🍉";
    }

    public Watermelon()
    {
        this.price=22.0;
        this.item="西瓜🍉";
    }
    public Double getPrice() {
        return price;
    }
    public String getItem() {
        return item;
    }

    @Override
    public void Purchase()
    {
        System.out.printf("You have bought a watermelon");
    }

    @Override
    public void transfer()
    {
        System.out.printf("Transfer watermelon completed");
    }

}
