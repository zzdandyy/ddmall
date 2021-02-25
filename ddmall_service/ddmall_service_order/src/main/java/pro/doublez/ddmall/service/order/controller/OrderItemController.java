package pro.doublez.ddmall.service.order.controller;

import pro.doublez.ddmall.order.pojo.OrderItem;
import com.github.pagehelper.PageInfo;
import org.springframework.web.bind.annotation.*;
import pro.doublez.ddmall.common.pojo.Result;
import pro.doublez.ddmall.common.pojo.StatusCode;
import pro.doublez.ddmall.service.order.service.OrderItemService;

import javax.annotation.Resource;
import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/orderItem")
public class OrderItemController {

    @Resource
    private OrderItemService orderItemService;

    /**
     * 列表查询
     * @param orderItem 查询条件
     * @return Result对象
     */
    @GetMapping
    public Result<List<OrderItem>> findList(OrderItem orderItem) {
        List<OrderItem> orderItemList = orderItemService.findList(orderItem);
        return new Result<>(true, StatusCode.OK, "查询成功", orderItemList);
    }

    /**
     * 分页查询
     * @param page 页码
     * @param size 每页显示条数
     * @param orderItem 查询条件
     * @return Result对象
     */
    @GetMapping("/{page}/{size}")
    public Result findPage(@PathVariable int page,@PathVariable int size,OrderItem orderItem){
        PageInfo<OrderItem> pageInfo = orderItemService.findPage(orderItem, page, size);
        return new Result(true,StatusCode.OK,"查询成功",pageInfo);
    }

    /**
     * id查询
     * @param id 查询对象的id
     * @return Result对象
     */
    @GetMapping("/{id}")
    public Result<OrderItem> findById(@PathVariable Integer id) {
        OrderItem orderItem = orderItemService.findById(id);
        return new Result<>(true, StatusCode.OK, "查询成功", orderItem);
    }

    /**
     * 添加
     * @param orderItem 对象
     * @return Result对象
     */
    @PostMapping
    public Result add(OrderItem orderItem) {
        orderItemService.add(orderItem);
        return new Result(true, StatusCode.OK, "添加成功");
    }

    /**
     * 修改
     * @param id 修改对象的id
     * @param orderItem 修改项
     * @return Result对象
     */
    @PutMapping("/{id}")
    public Result update(@PathVariable String id, OrderItem orderItem) {
        orderItem.setId(id);
        orderItemService.update(orderItem);
        return new Result(true, StatusCode.OK, "修改成功");
    }

    /**
     * 删除
     * @param id 删除对象的id
     * @return Result对象
     */
    @DeleteMapping("/{id}")
    public Result deleteById(@PathVariable Integer id){
        orderItemService.delete(id);
        return new Result(true, StatusCode.OK, "删除成功");
    }
}
