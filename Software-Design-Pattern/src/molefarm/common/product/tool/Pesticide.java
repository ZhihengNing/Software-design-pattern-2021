package molefarm.common.product.tool;

import molefarm.common.product.AbstractTool;

public class Pesticide extends AbstractTool {
    private final String name = "农药";

    private Pesticide() {
    }

    private static Pesticide pesticide = new Pesticide();

    @Override
    public String getName() {
        return name;
    }

    public static Pesticide newInstance() {
        return pesticide;
    }

    @Override

    public void ToolBehavior() {
        System.out.println("正在用" + name + "除虫...");
    }
}
