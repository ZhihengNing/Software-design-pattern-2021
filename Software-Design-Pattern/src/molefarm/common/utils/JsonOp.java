package molefarm.common.utils;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.JSONReader;
import molefarm.common.status.other.ProductType;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.List;
import java.util.Map;
import java.util.Objects;

/**
 * 读取json文件
 */
public class JsonOp {
    private static String commonPath = "src/";

    /**
     * 通过路径读取json文件，返回jsonobject对象
     *
     * @param jsonPath
     * @return
     * @throws FileNotFoundException
     */
    private static JSONObject getJson(String jsonPath) throws FileNotFoundException {
        JSONReader jsonReader = new JSONReader(new FileReader(jsonPath));
        return (JSONObject) jsonReader.readObject();
    }

    public static Map<String, String> searchMapper(String name) {
        try {
            String jsonPath = commonPath + "molefarm/common/resources/mapper.json";
            JSONObject json = getJson(jsonPath);
            JSONObject json1 = json.getJSONObject(name);
            String s = json1.toJSONString();
            return (Map<String, String>) JSON.parseObject(s, Map.class);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }


    /**
     * 解析farm.json
     *
     * @param productType
     * @return
     */
    public static List<String> SearchJson(ProductType productType) {
        String text = productType.getText();
        String jsonPath = commonPath + "molefarm/common/resources/farm.json";
        List<String> list = null;
        try {
            JSONObject json = getJson(jsonPath);
            JSONObject temp =json.getJSONObject("farm");
            list = (List<String>) temp.get(text);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return list;
    }

    /**
     * 工具类用来解析
     *
     * @param name
     * @param fileName
     * @param difference
     * @return
     */
    public static String utilSearchJson(String name, String fileName, String... difference) {
        String jsonPath = commonPath + "molefarm/common/resources/" + fileName + ".json";
        int size = difference.length;
        try {
            JSONObject json = getJson(jsonPath);
            if (size == 1) {
                if (Objects.equals(name, difference[0])) {
                    return json.getString(name);
                } else {
                    JSONObject factory = json.getJSONObject("factory");
                    JSONObject conc = factory.getJSONObject("conc");
                    return conc.getString(name);
                }
            } else {
                if (Objects.equals(name, difference[0]) || Objects.equals(name, difference[1])) {
                    return json.getString(name);
                } else {
                    JSONObject factory = json.getJSONObject("factory");
                    JSONObject conc = factory.getJSONObject("conc");
                    return conc.getString(name);
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 解析path.json
     *
     * @param name
     * @return
     */
    public static String getPathJson(String name) {
        return utilSearchJson(name, "path", "IFactory");
    }

    /**
     * 解析msg.json
     *
     * @param name
     * @return
     */
    public static String getMsgJson(String name) {
        return utilSearchJson(name, "msg", "FarmProductFactory", "IFactory");
    }

}
