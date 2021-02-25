package pro.doublez.ddmall.service.order.controller;

import pro.doublez.ddmall.order.pojo.Order;
import com.github.pagehelper.PageInfo;
import org.springframework.web.bind.annotation.*;
import pro.doublez.ddmall.common.pojo.Result;
import pro.doublez.ddmall.common.pojo.StatusCode;
import pro.doublez.ddmall.service.order.service.OrderService;

import javax.annotation.Resource;
import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/order")
public class OrderController {

    @Resource
    private OrderService orderService;

    /**
     * 列表查询
     * @param order 查询条件
     * @return Result对象
     */
    @GetMapping
    public Result<List<Order>> findList(Order order) {
        List<Order> orderList = orderService.findList(order);
        return new Result<>(true, StatusCode.OK, "查询成功", orderList);
    }

    /**
     * 分页查询
     * @param page 页码
     * @param size 每页显示条数
     * @param order 查询条件
     * @return Result对象
     */
    @GetMapping("/{page}/{size}")
    public Result findPage(@PathVariable int page,@PathVariable int size,Order order){
        PageInfo<Order> pageInfo = orderService.findPage(order, page, size);
        return new Result(true,StatusCode.OK,"查询成功",pageInfo);
    }

    /**
     * id查询
     * @param id 查询对象的id
     * @return Result对象
     */
    @GetMapping("/{id}")
    public Result<Order> findById(@PathVariable Integer id) {
        Order order = orderService.findById(id);
        return new Result<>(true, StatusCode.OK, "查询成功", order);
    }

    /**
     * 添加
     * @param order 对象
     * @return Result对象
     */
    @PostMapping
    public Result add(Order order) {
        orderService.add(order);
        return new Result(true, StatusCode.OK, "添加成功");
    }

    /**
     * 修改
     * @param id 修改对象的id
     * @param order 修改项
     * @return Result对象
     */
    @PutMapping("/{id}")
    public Result update(@PathVariable String id, Order order) {
        order.setId(id);
        orderService.update(order);
        return new Result(true, StatusCode.OK, "修改成功");
    }

    /**
     * 删除
     * @param id 删除对象的id
     * @return Result对象
     */
    @DeleteMapping("/{id}")
    public Result deleteById(@PathVariable Integer id){
        orderService.delete(id);
        return new Result(true, StatusCode.OK, "删除成功");
    }
}
