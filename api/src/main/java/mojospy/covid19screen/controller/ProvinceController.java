package mojospy.covid19screen.controller;


import mojospy.covid19screen.domain.Province;
import mojospy.covid19screen.domain.dto.R;
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
@RequestMapping("/province")
public class ProvinceController {
    /**
     * 服务对象
     */
    @Resource
    ProvinceService provinceService;


    /**
     * 通过主键查询单条数据
     */
    @GetMapping("{id}")
    public ResponseEntity<Province> queryById(@PathVariable("id") Integer id) {
        return ResponseEntity.ok(this.provinceService.getById(id));
    }

    /**
     * 获取累计确诊（排序）数据
     */
    @GetMapping("/totalDesc")
    public R<List<Province>> getTotal() {
        return R.ok(this.provinceService.getTotal());
    }

    /**
     * 获取现存确诊（排序）数据
     */
//    @GetMapping("/confirmed/current")
//    public R<List<Province>> getCurrent() {
//        return R.ok(this.provinceService.currentList());
//    }

    /*
    * 港澳台新增
    * */
    @GetMapping("/specialRegion")
    public R<List<Province>> getSpecialRegion() {
        return R.ok(this.provinceService.getSpecialRegionList());
    }
    /**
     * 新增数据
     */
    @PostMapping
    public ResponseEntity<Boolean> add(Province province) {
        return ResponseEntity.ok(this.provinceService.save(province));
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
        return ResponseEntity.ok(this.provinceService.removeById(id));
    }



}

