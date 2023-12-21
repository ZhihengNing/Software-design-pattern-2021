package molemall.pattern.abstractFactory.factory;

import molemall.pattern.abstractFactory.AbstractClothes;
import molemall.pattern.abstractFactory.AbstractFactory;
import molemall.pattern.abstractFactory.AbstractFood;
import molemall.pattern.abstractFactory.AbstractSeed;
import molemall.pattern.bridge.ClothesColor;
import molemall.other.commodities.seed.Cabbage;
import molemall.other.commodities.seed.Carrot;
import molemall.other.commodities.seed.Corn;
import molemall.other.utils.JsonUtils;

import java.util.Objects;

public class SeedFactory implements AbstractFactory {
    final static String PATH = JsonUtils.getPathJson("Seed");
    @Override
    public AbstractFood CreateFood(String FoodType, double Price) {
        return null;
    }

    @Override
    public AbstractClothes CreateClothes(String ClothesType, Double Price, ClothesColor color) {
        return null;
    }

    public AbstractSeed CreateSeed(String item, double Price)
    {
        AbstractSeed seed=null;
        if(Objects.equals(item, "cabbage"))
        {
            seed=new Cabbage(Price);
        }
        else if(Objects.equals(item, "carrot"))
        {
            seed=new Carrot(Price);
        }
        else if(Objects.equals(item, "corn"))
        {
            seed=new Corn(Price);
        }
        return seed;
    }

    /**
     * 根据种子的名字生产对应的种子
     *
     * @param item
     * @return
     */
    @Override
    public AbstractClothes create(String item) {
        return AbstractFactory.createCommodity(PATH + item);
    }
}
