package mojospy.covid19screen.service.impl;


import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import mojospy.covid19screen.domain.Province;
import mojospy.covid19screen.mapper.ProvinceMapper;
import mojospy.covid19screen.service.IProvinceService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * (CnProvincialInfo)表服务实现类
 *
 * @author mojospy
 * @since 2022-09-28 15:28:13
 */
@Service
public class ProvinceServiceImpl extends ServiceImpl<ProvinceMapper, Province> implements IProvinceService {
    @Resource
    ProvinceMapper provinceMapper;

    @Override
    public List<Province> getSpecialRegionList() {
        LambdaQueryWrapper<Province> wrapper = new LambdaQueryWrapper<>();
        wrapper.eq(Province::getProvinceLabel, "香港")
                .or()
                .eq(Province::getProvinceLabel, "澳门")
                .or()
                .eq(Province::getProvinceLabel, "台湾");
        return provinceMapper.selectList(wrapper);
    }

    /**
     * 获取死率
     */
    @Override
    public double getDeadRate() {
        return provinceMapper.getDeadRate();
    }

    @Override
    public double getCuredRate() {
        return provinceMapper.getCuredRate();
    }

    /**
     * 获取累计确诊
     */
    @Override
    public List<Province> getTotal() {
        LambdaQueryWrapper<Province> wrapper = new LambdaQueryWrapper<>();
        wrapper.orderByDesc(Province::getConfirmedCount);
        return provinceMapper.selectList(wrapper);
    }

    /**
     * 获取现存确诊
     */
    @Override
    public List<Province> currentList() {
        LambdaQueryWrapper<Province> wrapper = new LambdaQueryWrapper<>();
        wrapper.orderByDesc(Province::getCurrentConfirmedCount);
        return provinceMapper.selectList(wrapper);
    }

    /**
     * 模糊查询省
     */
    @Override
    public List<Province> search(String provinceNames) {
        String[] provinces = provinceNames.split("[,，]");
        List<Province> provinceList = new ArrayList<>();
        for (String province : provinces) {
            List<Province> list = provinceMapper.search(province);
            provinceList.addAll(list);
        }
        return provinceList;
    }
}