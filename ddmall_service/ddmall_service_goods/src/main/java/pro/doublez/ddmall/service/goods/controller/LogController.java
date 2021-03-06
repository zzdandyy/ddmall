package pro.doublez.ddmall.service.goods.controller;

import com.github.pagehelper.PageInfo;
import org.springframework.web.bind.annotation.*;
import pro.doublez.ddmall.common.pojo.Result;
import pro.doublez.ddmall.common.pojo.StatusCode;
import pro.doublez.ddmall.goods.pojo.Log;
import pro.doublez.ddmall.service.goods.service.LogService;

import javax.annotation.Resource;
import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/log")
public class LogController {

    @Resource
    private LogService logService;

    /**
     * 列表查询
     * @param log 查询条件
     * @return Result对象
     */
    @GetMapping
    public Result<List<Log>> findList(Log log) {
        List<Log> logList = logService.findList(log);
        return new Result<>(true, StatusCode.OK, "查询成功", logList);
    }

    /**
     * 分页查询
     * @param page 页码
     * @param size 每页显示条数
     * @param log 查询条件
     * @return Result对象
     */
    @GetMapping("/{page}/{size}")
    public Result findPage(@PathVariable int page,@PathVariable int size,Log log){
        PageInfo<Log> pageInfo = logService.findPage(log, page, size);
        return new Result(true,StatusCode.OK,"查询成功",pageInfo);
    }

    /**
     * id查询
     * @param id 查询对象的id
     * @return Result对象
     */
    @GetMapping("/{id}")
    public Result<Log> findById(@PathVariable Long id) {
        Log log = logService.findById(id);
        return new Result<>(true, StatusCode.OK, "查询成功", log);
    }

    /**
     * 添加
     * @param log 对象
     * @return Result对象
     */
    @PostMapping
    public Result add(Log log) {
        logService.add(log);
        return new Result(true, StatusCode.OK, "添加成功");
    }

    /**
     * 修改
     * @param id 修改对象的id
     * @param log 修改项
     * @return Result对象
     */
    @PutMapping("/{id}")
    public Result update(@PathVariable Long id, Log log) {
        log.setId(id);
        logService.update(log);
        return new Result(true, StatusCode.OK, "修改成功");
    }

    /**
     * 删除
     * @param id 删除对象的id
     * @return Result对象
     */
    @DeleteMapping("/{id}")
    public Result deleteById(@PathVariable Long id){
        logService.delete(id);
        return new Result(true, StatusCode.OK, "删除成功");
    }
}
