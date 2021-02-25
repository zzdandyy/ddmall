package pro.doublez.ddmall.service.user.controller;

import com.github.pagehelper.PageInfo;
import org.springframework.web.bind.annotation.*;
import pro.doublez.ddmall.common.pojo.Result;
import pro.doublez.ddmall.common.pojo.StatusCode;
import pro.doublez.ddmall.service.user.service.ProvincesService;
import pro.doublez.ddmall.user.pojo.Provinces;

import javax.annotation.Resource;
import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/provinces")
public class ProvincesController {

    @Resource
    private ProvincesService provincesService;

    /**
     * 列表查询
     * @param provinces 查询条件
     * @return Result对象
     */
    @GetMapping
    public Result<List<Provinces>> findList(Provinces provinces) {
        List<Provinces> provincesList = provincesService.findList(provinces);
        return new Result<>(true, StatusCode.OK, "查询成功", provincesList);
    }

    /**
     * 分页查询
     * @param page 页码
     * @param size 每页显示条数
     * @param provinces 查询条件
     * @return Result对象
     */
    @GetMapping("/{page}/{size}")
    public Result findPage(@PathVariable int page,@PathVariable int size,Provinces provinces){
        PageInfo<Provinces> pageInfo = provincesService.findPage(provinces, page, size);
        return new Result(true,StatusCode.OK,"查询成功",pageInfo);
    }

//    /**
//     * id查询
//     * @param id 查询对象的id
//     * @return Result对象
//     */
//    @GetMapping("/{id}")
//    public Result<Provinces> findById(@PathVariable Integer id) {
//        Provinces provinces = provincesService.findById(id);
//        return new Result<>(true, StatusCode.OK, "查询成功", provinces);
//    }
//
    /**
     * 添加
     * @param provinces 对象
     * @return Result对象
     */
    @PostMapping
    public Result add(Provinces provinces) {
        provincesService.add(provinces);
        return new Result(true, StatusCode.OK, "添加成功");
    }
//
//    /**
//     * 修改
//     * @param id 修改对象的id
//     * @param provinces 修改项
//     * @return Result对象
//     */
//    @PutMapping("/{id}")
//    public Result update(@PathVariable Integer id, Provinces provinces) {
//        provinces.setId(id);
//        provincesService.update(provinces);
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
//        provincesService.delete(id);
//        return new Result(true, StatusCode.OK, "删除成功");
//    }
}
