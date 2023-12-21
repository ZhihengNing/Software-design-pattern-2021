package molemall.pattern.decorator;

import molemall.other.commodities.food.Hamburger;

public class Shrimp extends CondimentDecorator
{
    Hamburger hamburger;
    public Shrimp(Hamburger hamburger)
    {
        this.hamburger = hamburger;
    }
    public String getItem()
    {
        return "鲜虾"+hamburger.getItem();
    }
    public Double getPrice()
    {
        return hamburger.getPrice()+8.0;
    }
    @Override
    public void Purchase()
    {
        System.out.printf("You have bought a shrimp hamburger");
    }
    @Override
    public void transfer()
    {
        System.out.printf("Transfer shrimp hamburger completed");
    }
}
