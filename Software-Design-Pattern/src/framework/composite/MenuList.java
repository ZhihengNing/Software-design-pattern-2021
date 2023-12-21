package framework.composite;

public class MenuList {
    /**
     * 单例模式：菜单表
     */
    private static MenuList instance = new MenuList();

    public static MenuList getInstance() {
        return instance;
    }

    private final Menu meanMenu = new Menu("摩尔大厅");

    /**
     * 设置菜单
     */
    private MenuList() {

        /**
         * 大厅菜单
         */
        Menu amuseMenu = new Menu("摩尔游乐园");
        Menu farmMenu = new Menu("摩尔农场");
        Menu shopMenu = new Menu("摩尔商场");
        Menu chatMenu = new Menu("摩尔聊天室");
        meanMenu.add(amuseMenu, farmMenu, shopMenu, chatMenu, new MenuOption("查看公告"),new MenuOption("查看摩尔基本信息"));
        /**
         * 聊天室菜单
         */
        chatMenu.add(new MenuOption("发送信息"), new MenuOption("显示聊天内容"));

        /**
         * 游乐园菜单
         */
        Menu raceMenu = new Menu("摩摩赛车场");
        amuseMenu.add(new MenuOption("摩尔厨房"), raceMenu, new MenuOption("摩摩井字棋"), new MenuOption("摩尔备忘录"),new MenuOption("购买门票"));
        raceMenu.add(new MenuOption("摩摩竞速赛"), new MenuOption("摩摩漂移赛"), new MenuOption("摩摩障碍赛"));
        /**
         * 农场菜单
         */

        /**
         * 商场菜单
         */
    }

    /**
     * 获取主菜单
     */
    public Component meanMenu() {
        return meanMenu;
    }
}
