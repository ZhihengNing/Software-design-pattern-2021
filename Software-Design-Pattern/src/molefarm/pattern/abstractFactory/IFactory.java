package molefarm.pattern.abstractFactory;

import molefarm.common.exception.factory.FactoryNotFoundException;
import molefarm.common.exception.product.FactoryNotProduceException;
import molefarm.common.product.AbstractCrops;
import molefarm.common.product.AbstractFertilizer;
import molefarm.common.product.AbstractSeed;
import molefarm.common.product.AbstractTool;
import molefarm.common.utils.JsonOp;

/**
 * 抽象农场工厂
 */
public interface IFactory {
    String PATH = JsonOp.getPathJson("IFactory");

    String MSG = JsonOp.getMsgJson("IFactory");

    /**
     * 生产作物
     *
     * @return
     */
    AbstractCrops createCrops(String name) throws FactoryNotProduceException;

    /**
     * 产生种子
     *
     * @return
     */
    AbstractSeed createSeed(String name) throws FactoryNotProduceException;

    /**
     * 产生肥料
     *
     * @return
     */
    AbstractFertilizer createFertilier(String name) throws FactoryNotProduceException;

    /**
     * 生产工具
     *
     * @return
     */
    AbstractTool createTool(String name) throws FactoryNotProduceException;

    /**
     * 根据工厂名字生成对应具体工厂，这里具体工厂一定要和concreteFactory放在一个包下面
     *
     * @param factoryName
     * @param <T>
     * @return
     */
    static <T extends IFactory> T newConcreteFactory(String factoryName) throws FactoryNotFoundException {
        T iFactory = null;
        try {
            Class<T> aClass = (Class<T>) Class.forName(PATH + factoryName);
            try {
                iFactory = aClass.newInstance();
            } catch (InstantiationException | IllegalAccessException e) {
                e.printStackTrace();
            }
        } catch (ClassNotFoundException e) {
            throw new FactoryNotFoundException(MSG);
        }
        return iFactory;
    }
}
