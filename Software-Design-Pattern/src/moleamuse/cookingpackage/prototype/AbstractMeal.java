package moleamuse.cookingpackage.prototype;

/**
 * 原型模式
 */
public abstract class AbstractMeal implements Cloneable {

    private String id;
    protected String name;

    /**
     * 接口
     */
    public abstract void cook();

    public String getname(){
        return name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }


    /**
     * 克隆对象
     * @return
     */
    public Object clone() {
        Object clone = null;
        try {
            clone = super.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        return clone;
    }
}
