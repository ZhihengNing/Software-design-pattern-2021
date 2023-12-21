package molefarm;

import molefarm.common.Shop;
import molefarm.common.utils.JsonOp;
import molefarm.pattern.factory.conc.CropsFactory;
import molefarm.pattern.factory.conc.FertilizerFactory;
import molefarm.pattern.factory.conc.SeedFactory;
import molefarm.pattern.factory.conc.ToolFactory;

import java.util.Map;

public class Home {

    public static Shop shop = Shop.getInstance();

    public static SeedFactory seedFactory = SeedFactory.newInstance();

    public static CropsFactory cropsFactory = CropsFactory.newInstance();

    public static FertilizerFactory fertilizerFactory = FertilizerFactory.newInstance();

    public static ToolFactory toolFactory = ToolFactory.newInstance();

    public static final Map<String, String> seedMap = JsonOp.searchMapper("Seed");

    public static final Map<String, String> cropsMap = JsonOp.searchMapper("Crops");

    public static final Map<String, String> fertilizerMap = JsonOp.searchMapper("Fertilizer");

    public static final Map<String, String> toolMap = JsonOp.searchMapper("Tool");

}
