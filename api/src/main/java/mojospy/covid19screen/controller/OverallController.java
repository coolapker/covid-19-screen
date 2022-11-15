package mojospy.covid19screen.controller;

import mojospy.covid19screen.domain.Overall;
import mojospy.covid19screen.domain.dto.R;
import mojospy.covid19screen.service.OverallService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping("/overall")
public class OverallController {
    @Resource
    OverallService overallService;

    /**
     * 获取overall数据
     */
    @GetMapping
    public R<Overall> get() {
        return R.ok(overallService.getOne(null, false));
    }

}
