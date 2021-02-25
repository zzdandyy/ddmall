package pro.doublez.ddmall.service.business.controller;

import com.github.pagehelper.PageInfo;
import org.springframework.web.bind.annotation.*;
import pro.doublez.ddmall.business.pojo.Activity;
import pro.doublez.ddmall.common.pojo.Result;
import pro.doublez.ddmall.common.pojo.StatusCode;
import pro.doublez.ddmall.service.business.service.ActivityService;

import javax.annotation.Resource;
import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/activity")
public class ActivityController {

    @Resource
    private ActivityService activityService;

    /**
     * 列表查询
     * @param activity 查询条件
     * @return Result对象
     */
    @GetMapping
    public Result<List<Activity>> findList(Activity activity) {
        List<Activity> activityList = activityService.findList(activity);
        return new Result<>(true, StatusCode.OK, "查询成功", activityList);
    }

    /**
     * 分页查询
     * @param page 页码
     * @param size 每页显示条数
     * @param activity 查询条件
     * @return Result对象
     */
    @GetMapping("/{page}/{size}")
    public Result findPage(@PathVariable int page,@PathVariable int size,Activity activity){
        PageInfo<Activity> pageInfo = activityService.findPage(activity, page, size);
        return new Result(true,StatusCode.OK,"查询成功",pageInfo);
    }

    /**
     * id查询
     * @param id 查询对象的id
     * @return Result对象
     */
    @GetMapping("/{id}")
    public Result<Activity> findById(@PathVariable Integer id) {
        Activity activity = activityService.findById(id);
        return new Result<>(true, StatusCode.OK, "查询成功", activity);
    }

    /**
     * 添加
     * @param activity 对象
     * @return Result对象
     */
    @PostMapping
    public Result add(Activity activity) {
        activityService.add(activity);
        return new Result(true, StatusCode.OK, "添加成功");
    }

    /**
     * 修改
     * @param id 修改对象的id
     * @param activity 修改项
     * @return Result对象
     */
    @PutMapping("/{id}")
    public Result update(@PathVariable Integer id, Activity activity) {
        activity.setId(id);
        activityService.update(activity);
        return new Result(true, StatusCode.OK, "修改成功");
    }

    /**
     * 删除
     * @param id 删除对象的id
     * @return Result对象
     */
    @DeleteMapping("/{id}")
    public Result deleteById(@PathVariable Integer id){
        activityService.delete(id);
        return new Result(true, StatusCode.OK, "删除成功");
    }
}
