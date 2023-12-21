package framework.interpreter.calculate;

import framework.interpreter.calculate.Expression;

public class Number implements Expression {

    private double number;

    public Number(double number){
        this.number=number;
    }
    @Override
    public double interpret(){
        return number;
    }

}
