package mojospy.covid19screen.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import mojospy.covid19screen.domain.Daily;
import mojospy.covid19screen.mapper.DailyMapper;
import mojospy.covid19screen.service.IDailyService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 疫情记录(Daily)表服务实现类
 *
 * @author libm
 * @since 2022-11-15 14:10:11
 */
@Service
public class DailyServiceImpl extends ServiceImpl<DailyMapper, Daily> implements IDailyService {

    @Resource
    DailyMapper dailyMapper;

    /**
     * 获取日常列表
     */
    @Override
    public Map getDailyList() {
        List<Daily> list = dailyMapper.list();
        Map<String, List> map = new HashMap<>();
        // 累计确诊
        List confirmedCountList = new ArrayList<>();
        // 累计治愈
        List curedCountList = new ArrayList<>();
        // 现有确诊新增
        List currentConfirmedIncrList = new ArrayList<>();
        // 境外输入新增
        List importedIncrList = new ArrayList<>();
        for (Daily daily : list) {
            String dateOfStr = daily.getDateOf().toString().substring(5);
            Integer confirmedCount = daily.getConfirmedCount();
            Integer curedCount = daily.getCuredCount();
            List ls = new ArrayList<>();
            ls.add(dateOfStr);
            ls.add(confirmedCount);
            confirmedCountList.add(ls);

            List ls2 = new ArrayList<>();
            ls2.add(dateOfStr);
            ls2.add(curedCount);
            curedCountList.add(ls2);

            Integer confirmedIncr = daily.getConfirmedIncr();
            List existingIncrList = new ArrayList<>();
            existingIncrList.add(dateOfStr);
            existingIncrList.add(confirmedIncr);
            currentConfirmedIncrList.add(existingIncrList);

            Integer inputIncr = daily.getInputIncr();
            List inputIncrList = new ArrayList<>();
            inputIncrList.add(dateOfStr);
            inputIncrList.add(inputIncr);
            importedIncrList.add(inputIncrList);
        }
        map.put("confirmedCountList", confirmedCountList);
        map.put("curedCountList", curedCountList);
        map.put("currentConfirmedIncrList", currentConfirmedIncrList);
        map.put("importedIncrList", importedIncrList);

        return map;
    }
}

