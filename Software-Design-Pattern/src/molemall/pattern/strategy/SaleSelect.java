package molemall.pattern.strategy;

import java.util.Random;

public class SaleSelect {

    public static Double sale(Double sumPrice) {
        CashContext cashContext = null;

        Random r=new Random();
        int in = r.nextInt(3);
        String type = "";

        switch (in) {
            case 0:
                cashContext = new CashContext(new CashNormal());
                type += "无优惠活动";
                break;

            case 1:
                cashContext = new CashContext(new CashReturn(300, 100));
                type += "满300返100";
                break;

            case 2:
                cashContext = new CashContext(new CashRebate(0.8));
                type += "打8折";
                break;

            default:
                System.out.println("随机条件有误");
                break;
        }

        Double realPrice = 0.0;


        realPrice = cashContext.getResult(sumPrice);

        System.out.println("今日活动情况：" + type );
        return realPrice;

    }
    public static void main(String[] args){//测试用
        sale(600.0);
    }

}
