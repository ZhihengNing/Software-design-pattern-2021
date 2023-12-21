package molemall.other.shops.cart;

import backpack.MVC.Backpack;
import framework.simplefactory.Mole;
import molemall.MallProcess;
import molemall.other.shops.ClothesShop;
import molemall.other.shops.Shop;
import molemall.pattern.abstractFactory.AbstractClothes;
import molemall.pattern.abstractFactory.AbstractFood;
import molemall.pattern.abstractFactory.ICommodity;
import molemall.pattern.visitor.ClothesVisitor;
import molemall.pattern.strategy.SaleSelect;
import singletonlazyinitialization.MoleManor;

import java.util.ArrayList;
import java.util.List;

public class ShoppingCart{//之后增加继承，目前用于测试；输出：打印一张小票
    private Mole mole= MoleManor.getPlayer();
    //使用list装载购买的物品
    List<CommodityForCart> commoditylist=new ArrayList<CommodityForCart>();
    private Double realprice;
    /**
     * @param newInstance
     */
    private static volatile ShoppingCart cart;
    private ShoppingCart(){

    }
    public synchronized static ShoppingCart newInstance(){
        cart=new ShoppingCart();
        return cart;
    }

    /**
     * visitor模式：接受租赁和购买两种操作
     * @param clothesVisitor
     */
    public void accept(ClothesVisitor clothesVisitor){clothesVisitor.visit(this);}


    public <T extends ICommodity> boolean loadObject(T object, int num) {
        CommodityForCart commodity=new CommodityForCart(object.getItem(),object.getPrice(),num);
        Integer it=commoditylist.indexOf(commodity);
        if (it != -1){ //若购物车中已经有此商品，则将其与新增商品数量累加
            commoditylist.get(it).num+=num;
        }
        else{ //若购物车中没有此商品，则将其加入其中
            commoditylist.add(commodity);
        }
        return true;
    }


    public boolean loadClothes(AbstractClothes clothes, int num){
        return loadObject(clothes,num);
    }
    public boolean loadFood(AbstractFood food, int num){
        return loadObject(food,num);
    }

    /**
     * 打印小票
     */
    public Double printReceipt(){
        if(commoditylist.size()>0){
            Double sumPrice=0.0;
        System.out.println("\n--------发票--------");
        System.out.println("名称\t\t价格\t\t数量");
        for (int i =0;i< commoditylist.size(); i++) {
            Double price=commoditylist.get(i).getPrice();
            int num=commoditylist.get(i).getNum();
            System.out.print(String.format("%-7s",commoditylist.get(i).getItem()));
            System.out.print(String.format("%-8s",price));
            System.out.print(String.format("%-8s",num));
            System.out.print("\n");
            sumPrice+=price*num;
        }
            System.out.println("\n\n总价格 \t\t"+sumPrice);
            System.out.println("-------------------");
            setPrice(sumPrice);//消费确认
            return sumPrice;
        }
        else{
            return 0.0;
        }
    }

    /**
     * 打印小票
     */
    public Double printPurchaseReceipt(){
        if(commoditylist.size()>0){
            Double sumPrice=0.0;
            System.out.println("\n--------发票--------");
            System.out.println("名称\t\t价格\t\t数量");
            for (int i =0;i< commoditylist.size(); i++) {
                Double price=commoditylist.get(i).getPrice();
                int num=commoditylist.get(i).getNum();
                System.out.print(String.format("%-7s",commoditylist.get(i).getItem()));
                System.out.print(String.format("%-8s",price));
                System.out.print(String.format("%-8s",num));
                System.out.print("\n");
                sumPrice+=price*num;
            }
            System.out.println("\n\n总价格 \t\t"+sumPrice);
            Double realPrice=SaleSelect.sale(sumPrice);
            System.out.println("实付价格\t\t"+realPrice);
            System.out.println("-------------------");
            setPrice(realPrice);//消费确认
            return realPrice;
        }
        else{
            return 0.0;
        }
    }

    /**
     * 打印小票
     */
    public Double printLeaseReceipt(){
        if(commoditylist.size()>0){
            Double sumPrice=0.0;
            System.out.println("\n------租赁票据------");
            System.out.println("名称\t\t价格\t\t数量");
            for (int i =0;i< commoditylist.size(); i++) {
                Double price=commoditylist.get(i).getPrice();
                int num=commoditylist.get(i).getNum();
                System.out.print(String.format("%-7s",commoditylist.get(i).getItem()));
                System.out.print(String.format("%-8s",price));
                System.out.print(String.format("%-8s",num));
                System.out.print("\n");
                sumPrice+=price*num;
            }
            System.out.println("\n\n租赁时长 \t\t一个月");
            System.out.println("租赁价格 \t\t"+sumPrice*0.1);
            System.out.println("-------------------");
           Double realPrice=sumPrice*0.1;
            setPrice(realPrice);//消费确认
            return  realPrice;
        }
        else{
            return 0.0;
        }
    }
    public boolean moleConsume(Double price){//摩尔付款
        Double money = this.mole.getMoney();
        this.mole.getBackpack();
        if(price==null||price<=0.0){//没有消费行为
            return false;
        }
        if (money < price) {
            System.out.println("余额不足，本次交易失败。");
            return false;
        }
        mole.setMoney(money - price);
        System.out.println("交易成功，余额为"+mole.getMoney());
        return true;
    }
    public void consume(Double sumPrice,String commodityType){
        /**
         * mole付款
         */
        if(moleConsume(sumPrice)){//true:交易成功
            /**
             * 背包增加获得的物品
             */
            Backpack backpack=mole.getBackpack();
            for(int i=0;i<commoditylist.size();i++){
                if(commodityType.equals("food")){
                    backpack.AddFood(commoditylist.get(i).item,commoditylist.get(i).num);
                }
                else if(commodityType.equals("pclothes")){
                    backpack.AddClothes(commoditylist.get(i).item,commoditylist.get(i).num);
                }
                else if(commodityType.equals("lclothes")){
                    backpack.AddClothes("(租)"+commoditylist.get(i).item,commoditylist.get(i).num);
                }
                 mole.setBackpack(backpack);
             }
        }
        /**
         * 清空购物车
         */
        commoditylist.clear();

    }
    public void setPrice(Double realprice){ this.realprice=realprice;}
    public Double getPrice() {
        Double price=realprice;
        realprice=0.0;
        return price;}

}
