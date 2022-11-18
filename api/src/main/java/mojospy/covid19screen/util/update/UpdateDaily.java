package mojospy.covid19screen.util.update;

import mojospy.covid19screen.domain.Daily;
import mojospy.covid19screen.service.IDailyService;
import mojospy.covid19screen.util.Spider;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import java.time.LocalDate;
import java.util.List;
import java.util.Map;

@Component
public class UpdateDaily {
    @Resource
    IDailyService dailyService;

    @PostConstruct
    public void update() {
        List<Map> dailyList = Spider.getDaily();
        for (Map day : dailyList) {
            String dateStr = (String) day.get("date");
            LocalDate date = LocalDate.parse(dateStr);

            Map<String, Integer> total = (Map) day.get("total");
            // 累计确诊
            Integer confirm = total.get("confirm");
            // 累计治愈
            Integer heal = total.get("heal");

            Daily daily = new Daily();
            daily.setDateOf(date);
            daily.setConfirmedCount(confirm);
            daily.setCuredCount(heal);

            Map<String, Integer> today = (Map) day.get("today");
            // 现有确诊新增
            Integer confirmIncr = today.get("confirm");
            // 治愈新增
            Integer healIncr = today.get("heal");
            // 境外输入新增
            Integer inputIncr = today.get("input");

            daily.setConfirmedIncr(confirmIncr);
            daily.setInputIncr(inputIncr);
            daily.setCuredIncr(healIncr);

            dailyService.saveOrUpdate(daily);
        }
    }
}
