package molemall.other.commodities.seed;

import molemall.pattern.abstractFactory.AbstractSeed;

public class Carrot implements AbstractSeed {

    protected String item;
    protected double price;

    public Carrot()
    {
        this.item="carrot";
        this.price=0;
    }

    public Carrot(double price)
    {
        this.item="carrot";
        this.price=price;
    }

    @Override
    public void transfer() {
        System.out.printf("You have transferred a carrot seed");
    }

    @Override
    public void Purchase() {
        System.out.printf("You have bought a carrot seed");
    }
}
