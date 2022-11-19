package mojospy.covid19screen.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import mojospy.covid19screen.domain.City;
import mojospy.covid19screen.mapper.CityMapper;
import mojospy.covid19screen.service.ICityService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Administrator
 */
@Service
public class CityServiceImpl extends ServiceImpl<CityMapper, City>
        implements ICityService {
    @Resource
    CityMapper cityMapper;

    /**
     * 城市现有确诊排序
     */
    @Override
    public List<City> getIncr() {
        return cityMapper.getIncr();
//        LambdaQueryWrapper<City> wrapper = new LambdaQueryWrapper<>();
//        wrapper.orderByDesc(City::getExisting)
//        return cityMapper.selectList(wrapper);
    }

    /**
     * 模糊查询城市
     */
    @Override
    public List<City> search(String cityNames) {
        String[] cities = cityNames.split("[,，]");
        List<City> cityList = new ArrayList<>();
        for (String city : cities) {
            List<City> list = cityMapper.search(city);
            cityList.addAll(list);
        }
        return cityList;
    }
}




