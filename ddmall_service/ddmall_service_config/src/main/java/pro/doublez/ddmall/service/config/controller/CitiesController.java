package pro.doublez.ddmall.service.config.controller;

import com.github.pagehelper.PageInfo;
import org.springframework.web.bind.annotation.*;
import pro.doublez.ddmall.common.pojo.Result;
import pro.doublez.ddmall.common.pojo.StatusCode;
import pro.doublez.ddmall.config.pojo.Cities;
import pro.doublez.ddmall.service.config.service.CitiesService;

import javax.annotation.Resource;
import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/cities")
public class CitiesController {

    @Resource
    private CitiesService citiesService;

    /**
     * 列表查询
     * @param cities 查询条件
     * @return Result对象
     */
    @GetMapping
    public Result<List<Cities>> findList(Cities cities) {
        List<Cities> citiesList = citiesService.findList(cities);
        return new Result<>(true, StatusCode.OK, "查询成功", citiesList);
    }

    /**
     * 分页查询
     * @param page 页码
     * @param size 每页显示条数
     * @param cities 查询条件
     * @return Result对象
     */
    @GetMapping("/{page}/{size}")
    public Result findPage(@PathVariable int page,@PathVariable int size,Cities cities){
        PageInfo<Cities> pageInfo = citiesService.findPage(cities, page, size);
        return new Result(true,StatusCode.OK,"查询成功",pageInfo);
    }

//    /**
//     * id查询
//     * @param id 查询对象的id
//     * @return Result对象
//     */
//    @GetMapping("/{id}")
//    public Result<Cities> findById(@PathVariable Integer id) {
//        Cities cities = citiesService.findById(id);
//        return new Result<>(true, StatusCode.OK, "查询成功", cities);
//    }
//
    /**
     * 添加
     * @param cities 对象
     * @return Result对象
     */
    @PostMapping
    public Result add(Cities cities) {
        citiesService.add(cities);
        return new Result(true, StatusCode.OK, "添加成功");
    }
//
//    /**
//     * 修改
//     * @param id 修改对象的id
//     * @param cities 修改项
//     * @return Result对象
//     */
//    @PutMapping("/{id}")
//    public Result update(@PathVariable Integer id, Cities cities) {
//        cities.setId(id);
//        citiesService.update(cities);
//        return new Result(true, StatusCode.OK, "修改成功");
//    }
//
//    /**
//     * 删除
//     * @param id 删除对象的id
//     * @return Result对象
//     */
//    @DeleteMapping("/{id}")
//    public Result deleteById(@PathVariable Integer id){
//        citiesService.delete(id);
//        return new Result(true, StatusCode.OK, "删除成功");
//    }
}
