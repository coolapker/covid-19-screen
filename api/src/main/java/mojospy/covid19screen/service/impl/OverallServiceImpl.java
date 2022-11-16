package mojospy.covid19screen.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import mojospy.covid19screen.domain.Overall;
import mojospy.covid19screen.service.IOverallService;
import mojospy.covid19screen.mapper.OverallMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
* @author Administrator
* @description 针对表【t_overall】的数据库操作Service实现
* @createDate 2022-10-09 17:22:40
*/
@Service
public class OverallServiceImpl extends ServiceImpl<OverallMapper, Overall>
    implements IOverallService {
    @Resource
    OverallMapper overallMapper;

    @Override
    public Boolean insertOrUpdate(Overall overall) {
        if (count() == 0) {
            save(overall);
        }
        return overallMapper.updateOverall(overall);
    }
}




