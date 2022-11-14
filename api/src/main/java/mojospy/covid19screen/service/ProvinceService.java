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
     */
    List<Province> getSpecialRegionList();

    /**
     * 获取累计确诊（排序）数据
     */
    List<Province> getTotal();

    //    获取大陆省份死亡率
    double getDeadRate();

    double getCuredRate();


    List<Province> currentList();

}
