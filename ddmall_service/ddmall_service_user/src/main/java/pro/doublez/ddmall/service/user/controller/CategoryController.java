package pro.doublez.ddmall.service.user.controller;

import com.github.pagehelper.PageInfo;
import org.springframework.web.bind.annotation.*;
import pro.doublez.ddmall.common.pojo.Result;
import pro.doublez.ddmall.common.pojo.StatusCode;
import pro.doublez.ddmall.service.user.service.CategoryService;
import pro.doublez.ddmall.user.pojo.Category;

import javax.annotation.Resource;
import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/category")
public class CategoryController {

    @Resource
    private CategoryService categoryService;

    /**
     * 列表查询
     * @param category 查询条件
     * @return Result对象
     */
    @GetMapping
    public Result<List<Category>> findList(Category category) {
        List<Category> categoryList = categoryService.findList(category);
        return new Result<>(true, StatusCode.OK, "查询成功", categoryList);
    }

    /**
     * 分页查询
     * @param page 页码
     * @param size 每页显示条数
     * @param category 查询条件
     * @return Result对象
     */
    @GetMapping("/{page}/{size}")
    public Result findPage(@PathVariable int page,@PathVariable int size,Category category){
        PageInfo<Category> pageInfo = categoryService.findPage(category, page, size);
        return new Result(true,StatusCode.OK,"查询成功",pageInfo);
    }

    /**
     * id查询
     * @param id 查询对象的id
     * @return Result对象
     */
    @GetMapping("/{id}")
    public Result<Category> findById(@PathVariable Integer id) {
        Category category = categoryService.findById(id);
        return new Result<>(true, StatusCode.OK, "查询成功", category);
    }

    /**
     * 添加
     * @param category 对象
     * @return Result对象
     */
    @PostMapping
    public Result add(Category category) {
        categoryService.add(category);
        return new Result(true, StatusCode.OK, "添加成功");
    }

    /**
     * 修改
     * @param id 修改对象的id
     * @param category 修改项
     * @return Result对象
     */
    @PutMapping("/{id}")
    public Result update(@PathVariable Integer id, Category category) {
        category.setId(id);
        categoryService.update(category);
        return new Result(true, StatusCode.OK, "修改成功");
    }

    /**
     * 删除
     * @param id 删除对象的id
     * @return Result对象
     */
    @DeleteMapping("/{id}")
    public Result deleteById(@PathVariable Integer id){
        categoryService.delete(id);
        return new Result(true, StatusCode.OK, "删除成功");
    }
}
