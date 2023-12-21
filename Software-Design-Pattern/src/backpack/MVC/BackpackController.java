package backpack.MVC;

/**
 * 背包控制器
 */
public class BackpackController {
    private Backpack model;
    private BackpackView view;

    public BackpackController(Backpack model, BackpackView view){
        this.model=model;
        this.view=view;
    }

    //添加物品到背包
    public void AddBackpackItem(String item,int num,String type){
        switch(type)
        {
            case "clothes":
                if(model.getClothes().containsKey(item)){

                    Integer n=model.getClothesNum(item);
                    n+=num;
                    model.DelClothes(item);
                    model.AddClothes(item,n);
                }
                else
                    model.AddClothes(item,num);
                break;
            case "food":
                if(model.getClothes().containsKey(item)){
                    Integer n=model.getFoodNum(item);
                    n+=num;
                    model.DelFood(item);
                    model.AddFood(item,n);
                }
                else
                    model.AddFood(item,num);
                break;
        }

    }

    //删除背包中的物品
    public void DelBackpackItem(String item,String type){
        switch(type)
        {
            case "clothes":
                model.DelClothes(item);
                break;
            case "food":
                model.DelFood(item);
                break;
        }
    }


    //遍历背包
    public void updateView(){
        view.printBackpack(model.getClothes());
        view.printBackpack(model.getFood());
    }


}
