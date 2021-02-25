package pro.doublez.ddmall.service.order.controller;

import pro.doublez.ddmall.order.pojo.CategoryReport;
import com.github.pagehelper.PageInfo;
import org.springframework.web.bind.annotation.*;
import pro.doublez.ddmall.common.pojo.Result;
import pro.doublez.ddmall.common.pojo.StatusCode;
import pro.doublez.ddmall.service.order.service.CategoryReportService;

import javax.annotation.Resource;
import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/categoryReport")
public class CategoryReportController {

    @Resource
    private CategoryReportService categoryReportService;

    /**
     * 列表查询
     * @param categoryReport 查询条件
     * @return Result对象
     */
    @GetMapping
    public Result<List<CategoryReport>> findList(CategoryReport categoryReport) {
        List<CategoryReport> categoryReportList = categoryReportService.findList(categoryReport);
        return new Result<>(true, StatusCode.OK, "查询成功", categoryReportList);
    }

    /**
     * 分页查询
     * @param page 页码
     * @param size 每页显示条数
     * @param categoryReport 查询条件
     * @return Result对象
     */
    @GetMapping("/{page}/{size}")
    public Result findPage(@PathVariable int page,@PathVariable int size,CategoryReport categoryReport){
        PageInfo<CategoryReport> pageInfo = categoryReportService.findPage(categoryReport, page, size);
        return new Result(true,StatusCode.OK,"查询成功",pageInfo);
    }
//
//    /**
//     * id查询
//     * @param id 查询对象的id
//     * @return Result对象
//     */
//    @GetMapping("/{id}")
//    public Result<CategoryReport> findById(@PathVariable Integer id) {
//        CategoryReport categoryReport = categoryReportService.findById(id);
//        return new Result<>(true, StatusCode.OK, "查询成功", categoryReport);
//    }
//
    /**
     * 添加
     * @param categoryReport 对象
     * @return Result对象
     */
    @PostMapping
    public Result add(CategoryReport categoryReport) {
        categoryReportService.add(categoryReport);
        return new Result(true, StatusCode.OK, "添加成功");
    }
//
//    /**
//     * 修改
//     * @param id 修改对象的id
//     * @param categoryReport 修改项
//     * @return Result对象
//     */
//    @PutMapping("/{id}")
//    public Result update(@PathVariable Integer id, CategoryReport categoryReport) {
//        categoryReport.setId(id);
//        categoryReportService.update(categoryReport);
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
//        categoryReportService.delete(id);
//        return new Result(true, StatusCode.OK, "删除成功");
//    }
}
