package mojospy.covid19screen.service;

import com.baomidou.mybatisplus.extension.service.IService;
import mojospy.covid19screen.domain.Daily;

import java.util.List;
import java.util.Map;

/**
 * 疫情记录(Daily)表服务接口
 *
 * @author libm
 * @since 2022-11-15 14:10:11
 */
public interface IDailyService extends IService<Daily> {

    /**
     * 获取日常列表
     */
    Map getDailyList();
}

