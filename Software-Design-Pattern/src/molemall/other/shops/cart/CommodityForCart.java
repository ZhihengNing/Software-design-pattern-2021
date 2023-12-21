package molemall.other.shops.cart;

public class CommodityForCart {//每个具体商品    protected double price;//价格
    protected String item;//名称
    protected double price;//价格
    protected int num;//数量

    public CommodityForCart(){
    }

    public CommodityForCart(String item, double price, int num) {
        this.item=item;
        this.price=price;
        this.num=num;
    }

    public void SetItem(String _item){
        this.item=_item;
    }
    public void SetPrice(double _price){
        this.price=_price;
    }
    public void SetNum(int _num){
        this.num=_num;
    }
    public String getItem(){
        return this.item;
    }
    public double getPrice(){
        return this.price;
    }
    public int getNum(){return this.num;}

    @Override
    public boolean equals(Object obj) {
        CommodityForCart commodity=(CommodityForCart) obj;
        return item.equals(commodity.getItem());
    }
}

