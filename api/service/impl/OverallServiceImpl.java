package .service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import .domain.Overall;
import .service.OverallService;
import .mapper.OverallMapper;
import org.springframework.stereotype.Service;

/**
* @author Administrator
* @description 针对表【t_overall】的数据库操作Service实现
* @createDate 2022-10-09 17:23:27
*/
@Service
public class OverallServiceImpl extends ServiceImpl<OverallMapper, Overall>
    implements OverallService{

}




