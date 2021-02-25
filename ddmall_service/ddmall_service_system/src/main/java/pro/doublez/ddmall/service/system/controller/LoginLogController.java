package pro.doublez.ddmall.service.system.controller;

import com.github.pagehelper.PageInfo;
import org.springframework.web.bind.annotation.*;
import pro.doublez.ddmall.common.pojo.Result;
import pro.doublez.ddmall.common.pojo.StatusCode;
import pro.doublez.ddmall.service.system.service.LoginLogService;
import pro.doublez.ddmall.system.pojo.LoginLog;

import javax.annotation.Resource;
import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/loginLog")
public class LoginLogController {

    @Resource
    private LoginLogService loginLogService;

    /**
     * 列表查询
     * @param loginLog 查询条件
     * @return Result对象
     */
    @GetMapping
    public Result<List<LoginLog>> findList(LoginLog loginLog) {
        List<LoginLog> loginLogList = loginLogService.findList(loginLog);
        return new Result<>(true, StatusCode.OK, "查询成功", loginLogList);
    }

    /**
     * 分页查询
     * @param page 页码
     * @param size 每页显示条数
     * @param loginLog 查询条件
     * @return Result对象
     */
    @GetMapping("/{page}/{size}")
    public Result findPage(@PathVariable int page,@PathVariable int size,LoginLog loginLog){
        PageInfo<LoginLog> pageInfo = loginLogService.findPage(loginLog, page, size);
        return new Result(true,StatusCode.OK,"查询成功",pageInfo);
    }

    /**
     * id查询
     * @param id 查询对象的id
     * @return Result对象
     */
    @GetMapping("/{id}")
    public Result<LoginLog> findById(@PathVariable Integer id) {
        LoginLog loginLog = loginLogService.findById(id);
        return new Result<>(true, StatusCode.OK, "查询成功", loginLog);
    }

    /**
     * 添加
     * @param loginLog 对象
     * @return Result对象
     */
    @PostMapping
    public Result add(LoginLog loginLog) {
        loginLogService.add(loginLog);
        return new Result(true, StatusCode.OK, "添加成功");
    }

    /**
     * 修改
     * @param id 修改对象的id
     * @param loginLog 修改项
     * @return Result对象
     */
    @PutMapping("/{id}")
    public Result update(@PathVariable Integer id, LoginLog loginLog) {
        loginLog.setId(id);
        loginLogService.update(loginLog);
        return new Result(true, StatusCode.OK, "修改成功");
    }

    /**
     * 删除
     * @param id 删除对象的id
     * @return Result对象
     */
    @DeleteMapping("/{id}")
    public Result deleteById(@PathVariable Integer id){
        loginLogService.delete(id);
        return new Result(true, StatusCode.OK, "删除成功");
    }
}
