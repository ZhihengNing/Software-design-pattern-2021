package molefarm.common.status;

/**
 * 种子状态
 */
public enum SeedStatus {
    SPROUTING("发芽"), SEEDLING("幼苗"), BLOOM("开花"), FRUITING("结果");
    String text;

    SeedStatus(String text) {
        this.text = text;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public static SeedStatus getSeedStatusByNum(int number) {
        for (SeedStatus value : SeedStatus.values()) {
            if (number / 2 == value.ordinal())
                return value;
        }
        return null;
    }
}
