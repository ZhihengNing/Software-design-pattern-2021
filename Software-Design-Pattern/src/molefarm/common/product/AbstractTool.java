package molefarm.common.product;

/**
 * 抽象农场工具
 */
public abstract class AbstractTool implements IProduct {
    /**
     * 名字
     */
    protected String name;

    /**
     * 价格
     */
    protected Double price;
    /**
     * 工具的处理行为
     */
    public abstract void ToolBehavior();
}
