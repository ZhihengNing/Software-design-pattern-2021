package framework.simplefactory;

public class MoleFactory {
    //创建并初始化角色
    public Mole createMole(String role,String color){
        MoleIngredientFactory moleIngredientFactory=new MoleIngredientFactory();
        Mole mole=new Mole();
        mole.setMoleRole(moleIngredientFactory.setRole(role));
        mole.setMoleColor(moleIngredientFactory.setColor(color));
        mole.setMoleName(color+role);
        return mole;
    }
}
