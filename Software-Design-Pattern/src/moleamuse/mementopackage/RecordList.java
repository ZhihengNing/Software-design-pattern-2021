package moleamuse.mementopackage;

import java.util.ArrayList;
import java.util.List;


/**
 * @author 罗检
 *
 * 恢复游玩过的游戏名称与分数
 */
public class RecordList {

    private static RecordList Instance = new RecordList();
    private RecordList(){}
    public static RecordList getInstance(){return Instance;}

    private List<RecordMemento> recordList = new ArrayList<RecordMemento>();
    /**
     * 添加游戏记录
     * @param record 游戏记录
     */
    public void add(RecordMemento record){
        recordList.add(record);
    }
    /**
     * 获取某一游戏记录
     * @param
     */
    public void printList(){
        System.out.println("\n----- 备忘录 -----");

        if (recordList.size() == 0){
            System.out.println("\n你还没有玩过游戏呢..去游乐场看看吧！\n");
            return;
        }

        for(RecordMemento i : recordList){
            System.out.println("游戏时间：" + i.getDate() + " 游戏名称：" + i.getName() + " 分数为:" + i.getScore());
        }
        System.out.println();
    }

    /**
     * 获取游戏记录
     */
    public void getRecord(int index){
        if (index <= 0 || index > recordList.size()) {
            System.out.println("找不到该游戏记录！");
            return;
        }
        RecordMemento i = recordList.get(index - 1);
        System.out.println("游戏时间：" + i.getDate() + " 游戏名称：" + i.getName() + " 分数为:" + i.getScore());
    }
}
