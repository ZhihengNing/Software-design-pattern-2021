package moleamuse.cookingpackage.prototype;

public class SuanCaiYu extends AbstractMeal{

    public SuanCaiYu(){
        name = "酸菜鱼";
    }

    @Override
    public void cook() {
        try{
            System.out.println("\n准备材料中...");
            Thread.sleep(800);

            System.out.println(name + "正在制作中...\n");
            Thread.sleep(1000);

        }catch(InterruptedException e){
            e.printStackTrace();
        }
        System.out.println(name + "做好了！味道好极了！");
    }
}
