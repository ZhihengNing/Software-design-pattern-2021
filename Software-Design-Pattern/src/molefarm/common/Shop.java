package molefarm.common;

import molefarm.common.product.AbstractCrops;
import molefarm.common.product.AbstractFertilizer;
import molefarm.common.product.AbstractSeed;
import molefarm.pattern.adapter.conc.MoleAdapter;

/**
 * 商店类
 * 仓库从商店买入种子、肥料
 * 仓库卖出作物到商店
 */
public class Shop {

    private MoleAdapter mole=MoleAdapter.getInstance();

    private MoleFarmWarehouse moleFarmWarehouse= mole.getFarmWarehouse();

    //关联商店与仓库
    private Shop() {
    }

    public static Shop getInstance() {
        return new Shop();
    }

    /**
     * 购买种子
     * @param seed
     * @param num
     * @return
     */
    public boolean buySeeds(AbstractSeed seed, int num) {
        return moleFarmWarehouse.buySeeds(seed, num);
    }

    /**
     * 购买肥料
     * @param fertilizer
     * @param num
     * @return
     */
    public boolean buyFertilizer(AbstractFertilizer fertilizer, int num) {
        return moleFarmWarehouse.buyFertilizer(fertilizer, num);
    }

    /**
     * 售卖作物
     * @param crops
     * @param num
     * @return
     */
    public boolean sellCrops(AbstractCrops crops, int num) {
        return moleFarmWarehouse.sellCrops(crops, num);
    }
}
