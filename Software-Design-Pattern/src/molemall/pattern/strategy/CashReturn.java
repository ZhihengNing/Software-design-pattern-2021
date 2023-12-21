package molemall.pattern.strategy;

public class CashReturn extends CashSuper {

    private double moneyConditation = 0.0;    //返利条件
    private double moneyReturn = 0.0d;    //返利值

    public CashReturn(double moneyConditation, double moneyReturn) {
        this.moneyConditation = moneyConditation;
        this.moneyReturn = moneyReturn;
    }

    @Override
    public double acceptCash(double money) {
        double result = money;

        if (money >= moneyConditation) {
            result = money - Math.floor(money / moneyConditation) * moneyReturn;
        }

        return result;
    }

}
