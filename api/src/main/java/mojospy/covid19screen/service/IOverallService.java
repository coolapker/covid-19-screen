package mojospy.covid19screen.service;

import mojospy.covid19screen.domain.Overall;
import com.baomidou.mybatisplus.extension.service.IService;
import org.springframework.stereotype.Service;

/**
* @author Administrator
* @description 针对表【t_overall】的数据库操作Service
* @createDate 2022-10-09 17:22:40
*/
@Service
public interface IOverallService extends IService<Overall> {
    /**
     * 插入或更新
     */
    Boolean insertOrUpdate(Overall overall);

}
