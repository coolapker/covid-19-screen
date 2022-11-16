package mojospy.covid19screen.util.update;

import com.baomidou.mybatisplus.core.conditions.update.LambdaUpdateWrapper;
import mojospy.covid19screen.domain.City;
import mojospy.covid19screen.domain.Province;
import mojospy.covid19screen.service.ICityService;
import mojospy.covid19screen.service.IProvinceService;
import mojospy.covid19screen.util.Spider;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;

@Component
public class UpdateProvinceCity {
    @Resource
    IProvinceService provinceService;
    @Resource
    ICityService cityService;

    @PostConstruct
    public void add() {
        if (provinceService.count() != 0) return;
        // 省份
        List<Map> provinceList = Spider.getProvince();
        for (Map province : provinceList) {
            String pname = (String) province.get("name");
            String pid = (String) province.get("id");
            Province province1 = new Province();
            province1.setProvinceLabel(pname);
            province1.setPid(pid);
            provinceService.save(province1);

            // 城市
            List<Map> cityList = (List) province.get("children");
            if (cityList.size() == 1) continue; // 不统计港澳台下的城市
            for (Map city : cityList) {
                String cname = (String) city.get("name");
                String cid = (String) city.get("id");
                City city1 = new City();
                city1.setCityName(cname);
                city1.setPid(pid);
                city1.setCid(cid);
                cityService.save(city1);
            }
        }
    }

    @PostConstruct
    public void update() {
        List<Map> provinceList = Spider.getProvince();
        for (Map province : provinceList) {
            Map<String, Object> ptotal = (Map) province.get("total");
            Map<String, Integer> ptoday = (Map) province.get("today");
            Integer todayConfirmCount = ptoday.get("confirm");
            Integer storeConfirm = ptoday.get("storeConfirm");
            Integer deadIncr = ptoday.get("dead");
            Integer healIncr = ptoday.get("heal");


            String pid = (String) province.get("id");
            Integer pconfirm = (Integer) ptotal.get("confirm");
            Integer pheal = (Integer) ptotal.get("heal");
            Integer pdead = (Integer) ptotal.get("dead");
            Integer pexisting = pconfirm - pheal - pdead;
            String deadRate = String.format("%.2f", ((double) pdead / pconfirm) * 100);
            String curedRate = String.format("%.2f", ((double) pheal / pconfirm) * 100);

            Province province1 = new Province();
            province1.setCuredIncr(healIncr);
            province1.setDeadIncr(deadIncr);
            province1.setCurrentConfirmedIncr(storeConfirm);
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

            // 更新城市info
            List<Map> cityList = (List) province.get("children");
            for (Map city : cityList) {
                String cid = (String) city.get("id");
                Map<String, Integer> ctoday = (Map) city.get("today");
                Integer ctodayConfirm = ctoday.get("confirm");
                Map<String, Integer> ctotal = (Map) city.get("total");
                Integer cconfirm = ctotal.get("confirm");
                Integer ccured = ctotal.get("heal");
                Integer cdead = ctotal.get("dead");
                Integer cexisting = cconfirm - ccured - cdead;

                City city1 = new City();
                city1.setConfirmedIncr(ctodayConfirm);
                city1.setConfirmed(cconfirm);
                city1.setExisting(cexisting);
                city1.setCured(ccured);
                city1.setDead(cdead);
                city1.setUpdateTime(LocalDateTime.now());

                LambdaUpdateWrapper<City> cwrapper = new LambdaUpdateWrapper<>();
                cwrapper.eq(City::getCid, cid);
                cityService.update(city1, cwrapper);
            }
        }
    }
}

