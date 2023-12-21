package backpack.MVC;

import java.util.Map;
import java.util.Set;
import java.lang.Integer;

/**
 * 背包视图
 */
public class BackpackView {
    public  void printBackpack(Map maps){
        Set<Map.Entry<String, Integer>> set = maps.entrySet();
        for (Map.Entry<String, Integer> entry : set) {
            String key = entry.getKey();
            int value = entry.getValue();
            System.out.printf("%-15s\t%d\n",key,value);
        }

    }
}
