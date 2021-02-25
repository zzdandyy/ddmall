package pro.doublez.ddmall.service.order.controller;

import pro.doublez.ddmall.order.pojo.UndoLog;
import com.github.pagehelper.PageInfo;
import org.springframework.web.bind.annotation.*;
import pro.doublez.ddmall.common.pojo.Result;
import pro.doublez.ddmall.common.pojo.StatusCode;
import pro.doublez.ddmall.service.order.service.UndoLogService;

import javax.annotation.Resource;
import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/undoLog")
public class UndoLogController {

    @Resource
    private UndoLogService undoLogService;

    /**
     * 列表查询
     * @param undoLog 查询条件
     * @return Result对象
     */
    @GetMapping
    public Result<List<UndoLog>> findList(UndoLog undoLog) {
        List<UndoLog> undoLogList = undoLogService.findList(undoLog);
        return new Result<>(true, StatusCode.OK, "查询成功", undoLogList);
    }

    /**
     * 分页查询
     * @param page 页码
     * @param size 每页显示条数
     * @param undoLog 查询条件
     * @return Result对象
     */
    @GetMapping("/{page}/{size}")
    public Result findPage(@PathVariable int page,@PathVariable int size,UndoLog undoLog){
        PageInfo<UndoLog> pageInfo = undoLogService.findPage(undoLog, page, size);
        return new Result(true,StatusCode.OK,"查询成功",pageInfo);
    }

    /**
     * id查询
     * @param id 查询对象的id
     * @return Result对象
     */
    @GetMapping("/{id}")
    public Result<UndoLog> findById(@PathVariable Integer id) {
        UndoLog undoLog = undoLogService.findById(id);
        return new Result<>(true, StatusCode.OK, "查询成功", undoLog);
    }

    /**
     * 添加
     * @param undoLog 对象
     * @return Result对象
     */
    @PostMapping
    public Result add(UndoLog undoLog) {
        undoLogService.add(undoLog);
        return new Result(true, StatusCode.OK, "添加成功");
    }

    /**
     * 修改
     * @param id 修改对象的id
     * @param undoLog 修改项
     * @return Result对象
     */
    @PutMapping("/{id}")
    public Result update(@PathVariable Long id, UndoLog undoLog) {
        undoLog.setId(id);
        undoLogService.update(undoLog);
        return new Result(true, StatusCode.OK, "修改成功");
    }

    /**
     * 删除
     * @param id 删除对象的id
     * @return Result对象
     */
    @DeleteMapping("/{id}")
    public Result deleteById(@PathVariable Integer id){
        undoLogService.delete(id);
        return new Result(true, StatusCode.OK, "删除成功");
    }
}
