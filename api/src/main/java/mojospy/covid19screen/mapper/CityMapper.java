package mojospy.covid19screen.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import mojospy.covid19screen.domain.City;

import java.util.List;

/**
* @author Administrator
* @description 针对表【t_city】的数据库操作Mapper
* @createDate 2022-10-11 15:34:46
* @Entity generator.domain.City
*/
public interface CityMapper extends BaseMapper<City> {

    /**
     * 城市现有确诊排序
     */
    List<City> getIncr();
}




