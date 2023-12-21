package molefarm.test.iterator;

import molefarm.common.MoleFarm;
import molefarm.pattern.iterator.conc.FarmIterator;

public class IteratorTest {
    public static void test(){
        MoleFarm farm = MoleFarm.getInstance();
        FarmIterator iterator = farm.getIterator();
        System.out.println(iterator.first());
        System.out.println("----调用迭代器模式ing----");
        System.out.println("为您迭代输出所有农田块的信息");
        while(iterator.hasNext()){
            System.out.println(iterator.next());
        }
    }
    public static void main(String[] args) {
        test();

    }
}
