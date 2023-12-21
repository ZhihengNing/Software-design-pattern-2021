package molefarm.pattern.abstractFactory.conc;

import molefarm.Home;
import molefarm.common.exception.factory.FactoryNotFoundException;
import molefarm.common.exception.product.FactoryNotProduceException;
import molefarm.common.exception.product.conc.CropsNotFoundException;
import molefarm.common.exception.product.conc.FertilizerNotFoundException;
import molefarm.common.exception.product.conc.SeedNotFoundException;
import molefarm.common.exception.product.conc.ToolNotFoundException;
import molefarm.common.product.AbstractCrops;
import molefarm.common.product.AbstractFertilizer;
import molefarm.common.product.AbstractSeed;
import molefarm.common.product.AbstractTool;
import molefarm.pattern.abstractFactory.IFactory;
import molefarm.pattern.factory.conc.CropsFactory;
import molefarm.pattern.factory.conc.FertilizerFactory;
import molefarm.pattern.factory.conc.SeedFactory;
import molefarm.pattern.factory.conc.ToolFactory;

import java.util.Arrays;
import java.util.List;

/**
 * 具体生产种子，肥料，农具的工厂
 * 生产茄子、西瓜、小麦的作物及种子
 * 生产中初级肥料
 * 生产锄头
 * 此类生产产品去moleFarm.pattern.factory.conc下的对应工厂调用方法
 */
public class ConcreteFactory2 implements IFactory {
    private final List<String> cropsList = Arrays.asList("Eggplant", "Watermelon", "Wheat");
    private final List<String> seedList = Arrays.asList("EggplantSeed", "WatermelonSeed", "WheatSeed");
    private final List<String> fertilizerList = Arrays.asList("MiddleFertilizer", "PrimaryFertilizer");
    private final List<String> toolList = Arrays.asList("Hoe");
    private final CropsFactory cropsFactory = Home.cropsFactory;
    private final SeedFactory seedFactory = Home.seedFactory;
    private final FertilizerFactory fertilizerFactory = Home.fertilizerFactory;
    private final ToolFactory toolFactory =Home.toolFactory;
    public static ConcreteFactory2 newInstance() throws FactoryNotFoundException {
        return IFactory.newConcreteFactory("ConcreteFactory2");
    }

    @Override
    public AbstractCrops createCrops(String name) throws FactoryNotProduceException {
        if (cropsList.contains(name)) {
            try {
                return cropsFactory.create(name);
            } catch (CropsNotFoundException e) {
                e.printStackTrace();
            }
        }
        throw new FactoryNotProduceException("此工厂不生产该作物");
    }

    @Override
    public AbstractSeed createSeed(String name) throws FactoryNotProduceException {
        if (seedList.contains(name)) {
            try {
                return seedFactory.create(name);
            } catch (SeedNotFoundException e) {
                e.printStackTrace();
            }
        }
        throw new FactoryNotProduceException("此工厂不生产该种子");
    }

    @Override
    public AbstractFertilizer createFertilier(String name) throws FactoryNotProduceException {
        if (fertilizerList.contains(name)) {
            try {
                return fertilizerFactory.create(name);
            } catch (FertilizerNotFoundException e) {
                e.printStackTrace();
            }
        }
        throw new FactoryNotProduceException("此工厂不生产该肥料");
    }

    @Override
    public AbstractTool createTool(String name) throws FactoryNotProduceException {
        if (toolList.contains(name)) {
            try {
                return toolFactory.create(name);
            } catch (ToolNotFoundException e) {
                e.printStackTrace();
            }
        }
        throw new FactoryNotProduceException("此工厂不生产该工具");
    }
}

