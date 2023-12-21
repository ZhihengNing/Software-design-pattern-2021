package molefarm.common;

import framework.simplefactory.Mole;
import molefarm.common.product.AbstractCrops;
import molefarm.common.product.AbstractFertilizer;
import molefarm.common.product.AbstractSeed;
import molefarm.common.product.IProduct;
import molefarm.common.product.crops.*;
import molefarm.common.product.fertilizer.AdvancedFertilizer;
import molefarm.common.product.fertilizer.MiddleFertilizer;
import molefarm.common.product.fertilizer.PrimaryFertilizer;
import molefarm.common.product.seed.*;
import molefarm.common.product.tool.*;
import molefarm.common.repository.IFarmWareHouse;
import molefarm.pattern.adapter.conc.MoleAdapter;
import molefarm.pattern.chainOfResponsibility.conc.ShopHandler;
import molefarm.pattern.chainOfResponsibility.conc.WareHouseHandler;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 摩尔个人仓库
 * implements IFarmWareHouse
 */
public class MoleFarmWarehouse implements IFarmWareHouse {

    private Mole mole;

    private MoleFarmWarehouse(Mole mole) {
        this.mole=mole;
        this.seedMap.put(new CabbageSeed(), 5);
        this.seedMap.put(new EggplantSeed(), 5);
        this.seedMap.put(new RiceSeed(), 5);
        this.seedMap.put(new StrawberrySeed(), 5);
        this.seedMap.put(new WatermelonSeed(), 5);
        this.seedMap.put(new WheatSeed(), 5);
        this.cropsMap.put(new Cabbage(), 3);
        this.cropsMap.put(new Eggplant(), 3);
        this.cropsMap.put(new Rice(), 3);
        this.cropsMap.put(new Strawberry(), 3);
        this.cropsMap.put(new Watermelon(), 3);
        this.cropsMap.put(new Wheat(), 3);
        this.fertilizerMap.put(new AdvancedFertilizer(), 2);
        this.fertilizerMap.put(new MiddleFertilizer(), 2);
        this.fertilizerMap.put(new PrimaryFertilizer(), 2);
    }
    /**
     * 种子存储
     */
    private Map<AbstractSeed, Integer> seedMap = new HashMap<>();
    /**
     * 肥料存储
     */
    private Map<AbstractFertilizer, Integer> fertilizerMap = new HashMap<>();
    /**
     * 作物存储
     */
    private Map<AbstractCrops, Integer> cropsMap = new HashMap<>();

    private Hoe hoe = Hoe.newInstance();

    private Sickle sickle = Sickle.newInstance();

    private WateringCan wateringCan = WateringCan.newInstance();

    private Pesticide pesticide = Pesticide.newInstance();

    private Shovel shovel = Shovel.newInstance();

    public void setMole(MoleAdapter mole) {
        this.mole = mole;
    }

    public Mole getMole(){
        return mole;
    }

    public Hoe getHoe() {
        return hoe;
    }

    public Sickle getSickle() {
        return sickle;
    }

    public WateringCan getWateringCan() {
        return wateringCan;
    }

    public Pesticide getPesticide() {
        return pesticide;
    }

    public Shovel getShovel() {
        return shovel;
    }

    public Map<AbstractSeed, Integer> getSeedMap() {
        return seedMap;
    }

    public Map<AbstractFertilizer, Integer> getFertilizerMap() {
        return fertilizerMap;
    }

    public Map<AbstractCrops, Integer> getCropsMap() {
        return cropsMap;
    }

    public static MoleFarmWarehouse getInstance(Mole mole){
        return new MoleFarmWarehouse(mole);
    }

    /**
     * 购买种子和肥料
     * @param object
     * @param num
     * @param methodName
     * @param <T>
     * @return
     */
    public <T extends IProduct> boolean buyObject(T object, int num, String methodName) {
        Double price = object.getPrice() * num;
        //需要有一个摩尔角色类，判断剩余摩尔豆是否大于等于交换金额，是则返回true，并扣除相应大小的摩尔豆
        //调用适配器
        Double money = mole.getMoney();
        if (money < price) {
            return false;
        }
        mole.setMoney(money - price);
        try {
            Method method = MoleFarmWarehouse.class.getDeclaredMethod(methodName);
            Map<T, Integer> objectMap = (Map<T, Integer>) method.invoke(this);
            Integer oriNum = objectMap.putIfAbsent(object, num);
            //若仓库中原本有库存，则将其与新增进货量累加
            if (oriNum != null) {
                objectMap.put(object, num + oriNum);
            }
            return true;
            //返回仓库中该种子的原有数量，若map中无该类种子，则插入并返回null
        } catch (IllegalAccessException | InvocationTargetException | NoSuchMethodException e) {
            System.out.println(e.getMessage());
        }
        return false;
    }

