package pro.doublez.ddmall.service.user.controller;

import com.github.pagehelper.PageInfo;
import org.springframework.web.bind.annotation.*;
import pro.doublez.ddmall.common.pojo.Result;
import pro.doublez.ddmall.common.pojo.StatusCode;
import pro.doublez.ddmall.service.user.service.PointLogService;
import pro.doublez.ddmall.user.pojo.PointLog;

import javax.annotation.Resource;
import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/pointLog")
public class PointLogController {

    @Resource
    private PointLogService pointLogService;

    /**
     * 列表查询
     * @param pointLog 查询条件
     * @return Result对象
     */
    @GetMapping
    public Result<List<PointLog>> findList(PointLog pointLog) {
        List<PointLog> pointLogList = pointLogService.findList(pointLog);
        return new Result<>(true, StatusCode.OK, "查询成功", pointLogList);
    }

    /**
     * 分页查询
     * @param page 页码
     * @param size 每页显示条数
     * @param pointLog 查询条件
     * @return Result对象
     */
    @GetMapping("/{page}/{size}")
    public Result findPage(@PathVariable int page,@PathVariable int size,PointLog pointLog){
        PageInfo<PointLog> pageInfo = pointLogService.findPage(pointLog, page, size);
        return new Result(true,StatusCode.OK,"查询成功",pageInfo);
    }

//    /**
//     * id查询
//     * @param id 查询对象的id
//     * @return Result对象
//     */
//    @GetMapping("/{id}")
//    public Result<PointLog> findById(@PathVariable Integer id) {
//        PointLog pointLog = pointLogService.findById(id);
//        return new Result<>(true, StatusCode.OK, "查询成功", pointLog);
//    }
//
    /**
     * 添加
     * @param pointLog 对象
     * @return Result对象
     */
    @PostMapping
    public Result add(PointLog pointLog) {
        pointLogService.add(pointLog);
        return new Result(true, StatusCode.OK, "添加成功");
    }
//
//    /**
//     * 修改
//     * @param id 修改对象的id
//     * @param pointLog 修改项
//     * @return Result对象
//     */
//    @PutMapping("/{id}")
//    public Result update(@PathVariable Integer id, PointLog pointLog) {
//        pointLog.setId(id);
//        pointLogService.update(pointLog);
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
//        pointLogService.delete(id);
//        return new Result(true, StatusCode.OK, "删除成功");
//    }
}
