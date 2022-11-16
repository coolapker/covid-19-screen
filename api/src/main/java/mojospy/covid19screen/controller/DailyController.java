package mojospy.covid19screen.controller;


import lombok.extern.slf4j.Slf4j;
import mojospy.covid19screen.domain.dto.R;
import mojospy.covid19screen.service.IDailyService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/**
 * 疫情记录(Daily)表控制层
 *
 * @author libm
 * @since 2022-11-15 14:10:11
 */
@Slf4j
@RestController
@RequestMapping("/daily")
public class DailyController {
    /**
     * 服务对象
     */
    @Resource
    private IDailyService dailyService;

    @GetMapping("/list")
    public R<Map> getDaily() {
        return R.ok(dailyService.getDailyList());
    }

}

