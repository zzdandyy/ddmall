package pro.doublez.ddmall.service.user.controller;

import com.github.pagehelper.PageInfo;
import org.springframework.web.bind.annotation.*;
import pro.doublez.ddmall.common.pojo.Result;
import pro.doublez.ddmall.common.pojo.StatusCode;
import pro.doublez.ddmall.service.user.service.StockBackService;
import pro.doublez.ddmall.user.pojo.StockBack;

import javax.annotation.Resource;
import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/stockBack")
public class StockBackController {

    @Resource
    private StockBackService stockBackService;

    /**
     * 列表查询
     * @param stockBack 查询条件
     * @return Result对象
     */
    @GetMapping
    public Result<List<StockBack>> findList(StockBack stockBack) {
        List<StockBack> stockBackList = stockBackService.findList(stockBack);
        return new Result<>(true, StatusCode.OK, "查询成功", stockBackList);
    }

    /**
     * 分页查询
     * @param page 页码
     * @param size 每页显示条数
     * @param stockBack 查询条件
     * @return Result对象
     */
    @GetMapping("/{page}/{size}")
    public Result findPage(@PathVariable int page,@PathVariable int size,StockBack stockBack){
        PageInfo<StockBack> pageInfo = stockBackService.findPage(stockBack, page, size);
        return new Result(true,StatusCode.OK,"查询成功",pageInfo);
    }

//    /**
//     * id查询
//     * @param id 查询对象的id
//     * @return Result对象
//     */
//    @GetMapping("/{id}")
//    public Result<StockBack> findById(@PathVariable Integer id) {
//        StockBack stockBack = stockBackService.findById(id);
//        return new Result<>(true, StatusCode.OK, "查询成功", stockBack);
//    }
//
    /**
     * 添加
     * @param stockBack 对象
     * @return Result对象
     */
    @PostMapping
    public Result add(StockBack stockBack) {
        stockBackService.add(stockBack);
        return new Result(true, StatusCode.OK, "添加成功");
    }
//
//    /**
//     * 修改
//     * @param id 修改对象的id
//     * @param stockBack 修改项
//     * @return Result对象
//     */
//    @PutMapping("/{id}")
//    public Result update(@PathVariable Integer id, StockBack stockBack) {
//        stockBack.setId(id);
//        stockBackService.update(stockBack);
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
//        stockBackService.delete(id);
//        return new Result(true, StatusCode.OK, "删除成功");
//    }
}
