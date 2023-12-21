package molefarm.pattern.command.conc;

import molefarm.Home;
import molefarm.common.MoleFarmWarehouse;
import molefarm.common.exception.product.conc.SeedNotFoundException;
import molefarm.common.product.AbstractSeed;
import molefarm.common.utils.JsonOp;
import molefarm.pattern.adapter.conc.MoleAdapter;
import molefarm.pattern.command.Command;
import molefarm.pattern.factory.conc.SeedFactory;

import java.util.Map;

/**
 * 具体命令
 * 仓库发送请求，从商店进货种子
 */
public class SeedCommand implements Command {
    private SeedFactory seedFactory = SeedFactory.newInstance();
    /**
     * 命令接收方，仓库
     */
    private MoleFarmWarehouse moleFarmWarehouse = MoleAdapter.getInstance().getFarmWarehouse();

    /**
     * 商店接收命令，为仓库买入种子
     *
     * @param name
     * @param num
     */
    public boolean execute(String name, int num) {
        AbstractSeed seed =null;
        try{
            seed = seedFactory.create(Home.seedMap.get(name));
        } catch (SeedNotFoundException e){e.printStackTrace();}
        return moleFarmWarehouse.buySeeds(seed, num);
    }
}
