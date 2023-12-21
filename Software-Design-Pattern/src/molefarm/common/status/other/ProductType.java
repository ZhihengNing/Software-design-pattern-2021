package molefarm.common.status.other;

/**
 * 农田物品的种类
 */
public enum ProductType {
    CROPS("crops"), SEED("seed"), FARM_TOOL("farmTool"), FERTILIZER("fertilizer");
    String text;

    ProductType(String text) {
        this.text = text;
    }

    public String getText() {
        return text;
    }
}
