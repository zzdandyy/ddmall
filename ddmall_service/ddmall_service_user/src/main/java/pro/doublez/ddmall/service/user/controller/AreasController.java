package pro.doublez.ddmall.service.user.controller;

import com.github.pagehelper.PageInfo;
import org.springframework.web.bind.annotation.*;
import pro.doublez.ddmall.common.pojo.Result;
import pro.doublez.ddmall.common.pojo.StatusCode;
import pro.doublez.ddmall.service.user.service.AreasService;
import pro.doublez.ddmall.user.pojo.Areas;

import javax.annotation.Resource;
import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/areas")
public class AreasController {

    @Resource
    private AreasService areasService;

    /**
     * 列表查询
     * @param areas 查询条件
     * @return Result对象
     */
    @GetMapping
    public Result<List<Areas>> findList(Areas areas) {
        List<Areas> areasList = areasService.findList(areas);
        return new Result<>(true, StatusCode.OK, "查询成功", areasList);
    }

    /**
     * 分页查询
     * @param page 页码
     * @param size 每页显示条数
     * @param areas 查询条件
     * @return Result对象
     */
    @GetMapping("/{page}/{size}")
    public Result findPage(@PathVariable int page,@PathVariable int size,Areas areas){
        PageInfo<Areas> pageInfo = areasService.findPage(areas, page, size);
        return new Result(true,StatusCode.OK,"查询成功",pageInfo);
    }

//    /**
//     * id查询
//     * @param id 查询对象的id
//     * @return Result对象
//     */
//    @GetMapping("/{id}")
//    public Result<Areas> findById(@PathVariable Integer id) {
//        Areas areas = areasService.findById(id);
//        return new Result<>(true, StatusCode.OK, "查询成功", areas);
//    }
//
    /**
     * 添加
     * @param areas 对象
     * @return Result对象
     */
    @PostMapping
    public Result add(Areas areas) {
        areasService.add(areas);
        return new Result(true, StatusCode.OK, "添加成功");
    }
//
//    /**
//     * 修改
//     * @param id 修改对象的id
//     * @param areas 修改项
//     * @return Result对象
//     */
//    @PutMapping("/{id}")
//    public Result update(@PathVariable Integer id, Areas areas) {
//        areas.setId(id);
//        areasService.update(areas);
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
//        areasService.delete(id);
//        return new Result(true, StatusCode.OK, "删除成功");
//    }
}
