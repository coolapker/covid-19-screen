package mojospy.covid19screen.service;

import com.baomidou.mybatisplus.extension.service.IService;
import mojospy.covid19screen.domain.City;

import java.util.List;

/**
* @author Administrator
* @description 针对表【t_city】的数据库操作Service
* @createDate 2022-10-11 15:34:46
*/
public interface ICityService extends IService<City> {

    /**
     * 城市现有确诊排序
     */
    List<City> getIncr();

    /**
     * 模糊查询城市
     */
    List<City> search(String cityName);
}
