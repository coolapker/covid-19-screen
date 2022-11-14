package mojospy.covid19screen.util;

import cn.hutool.http.HttpRequest;
import com.alibaba.fastjson2.JSONObject;

import java.util.List;
import java.util.Map;

public class Spider {

    // 网易接口
    private static String url = "https://c.m.163.com/ug/api/wuhan/app/data/list-total";


    /**
     * 获取响应体里的data
     *
     * @return Map
     */
    public static Map getData() {
        String response = HttpRequest.get(url).execute().body();
        Map map = JSONObject.parseObject(response, Map.class);
        // 响应体里的data
        return (Map) map.get("data");
    }

    /**
     * 获取省数据
     */
    public static List<Map> getProvince() {
        Map data = getData();
        // 全球数据
        List areaTree = (List) data.get("areaTree");
        // 中国数据
        Map cn = (Map) areaTree.get(2);
        // 省份数据
        List<Map> provinceList = (List) cn.get("children");

        return provinceList;
    }

    /**
     * 获取overall数据
     */
    public static Map getOverall() {
        Map data = getData();
        return (Map) data.get("chinaTotal");
    }
}
