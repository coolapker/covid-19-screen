package mojospy.covid19screen.service;

import com.baomidou.mybatisplus.extension.service.IService;
import mojospy.covid19screen.domain.City;

import java.util.List;

/**
 * @author Administrator
 */
public interface ICityService extends IService<City> {

    /**
     * 城市现有确诊排序
     */
    List<City> getIncr();

    /**
     * 模糊查询城市 逗号分割
     */
    List<City> search(String cityNames);
}
