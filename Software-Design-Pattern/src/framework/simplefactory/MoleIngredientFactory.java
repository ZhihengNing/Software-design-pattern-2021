package framework.simplefactory;

import framework.simplefactory.color.*;
import framework.simplefactory.role.*;

public class MoleIngredientFactory {
    //设置角色
    public Role setRole(String role){
        if(role==null){
            return null;
        }
        if(role.equalsIgnoreCase("Kura")){
            return new Kura();
        }
        else if(role.equalsIgnoreCase("Molele")){
            return new Molele();
        }
        else if(role.equalsIgnoreCase("Momo")){
            return new Momo();
        }
        return null;
    }

    //设置颜色
    public Color setColor(String color){
        if(color==null){
            return null;
        }
        if(color.equalsIgnoreCase("Red")){
            return new Red();
        }
        else if(color.equalsIgnoreCase("Green")){
            return new Green();
        }
        else if(color.equalsIgnoreCase("Blue")){
            return new Blue();
        }
        return null;
    }

}
