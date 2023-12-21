package moleamuse.cookingpackage.prototype;

public class TangCuLiJi extends AbstractMeal{
    public TangCuLiJi(){
        name = "糖醋里脊";
    }

    @Override
    public void cook() {
        try{
            System.out.println("\n准备材料中...");
            Thread.sleep(1000);

            System.out.println(name + "正在制作中...\n");
            Thread.sleep(1500);

        }catch(InterruptedException e){
            e.printStackTrace();
        }
        System.out.println(name + "做好了！味道好极了！");
    }
}
