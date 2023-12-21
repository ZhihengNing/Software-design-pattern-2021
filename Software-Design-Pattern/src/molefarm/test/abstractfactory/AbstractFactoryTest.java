package molefarm.test.abstractfactory;

import molefarm.Home;
import molefarm.common.exception.factory.FactoryNotFoundException;
import molefarm.common.exception.product.FactoryNotProduceException;
import molefarm.common.product.AbstractFertilizer;
import molefarm.common.product.AbstractSeed;
import molefarm.common.utils.JsonOp;
import molefarm.pattern.abstractFactory.IFactory;

import java.util.Map;

//finish
public class AbstractFactoryTest {

    private static void factory1ProduceSeed(String seedName){
        String name= Home.seedMap.get(seedName);
        try {
            final IFactory FACTORY1 = IFactory.newConcreteFactory("ConcreteFactory1");

            AbstractSeed seed1 = FACTORY1.createSeed(name);

            System.out.println("ConcreteFactory1可以生产"+seedName);
            System.out.println("种子名称："+seed1.getName());
            System.out.println("种子价格："+seed1.getPrice());
            System.out.println("种子颜色："+seed1.getColor());
            System.out.println("种子生长周期："+seed1.getGrowthCycle());
        } catch (FactoryNotFoundException | FactoryNotProduceException e) {
            System.out.println("ConcreteFactory1不生产"+seedName);
        }finally {
            System.out.println("-------------------------");
        }
    }

    private static void factory2ProduceSeed(String seedName){
        String name=Home.seedMap.get(seedName);
        try {
            final IFactory FACTORY2 = IFactory.newConcreteFactory("ConcreteFactory2");

            AbstractSeed seed2 = FACTORY2.createSeed(name);

            System.out.println("ConcreteFactory2可以生产"+seedName);
            System.out.println("种子名称："+seed2.getName());
            System.out.println("种子价格："+seed2.getPrice());
            System.out.println("种子颜色："+seed2.getColor());
            System.out.println("种子生长周期："+seed2.getGrowthCycle());
        } catch (FactoryNotFoundException | FactoryNotProduceException e) {
            System.out.println("ConcreteFactory2不生产"+seedName);
        }finally {
            System.out.println("-------------------------");
        }

    }

    private static void factory1ProduceFertilizer(String fertilizerName){
        String name=Home.fertilizerMap.get(fertilizerName);
        try {
            final IFactory FACTORY1 = IFactory.newConcreteFactory("ConcreteFactory1");

            AbstractFertilizer fertilizer1 = FACTORY1.createFertilier(name);

            System.out.println("ConcreteFactory1可以生产"+fertilizerName);
            System.out.println("肥料名称："+fertilizer1.getName());
            System.out.println("肥料价格："+fertilizer1.getPrice());
        } catch (FactoryNotFoundException | FactoryNotProduceException e) {
            System.out.println("ConcreteFactory1不生产"+fertilizerName);
        }finally {
            System.out.println("-------------------------");
        }
    }

    private static void factory2ProduceFertilizer(String fertilizerName){
        String name=Home.fertilizerMap.get(fertilizerName);
        try {
            final IFactory FACTORY2 = IFactory.newConcreteFactory("ConcreteFactory2");

            AbstractFertilizer fertilizer2 = FACTORY2.createFertilier(name);

            System.out.println("ConcreteFactory2可以生产"+fertilizerName);
            System.out.println("肥料名称："+fertilizer2.getName());
            System.out.println("肥料价格："+fertilizer2.getPrice());
        } catch (FactoryNotFoundException | FactoryNotProduceException e) {
            System.out.println("ConcreteFactory2不生产"+fertilizerName);
        }finally {
            System.out.println("-------------------------");
        }

    }

    public static void main(String[] args) {
        //根据名字产生具体作物
        String seedName = "白菜种子";

        factory1ProduceSeed(seedName);

        factory2ProduceSeed(seedName);

        String fertilizerName = "初级肥料";

        factory1ProduceFertilizer(fertilizerName);

        factory2ProduceFertilizer(fertilizerName);

        String seedName1="蓝莓种子";

        factory1ProduceSeed(seedName1);

        factory2ProduceSeed(seedName1);

    }
}
