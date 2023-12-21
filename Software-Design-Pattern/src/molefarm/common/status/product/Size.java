package molefarm.common.status.product;

/**
 * 大小
 */
public enum Size {
    SMALL(0, "小"),
    MEDIUM(1, "中"),
    BIG(2, "大");
    int number;
    String size;

    Size(int number, String size) {
        this.number = number;
        this.size = size;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }
}
