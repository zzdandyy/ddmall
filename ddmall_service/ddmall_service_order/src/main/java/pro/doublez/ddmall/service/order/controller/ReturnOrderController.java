package pro.doublez.ddmall.service.order.controller;

import pro.doublez.ddmall.order.pojo.ReturnOrder;
import com.github.pagehelper.PageInfo;
import org.springframework.web.bind.annotation.*;
import pro.doublez.ddmall.common.pojo.Result;
import pro.doublez.ddmall.common.pojo.StatusCode;
import pro.doublez.ddmall.service.order.service.ReturnOrderService;

import javax.annotation.Resource;
import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/returnOrder")
public class ReturnOrderController {

    @Resource
    private ReturnOrderService returnOrderService;

    /**
     * 列表查询
     * @param returnOrder 查询条件
     * @return Result对象
     */
    @GetMapping
    public Result<List<ReturnOrder>> findList(ReturnOrder returnOrder) {
        List<ReturnOrder> returnOrderList = returnOrderService.findList(returnOrder);
        return new Result<>(true, StatusCode.OK, "查询成功", returnOrderList);
    }

    /**
     * 分页查询
     * @param page 页码
     * @param size 每页显示条数
     * @param returnOrder 查询条件
     * @return Result对象
     */
    @GetMapping("/{page}/{size}")
    public Result findPage(@PathVariable int page,@PathVariable int size,ReturnOrder returnOrder){
        PageInfo<ReturnOrder> pageInfo = returnOrderService.findPage(returnOrder, page, size);
        return new Result(true,StatusCode.OK,"查询成功",pageInfo);
    }

    /**
     * id查询
     * @param id 查询对象的id
     * @return Result对象
     */
    @GetMapping("/{id}")
    public Result<ReturnOrder> findById(@PathVariable Integer id) {
        ReturnOrder returnOrder = returnOrderService.findById(id);
        return new Result<>(true, StatusCode.OK, "查询成功", returnOrder);
    }

    /**
     * 添加
     * @param returnOrder 对象
     * @return Result对象
     */
    @PostMapping
    public Result add(ReturnOrder returnOrder) {
        returnOrderService.add(returnOrder);
        return new Result(true, StatusCode.OK, "添加成功");
    }

    /**
     * 修改
     * @param id 修改对象的id
     * @param returnOrder 修改项
     * @return Result对象
     */
    @PutMapping("/{id}")
    public Result update(@PathVariable String id, ReturnOrder returnOrder) {
        returnOrder.setId(id);
        returnOrderService.update(returnOrder);
        return new Result(true, StatusCode.OK, "修改成功");
    }

    /**
     * 删除
     * @param id 删除对象的id
     * @return Result对象
     */
    @DeleteMapping("/{id}")
    public Result deleteById(@PathVariable Integer id){
        returnOrderService.delete(id);
        return new Result(true, StatusCode.OK, "删除成功");
    }
}
