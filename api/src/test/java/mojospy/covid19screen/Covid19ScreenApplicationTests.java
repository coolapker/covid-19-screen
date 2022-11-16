package mojospy.covid19screen;

import mojospy.covid19screen.util.update.UpdateDaily;
import mojospy.covid19screen.util.update.UpdateProvinceCity;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

@SpringBootTest
class Covid19ScreenApplicationTests {
    @Resource
    UpdateProvinceCity updateProvinceCity;

    @Resource
    UpdateDaily updateDaily;
    @Test
    public void testDaily () {
        updateDaily.update();
    }


}

