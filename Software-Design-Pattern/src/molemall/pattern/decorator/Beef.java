package molemall.pattern.decorator;

import molemall.other.commodities.food.Hamburger;

public class Beef extends CondimentDecorator
{
    Hamburger hamburger;
    public Beef(Hamburger hamburger)
    {
        this.hamburger = hamburger;
    }
    public String getItem()
    {
        return "牛肉"+hamburger.getItem();
    }
    public Double getPrice()
    {
        return hamburger.getPrice()+11.0;
    }
    @Override
    public void Purchase()
    {
        System.out.printf("You have bought a beef hamburger");
    }
    @Override
    public void transfer()
    {
        System.out.printf("Transfer beef hamburger completed");
    }
}
