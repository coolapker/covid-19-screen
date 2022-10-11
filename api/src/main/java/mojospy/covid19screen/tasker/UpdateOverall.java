package mojospy.covid19screen.tasker;

import com.baomidou.mybatisplus.core.conditions.update.LambdaUpdateWrapper;
import mojospy.covid19screen.domain.Overall;
import mojospy.covid19screen.mapper.OverallMapper;
import mojospy.covid19screen.service.OverallService;
import mojospy.covid19screen.util.Spider;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Map;

@Component
public class UpdateOverall {
    @Resource
    OverallService overallService;

    @PostConstruct
    public void update() {
        Map chinaTotal = Spider.getOverall();
        Map<String, Integer> total = (Map) chinaTotal.get("total");
        // 累计
        Integer confirmedCount = total.get("confirm");
        Integer curedCount = total.get("heal");
        Integer deadCount = total.get("dead");
        String curedRate = String.format("%.2f", (double) curedCount / confirmedCount);
        String deadRate = String.format("%.2f", (double) deadCount / confirmedCount);
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

        Overall overall = new Overall();
        overall.setConfirmedCount(confirmedCount);
        overall.setCuredCount(curedCount);
        overall.setDeadCount(deadCount);
        overall.setCuredRate(curedRate);
        overall.setDeadRate(deadRate);
        overall.setImportedCount(importedCount);
        overall.setCurrentConfirmedCount(currentConfirmedCount);
        overall.setNoInfectCount(noinfectCount);
        overall.setUpdateTime(updateTime);

        overall.setConfirmedIncr(confirmedIncr);
        overall.setCuredIncr(curedIncr);
        overall.setDeadIncr(deadIncr);
        overall.setImportedIncr(importedIncr);
        overall.setCurrentConfirmedIncr(currentConfirmedIncr);
        overall.setNoInfectIncr(noInfectIncr);


        overallService.insertOrUpdate(overall);
    }
}
