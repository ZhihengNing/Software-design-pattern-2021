package moleamuse.cookingpackage.prototype;

public class GongBaoJiDing extends AbstractMeal{
    public GongBaoJiDing(){
        name = "宫保鸡丁";
    }

    @Override
    public void cook() {
        try{
            System.out.println("\n准备材料中...");
            Thread.sleep(1500);

            System.out.println(name + "正在制作中...\n");
            Thread.sleep(2000);

        }catch(InterruptedException e){
            e.printStackTrace();
        }
        System.out.println(name + "做好了！味道好极了！");
    }
}
