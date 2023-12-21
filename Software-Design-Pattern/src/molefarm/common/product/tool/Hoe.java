package molefarm.common.product.tool;

import molefarm.common.product.AbstractTool;

/**
 * 锄头
 * 用于种植
 */
public class Hoe extends AbstractTool {
    private final String name = "锄头";

    private Hoe() {
    }

    private static Hoe hoe = new Hoe();

    public static Hoe newInstance() {
        return hoe;
    }

    private Double price;

    @Override
    public void ToolBehavior() {
        System.out.println("正在用" + name + "松土.。。");
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
