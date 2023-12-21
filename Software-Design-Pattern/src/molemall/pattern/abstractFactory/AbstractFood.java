package molemall.pattern.abstractFactory;

public abstract class AbstractFood implements ICommodity{
    public abstract void Purchase();//购买
    public abstract void transfer();//与仓库进行转移
    public abstract Double getPrice();
    public abstract String getItem();
}
