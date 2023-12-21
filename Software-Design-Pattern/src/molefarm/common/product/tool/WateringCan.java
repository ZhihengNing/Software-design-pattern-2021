package molefarm.common.product.tool;

import molefarm.common.product.AbstractTool;

/**
 * 浇水壶
 * 用于浇水
 */
public class WateringCan extends AbstractTool {

    private final String name = "浇水壶";

    private WateringCan() {
    }

    private static WateringCan wateringCan = new WateringCan();

    public static WateringCan newInstance() {
        return wateringCan;
    }

    private Double price;

    @Override
    public void ToolBehavior() {
        System.out.println("正在用" + name + "浇水...");
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public Double getPrice() {
        return price;
    }
}
