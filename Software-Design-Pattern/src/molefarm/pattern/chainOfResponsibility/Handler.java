package molefarm.pattern.chainOfResponsibility;

import molefarm.common.MoleFarmWarehouse;
import molefarm.common.product.IProduct;
import molefarm.pattern.adapter.conc.MoleAdapter;

import java.util.List;

/**
 * 职责链模式
 * 任务接收者抽象类
 */
public abstract class Handler {
    protected MoleAdapter mole=MoleAdapter.getInstance();

    protected MoleFarmWarehouse farmWarehouse = mole.getFarmWarehouse();

    private Handler next;

    public void setNext(Handler next) {
        this.next = next;
    }

    public Handler getNext() {
        return next;
    }

    //处理请求的方法
    public abstract <T extends IProduct> boolean provideSeeds(List<T> list);
}
