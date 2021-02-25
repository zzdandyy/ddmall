package pro.doublez.ddmall.service.order.controller;

import pro.doublez.ddmall.order.pojo.TaskHis;
import com.github.pagehelper.PageInfo;
import org.springframework.web.bind.annotation.*;
import pro.doublez.ddmall.common.pojo.Result;
import pro.doublez.ddmall.common.pojo.StatusCode;
import pro.doublez.ddmall.service.order.service.TaskHisService;

import javax.annotation.Resource;
import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/taskHis")
public class TaskHisController {

    @Resource
    private TaskHisService taskHisService;

    /**
     * 列表查询
     * @param taskHis 查询条件
     * @return Result对象
     */
    @GetMapping
    public Result<List<TaskHis>> findList(TaskHis taskHis) {
        List<TaskHis> taskHisList = taskHisService.findList(taskHis);
        return new Result<>(true, StatusCode.OK, "查询成功", taskHisList);
    }

    /**
     * 分页查询
     * @param page 页码
     * @param size 每页显示条数
     * @param taskHis 查询条件
     * @return Result对象
     */
    @GetMapping("/{page}/{size}")
    public Result findPage(@PathVariable int page,@PathVariable int size,TaskHis taskHis){
        PageInfo<TaskHis> pageInfo = taskHisService.findPage(taskHis, page, size);
        return new Result(true,StatusCode.OK,"查询成功",pageInfo);
    }

    /**
     * id查询
     * @param id 查询对象的id
     * @return Result对象
     */
    @GetMapping("/{id}")
    public Result<TaskHis> findById(@PathVariable Integer id) {
        TaskHis taskHis = taskHisService.findById(id);
        return new Result<>(true, StatusCode.OK, "查询成功", taskHis);
    }

    /**
     * 添加
     * @param taskHis 对象
     * @return Result对象
     */
    @PostMapping
    public Result add(TaskHis taskHis) {
        taskHisService.add(taskHis);
        return new Result(true, StatusCode.OK, "添加成功");
    }

    /**
     * 修改
     * @param id 修改对象的id
     * @param taskHis 修改项
     * @return Result对象
     */
    @PutMapping("/{id}")
    public Result update(@PathVariable Long id, TaskHis taskHis) {
        taskHis.setId(id);
        taskHisService.update(taskHis);
        return new Result(true, StatusCode.OK, "修改成功");
    }

    /**
     * 删除
     * @param id 删除对象的id
     * @return Result对象
     */
    @DeleteMapping("/{id}")
    public Result deleteById(@PathVariable Integer id){
        taskHisService.delete(id);
        return new Result(true, StatusCode.OK, "删除成功");
    }
}
