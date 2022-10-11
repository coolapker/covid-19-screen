package mojospy.covid19screen.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import mojospy.covid19screen.domain.Province;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface ProvinceMapper extends BaseMapper<Province> {
}

