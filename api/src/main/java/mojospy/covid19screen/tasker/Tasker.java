package mojospy.covid19screen.tasker;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

@Component
public class Tasker {
    @Resource
    UpdateProvinceCity UpdateProvinceCity;
    @Resource
    UpdateOverall updateOverall;

    @Scheduled(cron = "0 0 12 * * ?")
    public void update() {
        UpdateProvinceCity.update();
        updateOverall.update();

    }
}
