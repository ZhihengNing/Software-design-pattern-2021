package molemall.other;
/**
 * 服装分区
 */
public enum ClothesType {
    UPPERCLOTHES("upperClothes"),PANTS("pants");
    String text;

    ClothesType(String _text){this.text=_text;}

    public String getText(){return text;}
}
