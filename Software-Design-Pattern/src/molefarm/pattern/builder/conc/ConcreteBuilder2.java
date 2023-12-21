package molefarm.pattern.builder.conc;

import molefarm.common.FarmGrowth;
import molefarm.common.product.AbstractSeed;
import molefarm.common.product.fertilizer.PrimaryFertilizer;
import molefarm.pattern.builder.Builder;

/**
 * 具体建造者2
 */
public class ConcreteBuilder2 extends Builder {
    @Override
    public void buildPlant(AbstractSeed seed) {
        FarmGrowth.plantSeed(seed, farmBlock);
        FarmGrowth.applyFertilizer(new PrimaryFertilizer(), farmBlock);
    }

}
