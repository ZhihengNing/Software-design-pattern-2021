package molemall.pattern.abstractFactory;

public interface ICommodity {
    /**
     * 获取名称
     */
    default String getItem() {
        return null;
    }
    /**
     * 获取价格
     */
    default Double getPrice() {
        return null;
    }
}
