package pro.doublez.ddmall.service.goods.controller;

import com.github.pagehelper.PageInfo;
import org.springframework.web.bind.annotation.*;
import pro.doublez.ddmall.common.pojo.Result;
import pro.doublez.ddmall.common.pojo.StatusCode;
import pro.doublez.ddmall.goods.pojo.CategoryBrand;
import pro.doublez.ddmall.service.goods.service.CategoryBrandService;

import javax.annotation.Resource;
import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/categoryBrand")
public class CategoryBrandController {

    @Resource
    private CategoryBrandService categoryBrandService;

    /**
     * 列表查询
     * @param categoryBrand 查询条件
     * @return Result对象
     */
    @GetMapping
    public Result<List<CategoryBrand>> findList(CategoryBrand categoryBrand) {
        List<CategoryBrand> categoryBrandList = categoryBrandService.findList(categoryBrand);
        return new Result<>(true, StatusCode.OK, "查询成功", categoryBrandList);
    }

    /**
     * 分页查询
     * @param page 页码
     * @param size 每页显示条数
     * @param categoryBrand 查询条件
     * @return Result对象
     */
    @GetMapping("/{page}/{size}")
    public Result findPage(@PathVariable int page,@PathVariable int size,CategoryBrand categoryBrand){
        PageInfo<CategoryBrand> pageInfo = categoryBrandService.findPage(categoryBrand, page, size);
        return new Result(true,StatusCode.OK,"查询成功",pageInfo);
    }
//
//    /**
//     * id查询
//     * @param id 查询对象的id
//     * @return Result对象
//     */
//    @GetMapping("/{id}")
//    public Result<CategoryBrand> findById(@PathVariable Integer id) {
//        CategoryBrand categoryBrand = categoryBrandService.findById(id);
//        return new Result<>(true, StatusCode.OK, "查询成功", categoryBrand);
//    }
//
    /**
     * 添加
     * @param categoryBrand 对象
     * @return Result对象
     */
    @PostMapping
    public Result add(CategoryBrand categoryBrand) {
        categoryBrandService.add(categoryBrand);
        return new Result(true, StatusCode.OK, "添加成功");
    }
//
//    /**
//     * 修改
//     * @param id 修改对象的id
//     * @param categoryBrand 修改项
//     * @return Result对象
//     */
//    @PutMapping("/{id}")
//    public Result update(@PathVariable Integer id, CategoryBrand categoryBrand) {
//        categoryBrand.setId(id);
//        categoryBrandService.update(categoryBrand);
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
//        categoryBrandService.delete(id);
//        return new Result(true, StatusCode.OK, "删除成功");
//    }
}
