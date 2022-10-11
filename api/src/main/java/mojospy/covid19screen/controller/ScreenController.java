package mojospy.covid19screen.controller;

import mojospy.covid19screen.service.ScreenService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping("/screen")
public class ScreenController {
    @Resource
    ScreenService screenService;


}
