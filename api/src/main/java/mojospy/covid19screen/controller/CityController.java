package mojospy.covid19screen.controller;


import mojospy.covid19screen.domain.City;
import mojospy.covid19screen.domain.dto.R;
import mojospy.covid19screen.service.ICityService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * 表控制层
 *
 * @author mojospy
 * @since 2022-09-28 15:28:13
 */
@RestController
@RequestMapping("/city")
public class CityController {
    /**
     * 服务对象
     */
    @Resource
    ICityService cityService;

    /**
     * 获取城市新增
     */
    @GetMapping("/incr")
    public R<List<City>> getIncr() {
        return R.ok(this.cityService.getIncr());
    }

}

