package molefarm.pattern.factory.conc;

import molefarm.common.MoleFarmWarehouse;
import molefarm.common.exception.product.conc.ToolNotFoundException;
import molefarm.common.product.AbstractTool;
import molefarm.common.utils.JsonOp;
import molefarm.pattern.adapter.conc.MoleAdapter;
import molefarm.pattern.factory.Factory;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * 工具的抽象工厂类，此处不再写具体的，如ConcreteFarmToolFactory
 */
public class ToolFactory implements Factory {
    private MoleAdapter mole=MoleAdapter.getInstance();

    private final static String PATH = JsonOp.getPathJson("ToolFactory");

    private final static String MSG = JsonOp.getMsgJson("ToolFactory");

    private static volatile ToolFactory toolFactory;

    private ToolFactory() {
    }

    public synchronized static ToolFactory newInstance() {
        if (toolFactory == null) {
            toolFactory = new ToolFactory();
        }
        return toolFactory;
    }

    @Override
    public AbstractTool create(String name) throws ToolNotFoundException {
        try {
            Method method = MoleFarmWarehouse.class.getDeclaredMethod("get" + name);
            final MoleFarmWarehouse moleFarmWarehouse = mole.getFarmWarehouse();
            AbstractTool invoke = (AbstractTool) method.invoke(moleFarmWarehouse);
            return invoke;
        } catch (IllegalAccessException | InvocationTargetException | NoSuchMethodException e) {
            throw new ToolNotFoundException(MSG);
        }
    }
}
