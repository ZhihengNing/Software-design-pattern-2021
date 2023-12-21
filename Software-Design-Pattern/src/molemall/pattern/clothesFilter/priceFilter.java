package molemall.pattern.clothesFilter;

import molemall.pattern.abstractFactory.AbstractClothes;
import java.util.List;
import java.util.ArrayList;

public class priceFilter implements IFilter
{ //过滤价格在start_price至end_price间的商品
    @Override
    public List<AbstractClothes> filter(List<AbstractClothes> clothesList, double start_price, double end_price)
    {
        List<AbstractClothes> result = new ArrayList<>();
        for (AbstractClothes clo : clothesList)
        {
            if (clo.getPrice() >= start_price && clo.getPrice() <= end_price)
            {
                result.add(clo);
            }
        }
        return result;
    }
}


