package mojospy.covid19screen.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import mojospy.covid19screen.domain.City;
import mojospy.covid19screen.mapper.CityMapper;
import mojospy.covid19screen.service.CityService;
import org.springframework.stereotype.Service;

/**
* @author Administrator
* @description 针对表【t_city】的数据库操作Service实现
* @createDate 2022-10-11 15:34:46
*/
@Service
public class CityServiceImpl extends ServiceImpl<CityMapper, City>
    implements CityService {

}




