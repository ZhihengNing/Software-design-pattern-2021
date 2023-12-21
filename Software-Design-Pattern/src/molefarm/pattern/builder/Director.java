package molefarm.pattern.builder;

import molefarm.common.MoleFarmBlock;
import molefarm.common.product.AbstractSeed;

public class Director {
    private Builder builder;

    private MoleFarmBlock farmBlock;

    public Director(Builder builder, MoleFarmBlock farmBlock) {
        this.builder = builder;
        this.farmBlock = farmBlock;
    }
    
    public void setBuilder(Builder builder) {
        this.builder = builder;
    }

    public void setFarmBlock(MoleFarmBlock farmBlock) {
        this.farmBlock = farmBlock;
    }

    public void getMoleFarmBlock(AbstractSeed seed) {
        //要先初始化农田块
        builder.setFarmBlock(farmBlock);
        builder.buildPlant(seed);
    }
}
