package molemall.pattern.abstractFactory;

import molemall.pattern.bridge.ClothesColor;

import java.lang.reflect.InvocationTargetException;

public interface AbstractFactory {
    public AbstractFood CreateFood(String FoodType, double Price);
    public AbstractClothes CreateClothes(String ClothesType, Double Price, ClothesColor color);
    public AbstractSeed CreateSeed(String SeedType, double Price);

    ICommodity create(String name);

    /**
     * 反射机制创建商品
     */
    static <T extends ICommodity> T createCommodity(String name){
        T abstractObj=null;
        try{
        Class<T> aClass =(Class<T>)Class.forName(name);
            return aClass.getConstructor().newInstance();
        } catch (ClassNotFoundException | NoSuchMethodException | IllegalAccessException | InvocationTargetException | InstantiationException e) {
            e.printStackTrace();
        }
        return abstractObj;
    }
}