    /**
     * 给摩尔提供需要的东西
     * @param objectList
     * @param <T>
     * @return
     */
    @Override
    public <T extends IProduct> boolean provideItemToMole(List<T> objectList) {
        //调用职责链模式
        WareHouseHandler wareHouseHandler = new WareHouseHandler();
        ShopHandler shopHandler = new ShopHandler();
        wareHouseHandler.setNext(shopHandler);
        return wareHouseHandler.provideSeeds(objectList);
    }

    /**
     * 购买种子
     * @param seed
     * @param num
     * @return
     */
    @Override
    public boolean buySeeds(AbstractSeed seed, int num) {
        if(num<=0){
            System.out.println("请输入正确的数量！");
            return false;
        }
        return buyObject(seed, num, "getSeedMap");
    }

    /**
     * 购买肥料
     * @param fertilizer
     * @param num
     * @return
     */
    @Override
    public boolean buyFertilizer(AbstractFertilizer fertilizer, int num) {
        if(num<=0){
            System.out.println("请输入正确的数量！");
            return false;
        }
        return buyObject(fertilizer, num, "getFertilizerMap");
    }

    /**
     * 销售作物
     * @param crops
     * @param num
     * @return
     */
    @Override
    public boolean sellCrops(AbstractCrops crops, int num) {
        if(num<=0){
            System.out.println("请输入正确的数量！");
            return false;
        }
        //计算仓库存量
        int left = this.getCropsMap().get(crops);
        boolean result = left >= num;
        if (!result) {
            System.out.println("仓库存量不足，卖出失败");
            return false;
        }
        this.getCropsMap().put(crops, left - num);
        mole.setMoney(mole.getMoney()+ crops.getPrice() * num);
        System.out.println("卖出成功，共进账" + crops.getPrice() * num + "摩尔豆！" + "当前余额(" + mole.getMoney() + ")");
        return true;
    }

    /**
     * 存作物到仓库
     * @param otherCropsMap
     * @return
     */
    @Override
    public boolean storeToRepository(Map<AbstractCrops, Integer> otherCropsMap) {
        if (otherCropsMap == null || otherCropsMap.size() == 0) {
            return false;
        }
        for (var item : otherCropsMap.entrySet()) {
            AbstractCrops key = item.getKey();
            Integer value = item.getValue();
            Integer count = cropsMap.get(key)==null?0:cropsMap.get(key);
            cropsMap.put(key,count+value);
        }
        return true;
    }

    /**
     * 输出仓库信息
     */
    public void showRepertory() {
        System.out.println("\n仓库库存如下：");
        System.out.println("白菜\uD83E\uDD66\t茄子\uD83C\uDF46\t水稻\uD83C\uDF3E\t草莓\uD83C\uDF53\t西瓜\uD83C\uDF49\t小麦\uD83C\uDF3F   ");
        System.out.println(cropsMap.get(new Cabbage()) + "\t\t" + cropsMap.get(new Eggplant()) + "\t\t" + cropsMap.get(new Rice()) + "\t\t" +
                cropsMap.get(new Strawberry()) + "\t\t" + cropsMap.get(new Watermelon()) + "\t\t" + cropsMap.get(new Wheat()) + "\t\t");
        System.out.println("白菜种子\t茄子种子\t水稻种子\t草莓种子\t西瓜种子\t小麦种子");
        System.out.println(seedMap.get(new CabbageSeed()) + "\t\t" + seedMap.get(new EggplantSeed()) + "\t\t" + seedMap.get(new RiceSeed()) + "\t\t" +
                seedMap.get(new StrawberrySeed()) + "\t\t" + seedMap.get(new WatermelonSeed()) + "\t\t" + seedMap.get(new WheatSeed()) + "\t\t");
        System.out.println("高级肥料\t中级肥料\t初级肥料");
        System.out.println(fertilizerMap.get(new AdvancedFertilizer()) + "\t\t" + fertilizerMap.get(new MiddleFertilizer()) + "\t\t" +
                fertilizerMap.get(new PrimaryFertilizer()));
    }

}
