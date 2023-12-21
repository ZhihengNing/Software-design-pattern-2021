package molemall.other.commodities.food;

import molemall.pattern.abstractFactory.AbstractFood;

public class Hamburger extends AbstractFood {
    protected double price;
    protected String item;

    public Hamburger(double price)
    {
        this.price=price;
        this.item="汉堡🍔";
    }

    public Hamburger()
    {
        this.price=12.0;
        this.item="汉堡🍔";
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
        System.out.printf("You have bought a hamburger");
    }

    @Override
    public void transfer()
    {
        System.out.printf("Transfer hamburger completed");
    }
}
