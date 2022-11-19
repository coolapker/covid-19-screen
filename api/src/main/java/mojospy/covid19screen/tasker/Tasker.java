package mojospy.covid19screen.tasker;

import mojospy.covid19screen.utils.update.UpdateDaily;
import mojospy.covid19screen.utils.update.UpdateOverall;
import mojospy.covid19screen.utils.update.UpdateProvinceCity;
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

    //每天上午10:00点、下午14:00以及下午16:00执行任务
    @Scheduled(cron = "0 0 10,14,16 * * ?")
    public void update() {
        updateProvinceCity.update();
        updateOverall.update();
        updateDaily.update();
    }
}
