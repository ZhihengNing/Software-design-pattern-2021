package molefarm.pattern.adapter.conc;


//import molefarm.pattern.adapter.Mole;

import framework.simplefactory.Mole;
import singletonlazyinitialization.MoleManor;
import molefarm.common.MoleFarm;
import molefarm.common.MoleFarmWarehouse;
import molefarm.pattern.adapter.Target;

/**
 * 摩尔角色适配器
 * 这里采用了单例模式(因为只有一个mole)
 * 因为框架端没有农场，也没有仓库，所以要用适配器
 */
public class MoleAdapter extends Mole implements Target {

    private static MoleAdapter moleAdapter=new MoleAdapter(MoleManor.getPlayer());

    //这个mole对象要从外界传进来的，因为这是适配器
    private Mole mole;

    private MoleFarm moleFarm=MoleFarm.getInstance();

    private MoleFarmWarehouse farmWarehouse;

    private MoleAdapter(Mole mole){
        this.mole=mole;
        farmWarehouse=MoleFarmWarehouse.getInstance(mole);
    }

    //返回mole适配器对象实例
    public static MoleAdapter getInstance(){
        return moleAdapter;
    }

    public static void setMoleAdapter(MoleAdapter moleAdapter) {
        MoleAdapter.moleAdapter = moleAdapter;
    }

    @Override
    public Double getMoleDou() {
        return mole.getMoney();
    }

    @Override
    public void setMoleDou(Double money) {
        mole.setMoney(money);
    }

    public Mole getMole() {
        return mole;
    }

    public MoleFarm getMoleFarm() {
        return moleFarm;
    }

    public MoleFarmWarehouse getFarmWarehouse() {
        return farmWarehouse;
    }
}
