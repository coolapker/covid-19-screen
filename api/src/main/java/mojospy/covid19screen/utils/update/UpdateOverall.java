package mojospy.covid19screen.utils.update;

import mojospy.covid19screen.domain.Overall;
import mojospy.covid19screen.service.IOverallService;
import mojospy.covid19screen.service.IProvinceService;
import mojospy.covid19screen.utils.Spider;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Map;

@Component
public class UpdateOverall {
    @Resource
    IOverallService overallService;
    @Resource
    IProvinceService provinceService;

    @PostConstruct
    public void update() {
        Map chinaTotal = Spider.getOverall();
        Map<String, Integer> total = (Map) chinaTotal.get("total");
        // 累计
        Integer confirmedCount = total.get("confirm");
        Integer curedCount = total.get("heal");
        Integer deadCount = total.get("dead");
        // 治愈率死亡率
        String curedRate = String.format("%.2f", provinceService.getCuredRate() * 100);
        String deadRate = String.format("%.2f", provinceService.getDeadRate() * 100);
        Integer importedCount = total.get("input");
        Integer currentConfirmedCount = confirmedCount - deadCount - curedCount;
        Map<String, Integer> extData = (Map) chinaTotal.get("extData");
        Integer noinfectCount = extData.get("noSymptom");
        LocalDateTime updateTime = LocalDateTime.parse((String) Spider.getData().get("lastUpdateTime"),
                DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
        // 新增
        Map<String, Integer> today = (Map) chinaTotal.get("today");
        Integer confirmedIncr = today.get("confirm");
        Integer curedIncr = today.get("heal");
        Integer deadIncr = today.get("dead");
        Integer importedIncr = today.get("input");
        Integer currentConfirmedIncr = today.get("storeConfirm");
        Integer noInfectIncr = extData.get("incrNoSymptom");

//        // 去除港澳台
//        List<Province> specialRegionList = provinceService.getSpecialRegionList();
//        // 累计确诊
//        int confirmedCountSpe = 0;
//        // 累计新增
//        int confirmedIncrSpe = 0;
//        // 现存确诊
//        int currentConfirmedCountSpe = 0;
//        // 现存新增
//        int currentConfirmedIncrSpe = 0;
//        // 累计治愈
//        int curedCountSpe = 0;
//        // 治愈新增
//        int curedIncrSpe = 0;
//        // 累计死亡
//        int deadCountSpe = 0;
//        // 死亡新增
//        int deadIncrSpe = 0;
//        // 无症状感染总数
//        int noinfectCountSpe = 0;
//        // 无症状感染新增
//        int noInfectIncrSpe = 0;
//
//        for (Province region : specialRegionList) {
//            confirmedCountSpe += region.getConfirmedCount();
//            currentConfirmedCountSpe += region.getCurrentConfirmedCount();
//            curedCountSpe += region.getCuredCount();
//            deadCountSpe += region.getDeadCount();
//            confirmedIncrSpe += region.getTodayConfirmedCount();
//            currentConfirmedIncrSpe += region.getCurrentConfirmedIncr();
//            deadIncrSpe += region.getDeadIncr();
//            curedIncrSpe += region.getCuredIncr();
//        }

        Overall overall = new Overall();
        overall.setConfirmedCount(confirmedCount);
        overall.setCuredCount(curedCount);
        overall.setDeadCount(deadCount);
        overall.setCuredRate(curedRate);
        overall.setDeadRate(deadRate);
        overall.setImportedCount(importedCount);
        overall.setCurrentConfirmedCount(currentConfirmedCount);
        overall.setCurrentConfirmedIncr(currentConfirmedIncr);
        overall.setNoInfectCount(noinfectCount);
        overall.setUpdateTime(updateTime);

        overall.setConfirmedIncr(confirmedIncr);
        overall.setCuredIncr(curedIncr);
        overall.setDeadIncr(deadIncr);
        overall.setImportedIncr(importedIncr);
        overall.setNoInfectIncr(noInfectIncr);

        overallService.insertOrUpdate(overall);
    }
}
