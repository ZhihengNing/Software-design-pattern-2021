package molemall.other.commodities.seed;

import molemall.pattern.abstractFactory.AbstractSeed;

public class Corn implements AbstractSeed {

    protected String item;
    protected double price;

    public Corn()
    {
        this.item="corn";
        this.price=0;
    }

    public Corn(double price)
    {
        this.item="corn";
        this.price=price;
    }

    @Override
    public void transfer() {
        System.out.printf("You have transferred a corn seed");
    }

    @Override
    public void Purchase() {
        System.out.printf("You have bought a corn seed");
    }
}
