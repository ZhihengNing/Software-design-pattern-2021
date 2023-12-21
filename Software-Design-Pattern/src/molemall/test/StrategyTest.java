package molemall.test;

import molemall.pattern.strategy.*;


public class StrategyTest {
    public static Double sale(Double sumPrice, int in) {
        CashContext cashContext = null;

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

        System.out.println("策略" + in);
        System.out.println("今日活动情况：" + type);
        System.out.println("实际付款价格：" + realPrice);
        return realPrice;

    }

    public static void test(){
        System.out.println("----调用过滤器模式ing----");
        Double sumPrice=600.0;
        System.out.println("商品总价格： "+sumPrice);
        sale(sumPrice,0);
        sale(sumPrice,1);
        sale(sumPrice,2);
    }
    public static void main(String[] args){//测试用
        test();
    }
}

