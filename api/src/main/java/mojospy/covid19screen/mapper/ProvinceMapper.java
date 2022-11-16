package mojospy.covid19screen.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import mojospy.covid19screen.domain.Province;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ProvinceMapper extends BaseMapper<Province> {
    /**
     * 获取大陆死亡率
     */
    double getDeadRate();

    /**
     * 获取大陆治愈率
     */
    double getCuredRate();

    /**
     * 模糊查询省
     */
    List<Province> search(String provinceName);
}

