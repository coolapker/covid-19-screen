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
public interface IProvinceService extends IService<Province> {

    /**
     * 获取港澳台数据
     */
    List<Province> getSpecialRegionList();

    /**
     * 获取累计确诊
     */
    List<Province> getTotal();

    /**
     * 获取现存确诊
     */
    List<Province> currentList();


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
    List<Province> search(String provinceNames);
}
