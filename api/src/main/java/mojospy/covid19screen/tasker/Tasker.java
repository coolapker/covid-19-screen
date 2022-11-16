package mojospy.covid19screen.tasker;

import mojospy.covid19screen.util.update.UpdateDaily;
import mojospy.covid19screen.util.update.UpdateOverall;
import mojospy.covid19screen.util.update.UpdateProvinceCity;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

@Component
public class Tasker {
    @Resource
    UpdateProvinceCity updateProvinceCity;
    @Resource
    UpdateOverall updateOverall;
    @Resource
    UpdateDaily updateDaily;

    @Scheduled(cron = "0 0 10 * * ?")
    public void update() {
        updateProvinceCity.update();
        updateOverall.update();
        updateDaily.update();

    }
}
