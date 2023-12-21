package molefarm.common.status.product;

/**
 * 颜色
 */
public enum Color {
    RED("红色"),
    YELLOW("黄色"),
    BLACK("黑色"),
    BROWN("棕色"),
    GREEN("绿色"),
    PURPLE("紫色");
    String color;

    Color(String color) {
        this.color = color;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }
}
