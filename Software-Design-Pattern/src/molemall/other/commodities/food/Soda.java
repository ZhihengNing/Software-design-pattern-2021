package molemall.other.commodities.food;

import molemall.pattern.abstractFactory.AbstractFood;

public class Soda extends AbstractFood {
    protected double price;
    protected String item;

    public Soda(double price)
    {
        this.price=price;
        this.item="苏打水🥤";
    }

    public Soda()
    {
        this.price=6.0;
        this.item="苏打水🥤";
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
        System.out.printf("You have bought a Soda");
    }

    @Override
    public void transfer()
    {
        System.out.printf("Transfer Soda completed");
    }
}
