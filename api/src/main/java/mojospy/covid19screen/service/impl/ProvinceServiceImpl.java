package mojospy.covid19screen.service.impl;


import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import mojospy.covid19screen.domain.Province;
import mojospy.covid19screen.mapper.ProvinceMapper;
import mojospy.covid19screen.mapper.ScreenMapper;
import mojospy.covid19screen.service.ProvinceService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * (CnProvincialInfo)表服务实现类
 *
 * @author mojospy
 * @since 2022-09-28 15:28:13
 */
@Service
public class ProvinceServiceImpl extends ServiceImpl<ProvinceMapper, Province> implements ProvinceService {
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

    @Override
    public List<Province> totalList() {
        LambdaQueryWrapper<Province> wrapper = new LambdaQueryWrapper<>();
        wrapper.orderByDesc(Province::getConfirmedCount);
        return provinceMapper.selectList(wrapper);
    }

    @Override
    public List<Province> currentList() {
        LambdaQueryWrapper<Province> wrapper = new LambdaQueryWrapper<>();
        wrapper.orderByDesc(Province::getCurrentConfirmedCount);
        return provinceMapper.selectList(wrapper);
    }
}
