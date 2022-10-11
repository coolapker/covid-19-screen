package mojospy.covid19screen.service;


import com.baomidou.mybatisplus.extension.service.IService;
import mojospy.covid19screen.domain.Province;

import java.util.List;

/**
 * (CnProvincialInfo)表服务接口
 *
 * @author mojospy
 * @since 2022-09-28 15:28:13
 */
public interface ProvinceService extends IService<Province> {

    /**
     * 获取港澳台数据
     *
     * @return List<Province>
     */
    List<Province> getSpecialRegionList();
    List<Province> totalList();

    List<Province> currentList();

}
