package molefarm.pattern.builder.conc;

import molefarm.common.FarmGrowth;
import molefarm.common.product.AbstractSeed;
import molefarm.common.product.fertilizer.AdvancedFertilizer;
import molefarm.pattern.builder.Builder;

/**
 * 具体建造着1
 */
public class ConcreteBuilder1 extends Builder {
    @Override
    public void buildPlant(AbstractSeed seed) {
        FarmGrowth.loosenSoil();
        FarmGrowth.plantSeed(seed, farmBlock);
        FarmGrowth.watering(farmBlock);
        FarmGrowth.weed(farmBlock);
        FarmGrowth.applyFertilizer(new AdvancedFertilizer(), farmBlock);
    }
}
