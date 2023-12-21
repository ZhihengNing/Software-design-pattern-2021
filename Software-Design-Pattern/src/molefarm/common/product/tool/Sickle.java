package molefarm.common.product.tool;

import molefarm.common.product.AbstractTool;

/**
 * 镰刀
 * 用于除草
 */
public class Sickle extends AbstractTool {
    private final String name = "镰刀";

    private Double price;

    private Sickle() {
    }

    private static Sickle sickle = new Sickle();

    public static Sickle newInstance() {
        return sickle;
    }

    @Override
    public void ToolBehavior() {
        System.out.println("正在用" + name + "除草...");
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
