package mojospy.covid19screen.tasker;

import cn.hutool.http.HttpRequest;
import com.alibaba.fastjson2.JSONObject;
import com.baomidou.mybatisplus.core.conditions.update.LambdaUpdateWrapper;
import mojospy.covid19screen.domain.Province;
import mojospy.covid19screen.service.ProvinceService;
import mojospy.covid19screen.util.Spider;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;

@Component
public class UpdateProvince {
    @Resource
    ProvinceService provinceService;

    public List<Map> getInfo() {
        // 网易接口
        String api = "https://c.m.163.com/ug/api/wuhan/app/data/list-total?t=332870247707";
        // 获取到的json数据转换为map
        String response = HttpRequest.get(api).execute().body();
        Map map = JSONObject.parseObject(response, Map.class);

        // 响应json里的data
        Map data = (Map) map.get("data");
        // 全球数据
        List areaTree = (List) data.get("areaTree");
        // 中国数据
        Map cn = (Map) areaTree.get(2);
        // 省份数据
        List<Map> provinceInfo = (List) cn.get("children");

        return provinceInfo;
    }

    @PostConstruct
    public void add() {
        if (provinceService.list().size() != 0) return;
        // 省份info
        List<Map> info = Spider.getProvince();
        for (Map province : info) {
            String pname = (String) province.get("name");
            String pid = (String) province.get("id");
            Province province1 = new Province();
            province1.setProvinceLabel(pname);
            province1.setPid(pid);
            provinceService.save(province1);
        }
    }

    @PostConstruct
    public void update() {
        List<Map> info = Spider.getProvince();
        for (Map province : info) {
            Map<String, Object> ptotal = (Map) province.get("total");
            Map<String, Integer> ptoday = (Map) province.get("today");
            Integer todayConfirmCount = ptoday.get("confirm");
            String pid = (String) province.get("id");
            Integer pconfirm = (Integer) ptotal.get("confirm");
            Integer pheal = (Integer) ptotal.get("heal");
            Integer pdead = (Integer) ptotal.get("dead");
            Integer pexisting = pconfirm - pheal - pdead;
            String deadRate  = String.format("%.2f", ((double)pdead/pconfirm)*100);
            String curedRate = String.format("%.2f", ((double)pheal/pconfirm)*100);

            Province province1 = new Province();
            province1.setTodayConfirmedCount(todayConfirmCount);
            province1.setDeadCount(pdead);
            province1.setCuredCount(pheal);
            province1.setConfirmedCount(pconfirm);
            province1.setCurrentConfirmedCount(pexisting);
            province1.setDeadRate(deadRate);
            province1.setCuredRate(curedRate);
            province1.setUpdateTime(LocalDateTime.now());

            LambdaUpdateWrapper<Province> pwrapper = new LambdaUpdateWrapper<>();
            pwrapper.eq(Province::getPid, pid);
            provinceService.update(province1, pwrapper);
        }
    }
}

