package mojospy.covid19screen.controller;


import mojospy.covid19screen.domain.Province;
import mojospy.covid19screen.domain.dto.R;
import mojospy.covid19screen.service.IProvinceService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * 表控制层
 *
 * @author mojospy
 * @since 2022-09-28 15:28:13
 */
@RestController
@RequestMapping("/province")
public class ProvinceController {
    /**
     * 服务对象
     */
    @Resource
    IProvinceService provinceService;

    /**
     * 获取省累计确诊
     */
    @GetMapping("/totalDesc")
    public R<List<Province>> getTotal() {
        return R.ok(this.provinceService.getTotal());
    }

    /**
     * 获取省现存确诊
     */
    @GetMapping("/existing")
    public R<List<Province>> getCurrent() {
        return R.ok(this.provinceService.currentList());
    }

    /*
     * 获取港澳台新增
     * */
    @GetMapping("/specialRegion")
    public R<List<Province>> getSpecialRegion() {
        return R.ok(this.provinceService.getSpecialRegionList());
    }

    /**
     * 模糊查询多个省 (逗号间隔)
     */
    @GetMapping("/search")
    public R<List<Province>> search(@RequestParam String provinceNames) {
        return R.ok(this.provinceService.search(provinceNames));
    }
}

