package mojospy.covid19screen.controller;


import mojospy.covid19screen.domain.City;
import mojospy.covid19screen.domain.Province;
import mojospy.covid19screen.domain.dto.R;
import mojospy.covid19screen.service.CityService;
import mojospy.covid19screen.service.ProvinceService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * 表控制层
 *
 * @author mojospy
 * @since 2022-09-28 15:28:13
 */
@RestController
@RequestMapping("/city")
public class CityController {
    /**
     * 服务对象
     */
    @Resource
    CityService cityService;


    /**
     * 通过主键查询单条数据
     */
    @GetMapping("{id}")
    public R<City> queryById(@PathVariable("id") Integer id) {
        return R.ok(cityService.getById(id));
    }

    /**
     * 城市新增排序
     */
    @GetMapping("/incr")
    public R<List<City>> getIncr() {
        return R.ok(this.cityService.getIncr());
    }


    /**
     * 新增数据
     */
    @PostMapping
    public ResponseEntity<Boolean> add(City city) {
        return ResponseEntity.ok(this.cityService.save(city));
    }

     /*
      编辑数据

      @param  province
     * @return 编辑结果
     */
//    @PutMapping
//    public ResponseEntity<Province> edit(Province province) {
//        return ResponseEntity.ok(this.provinceService.update());
//    }

    /**
     * 删除数据
     *
     * @param id 主键
     * @return 删除是否成功
     */
    @DeleteMapping
    public ResponseEntity<Boolean> deleteById(Integer id) {
        return ResponseEntity.ok(this.cityService.removeById(id));
    }



}

