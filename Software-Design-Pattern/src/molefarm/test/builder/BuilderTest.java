package molefarm.test.builder;

import molefarm.Home;
import molefarm.common.FarmGrowth;
import molefarm.common.MoleFarmBlock;
import molefarm.common.exception.product.conc.SeedNotFoundException;
import molefarm.common.product.AbstractSeed;
import molefarm.common.utils.JsonOp;
import molefarm.pattern.adapter.conc.WeatherAdapter;
import molefarm.pattern.builder.Builder;
import molefarm.pattern.builder.Director;
import molefarm.pattern.builder.conc.ConcreteBuilder1;
import molefarm.pattern.builder.conc.ConcreteBuilder2;
import molefarm.pattern.factory.conc.SeedFactory;

import java.util.Map;

//false
public class BuilderTest {

    static {
        WeatherAdapter.adapter=WeatherAdapter.changeWeather();
        System.out.println("农场今日天气为："+WeatherAdapter.changeWeather().getWeather());
    }

    public static AbstractSeed createSeed(String seedName){
        AbstractSeed seed=null;
        try {
             seed= SeedFactory.newInstance().create(Home.seedMap.get(seedName));
        } catch (SeedNotFoundException e) {
            System.out.println(e.getMessage());
        }
        return seed;
    }
    public static void builder1(MoleFarmBlock block, AbstractSeed seed){
        Builder builder1 = new ConcreteBuilder1();

        Director director=new Director(builder1,block);

        System.out.println("----原本的状态----");
        block.getInfo();

        System.out.println("----使用建造者模式ing----");
        director.getMoleFarmBlock(seed);

        System.out.println("----后来的状态----");
        block.getInfo();

    }

    private static void builder2(MoleFarmBlock block,AbstractSeed seed) {
        Builder builder2 = new ConcreteBuilder2();

        Director director = new Director(builder2, block);

        System.out.println("----原本的状态----");
        block.getInfo();

        System.out.println("----使用建造者模式ing----");
        director.getMoleFarmBlock(seed);

        System.out.println("----后来的状态----");
        block.getInfo();

    }

    public static void main(String[] args) {
        MoleFarmBlock block1 = new MoleFarmBlock();

        String name="白菜种子";
        AbstractSeed seed = createSeed(name);
        //具体建造者1
        builder1(block1,seed);

        MoleFarmBlock block2 = new MoleFarmBlock();

        String name1="草莓种子";
        AbstractSeed seed1 = createSeed(name1);

        System.out.print("\n");
        //具体建造者2
        builder2(block2,seed1);

    }
}
