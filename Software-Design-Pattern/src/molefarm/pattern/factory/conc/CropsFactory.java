package molefarm.pattern.factory.conc;

import molefarm.common.exception.MyException;
import molefarm.common.exception.product.ProductNotFoundException;
import molefarm.common.exception.product.conc.CropsNotFoundException;
import molefarm.common.product.AbstractCrops;
import molefarm.common.utils.JsonOp;
import molefarm.pattern.factory.Factory;

/**
 * 作物的抽象工厂类，此处不再写具体工厂类，如CabbageFactory；
 */
public class CropsFactory implements Factory {
    private final static String PATH = JsonOp.getPathJson("CropsFactory");
    private final static String MSG = JsonOp.getMsgJson("CropsFactory");
    private static volatile CropsFactory cropsFactory;

    public synchronized static CropsFactory newInstance() {
        if (cropsFactory == null) {
            cropsFactory = new CropsFactory();
        }
        return cropsFactory;
    }

    /**
     * 根据作物的名字生产对应的作物
     *
     * @param name
     * @return
     * @throws MyException
     */
    @Override
    public AbstractCrops create(String name) throws CropsNotFoundException {
        try {
            return Factory.createProduct(PATH + name);
        } catch (ProductNotFoundException e) {
            throw new CropsNotFoundException(MSG);
        }
    }
}
