package molefarm.common.status.product;

/**
 * 肥料分为初级，中级，高级肥料
 */
public enum Level {
    PRIMARY_LEVEL("初级"), MIDDLE_LEVEL("中级"), HIGH_LEVEL("高级");
    String text;

    Level(String text) {
        this.text = text;
    }

    public String getText() {
        return text;
    }
}
