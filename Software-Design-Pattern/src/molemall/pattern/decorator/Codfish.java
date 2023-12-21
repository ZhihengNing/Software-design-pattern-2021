package molemall.pattern.decorator;

import molemall.other.commodities.food.Hamburger;

public class Codfish extends CondimentDecorator
{
    Hamburger hamburger;
    public Codfish(Hamburger hamburger)
    {
        this.hamburger = hamburger;
    }
    public String getItem()
    {
        return "鳕鱼"+hamburger.getItem();
    }
    public Double getPrice()
    {
        return hamburger.getPrice()+8.0;
    }
    @Override
    public void Purchase()
    {
        System.out.printf("You have bought a codfish hamburger");
    }
    @Override
    public void transfer()
    {
        System.out.printf("Transfer codfish hamburger completed");
    }
}
