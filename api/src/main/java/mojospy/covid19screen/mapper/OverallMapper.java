package mojospy.covid19screen.mapper;

import mojospy.covid19screen.domain.Overall;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import mojospy.covid19screen.tasker.UpdateOverall;

/**
* @author Administrator
* @description 针对表【t_overall】的数据库操作Mapper
* @createDate 2022-10-09 17:22:40
* @Entity mojospy.covid19screen.domain.Overall
*/
public interface OverallMapper extends BaseMapper<Overall> {
    Boolean updateOverall(Overall overall);

}




