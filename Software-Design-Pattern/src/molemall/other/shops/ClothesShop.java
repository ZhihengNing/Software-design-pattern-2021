package molemall.other.shops;

import exceptionhandle.ExceptionHandle;
import framework.simplefactory.Mole;
import molemall.pattern.abstractFactory.AbstractClothes;
import molemall.pattern.bridge.Blue;
import molemall.pattern.bridge.Red;
import molemall.pattern.bridge.Yellow;
import molemall.pattern.clothesFilter.IFilter;
import molemall.pattern.clothesFilter.priceFilter;
import molemall.other.commodities.clothes.Jackets;
import molemall.other.commodities.clothes.Jeans;
import molemall.other.commodities.clothes.Shorts;
import molemall.other.commodities.clothes.Tshirt;
import molemall.pattern.abstractFactory.factory.ClothesFactory;
import molemall.other.shops.cart.ShoppingCart;
import molemall.other.utils.JsonUtils;
import molemall.pattern.visitor.ClothesLeaseVisitor;
import molemall.pattern.visitor.ClothesPurchaseVisitor;
import molemall.pattern.visitor.ClothesVisitor;
import singletonlazyinitialization.MoleManor;

import java.util.*;

/**
 * 服装店
 *
 */
public class ClothesShop extends Shop{
    private static final ClothesFactory clothesFactory = ClothesFactory.newInstance();
    private static final ShoppingCart clothesPurchaseCart = ShoppingCart.newInstance();
    private static final ShoppingCart clothesLeaseCart = ShoppingCart.newInstance();
    private static final Map<String, String> map = JsonUtils.searchMapper();
    /**
     * 服装存储
     */
    private Map<AbstractClothes,Double> clothesMap=new HashMap<>();
    /**
     * 服装分区：上衣区，下衣区，鞋子区，帽子区共4种
     */
    private Integer clothesBlockCount = 2;//再改
    /**
     * 服装分区列表
     */
    private List<clothesBlock> clothesBlockList= new ArrayList<>();

    private List<AbstractClothes> clothesList= new ArrayList<>();


    private static volatile ClothesShop clothesShop = new ClothesShop();

    public static synchronized ClothesShop newInstance() {
        return clothesShop;
    }

    private ClothesShop() {
        clothesList.add(new Jackets());
        clothesList.add(new Tshirt());
        clothesList.add(new Jeans());
        clothesList.add(new Shorts());
    }
    public static void createClothes(String name){
        AbstractClothes clothes;
        clothes=clothesFactory.create( map.get(name));
        boolean colorSelect = true;
        while(colorSelect)
        {
            System.out.println("请选择颜色：[1]红色 [2]蓝色 [3]黄色");
            Scanner input=new Scanner(System.in);
            ExceptionHandle exceptionHandle = new ExceptionHandle();
            int select = exceptionHandle.exception();
            switch (select)
            {
                case 1:
                    clothes.color=new Red();colorSelect = false;break;
                case 2:
                    clothes.color=new Blue();colorSelect = false;break;
                case 3:
                    clothes.color=new Yellow();colorSelect = false;break;
                default:
                    System.out.println("选择的颜色有误！请重新选择");break;
            }
        }
        clothes.setItem();
        /**
         * 可能会改写到别的地方，租赁or购买询问
         */
        while(true){
            System.out.println("请问您是要购买还是租赁这件服装：[1]购买 [2]租赁");
            Scanner input=new Scanner(System.in);
            ExceptionHandle exceptionHandle = new ExceptionHandle();
            int select = exceptionHandle.exception();
            if(select==1){//购买
                while(true) {
                    System.out.println("请输入您需要的数量");
                    int num = exceptionHandle.exception();
                    if(num<=0){
                        System.out.println("输入数字应为正数");
                        continue;
                    }
                    clothesPurchaseCart.loadClothes(clothes,num);
                    break;
                }
               break;
            }
            else if(select==2){//租赁
                while(true) {
                    System.out.println("请输入您需要的数量");
                    int num = input.nextInt();
                    if(num<=0){
                        System.out.println("输入数字应为正数");
                        continue;
                    }
                    clothesLeaseCart.loadClothes(clothes,num);
                    break;
                }
                break;
            }
            else {
                continue;
            }
        }
    }
    public static void checkout(){
        ClothesVisitor Pvisitor=new ClothesPurchaseVisitor();
        clothesPurchaseCart.accept(Pvisitor);//访问者模式
        Double realPrice1=clothesPurchaseCart.getPrice();
        clothesPurchaseCart.consume(realPrice1,"pclothes");//消费确认
        ClothesVisitor Lvisitor=new ClothesLeaseVisitor();
        clothesLeaseCart.accept(Lvisitor);//访问者模式
        Double realPrice2=clothesLeaseCart.getPrice();
        clothesLeaseCart.consume(realPrice2,"lclothes");//消费确认
    }
    public void showClothesShop() {//或许可以把成员clothesList作为默认参数List<AbstractClothes> clothes=clothesList？
        System.out.print("服装名称\t\t");
        for (int i =0;i< clothesList.size(); i++) {
            System.out.print(String.format("%-10s",clothesList.get(i).getItem()));
        }
        System.out.print("\n服装价格\t\t");
        for (int i =0;i< clothesList.size(); i++) {
            System.out.print(String.format("%-11s",clothesList.get(i).getPrice()));
        }
    }
    public void filterClothes(double start_price,double end_price){
        IFilter priceFilter = new priceFilter();
        List<AbstractClothes> filter_clothes = priceFilter.filter(clothesShop.clothesList, start_price, end_price);
        if (filter_clothes.size() == 0) {
            System.out.println("没有筛选到商品哦");
        }
        else
        {
            System.out.println("商品筛选结果如下：\n");
            System.out.print("服装名称\t\t");
            for (int i = 0; i < filter_clothes.size(); i++) {
                System.out.print(String.format("%-10s", filter_clothes.get(i).getItem()));
            }
            System.out.print("\n服装价格\t\t");
            for (int i = 0; i < filter_clothes.size(); i++) {
                System.out.print(String.format("%-11s", filter_clothes.get(i).getPrice()));
            }
        }
    }
}
