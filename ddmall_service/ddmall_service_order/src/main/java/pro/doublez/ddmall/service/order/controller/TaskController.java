package pro.doublez.ddmall.service.order.controller;

import pro.doublez.ddmall.order.pojo.Task;
import com.github.pagehelper.PageInfo;
import org.springframework.web.bind.annotation.*;
import pro.doublez.ddmall.common.pojo.Result;
import pro.doublez.ddmall.common.pojo.StatusCode;
import pro.doublez.ddmall.service.order.service.TaskService;

import javax.annotation.Resource;
import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/task")
public class TaskController {

    @Resource
    private TaskService taskService;

    /**
     * 列表查询
     * @param task 查询条件
     * @return Result对象
     */
    @GetMapping
    public Result<List<Task>> findList(Task task) {
        List<Task> taskList = taskService.findList(task);
        return new Result<>(true, StatusCode.OK, "查询成功", taskList);
    }

    /**
     * 分页查询
     * @param page 页码
     * @param size 每页显示条数
     * @param task 查询条件
     * @return Result对象
     */
    @GetMapping("/{page}/{size}")
    public Result findPage(@PathVariable int page,@PathVariable int size,Task task){
        PageInfo<Task> pageInfo = taskService.findPage(task, page, size);
        return new Result(true,StatusCode.OK,"查询成功",pageInfo);
    }

    /**
     * id查询
     * @param id 查询对象的id
     * @return Result对象
     */
    @GetMapping("/{id}")
    public Result<Task> findById(@PathVariable Integer id) {
        Task task = taskService.findById(id);
        return new Result<>(true, StatusCode.OK, "查询成功", task);
    }

    /**
     * 添加
     * @param task 对象
     * @return Result对象
     */
    @PostMapping
    public Result add(Task task) {
        taskService.add(task);
        return new Result(true, StatusCode.OK, "添加成功");
    }

    /**
     * 修改
     * @param id 修改对象的id
     * @param task 修改项
     * @return Result对象
     */
    @PutMapping("/{id}")
    public Result update(@PathVariable Long id, Task task) {
        task.setId(id);
        taskService.update(task);
        return new Result(true, StatusCode.OK, "修改成功");
    }

    /**
     * 删除
     * @param id 删除对象的id
     * @return Result对象
     */
    @DeleteMapping("/{id}")
    public Result deleteById(@PathVariable Integer id){
        taskService.delete(id);
        return new Result(true, StatusCode.OK, "删除成功");
    }
}
