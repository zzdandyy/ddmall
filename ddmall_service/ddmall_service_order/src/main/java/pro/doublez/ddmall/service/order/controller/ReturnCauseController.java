package pro.doublez.ddmall.service.order.controller;

import pro.doublez.ddmall.order.pojo.ReturnCause;
import com.github.pagehelper.PageInfo;
import org.springframework.web.bind.annotation.*;
import pro.doublez.ddmall.common.pojo.Result;
import pro.doublez.ddmall.common.pojo.StatusCode;
import pro.doublez.ddmall.service.order.service.ReturnCauseService;

import javax.annotation.Resource;
import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/returnCause")
public class ReturnCauseController {

    @Resource
    private ReturnCauseService returnCauseService;

    /**
     * 列表查询
     * @param returnCause 查询条件
     * @return Result对象
     */
    @GetMapping
    public Result<List<ReturnCause>> findList(ReturnCause returnCause) {
        List<ReturnCause> returnCauseList = returnCauseService.findList(returnCause);
        return new Result<>(true, StatusCode.OK, "查询成功", returnCauseList);
    }

    /**
     * 分页查询
     * @param page 页码
     * @param size 每页显示条数
     * @param returnCause 查询条件
     * @return Result对象
     */
    @GetMapping("/{page}/{size}")
    public Result findPage(@PathVariable int page,@PathVariable int size,ReturnCause returnCause){
        PageInfo<ReturnCause> pageInfo = returnCauseService.findPage(returnCause, page, size);
        return new Result(true,StatusCode.OK,"查询成功",pageInfo);
    }

    /**
     * id查询
     * @param id 查询对象的id
     * @return Result对象
     */
    @GetMapping("/{id}")
    public Result<ReturnCause> findById(@PathVariable Integer id) {
        ReturnCause returnCause = returnCauseService.findById(id);
        return new Result<>(true, StatusCode.OK, "查询成功", returnCause);
    }

    /**
     * 添加
     * @param returnCause 对象
     * @return Result对象
     */
    @PostMapping
    public Result add(ReturnCause returnCause) {
        returnCauseService.add(returnCause);
        return new Result(true, StatusCode.OK, "添加成功");
    }

    /**
     * 修改
     * @param id 修改对象的id
     * @param returnCause 修改项
     * @return Result对象
     */
    @PutMapping("/{id}")
    public Result update(@PathVariable Integer id, ReturnCause returnCause) {
        returnCause.setId(id);
        returnCauseService.update(returnCause);
        return new Result(true, StatusCode.OK, "修改成功");
    }

    /**
     * 删除
     * @param id 删除对象的id
     * @return Result对象
     */
    @DeleteMapping("/{id}")
    public Result deleteById(@PathVariable Integer id){
        returnCauseService.delete(id);
        return new Result(true, StatusCode.OK, "删除成功");
    }
}
