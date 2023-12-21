package molefarm.pattern.command.conc;

import molefarm.Home;
import molefarm.common.MoleFarmWarehouse;
import molefarm.common.exception.product.conc.FertilizerNotFoundException;
import molefarm.common.product.AbstractFertilizer;
import molefarm.common.utils.JsonOp;
import molefarm.pattern.adapter.conc.MoleAdapter;
import molefarm.pattern.command.Command;
import molefarm.pattern.factory.conc.FertilizerFactory;

import java.util.Map;

/**
 * 具体命令
 * 仓库向商店发生请求，进货肥料
 */
public class FertilizerCommand implements Command {
    private FertilizerFactory fertilizerFactory = FertilizerFactory.newInstance();
    /**
     * 命令接收方，仓库
     */
    private MoleFarmWarehouse moleFarmWarehouse = MoleAdapter.getInstance().getFarmWarehouse();

    public void setMoleFarmWarehouse(MoleFarmWarehouse moleFarmWarehouse) {
        this.moleFarmWarehouse = moleFarmWarehouse;
    }

    /**
     * 商店接收命令，为仓库买入肥料
     *
     * @param name
     * @param num
     */

    public boolean execute(String name, int num) {
        AbstractFertilizer fertilizer =null;
        try{
            fertilizer = fertilizerFactory.create(Home.fertilizerMap.get(name));
        } catch (FertilizerNotFoundException e){e.printStackTrace();}
        return moleFarmWarehouse.buyFertilizer(fertilizer, num);
    }

}
