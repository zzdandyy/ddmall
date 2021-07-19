package pro.doublez.order.controller;


import org.springframework.web.bind.annotation.*;
import pro.doublez.order.pojo.Order;
import pro.doublez.order.service.OrderService;

/**
 * @author doublez
 * @version 1.0
 * @date 2021/7/11 22:21
 */
@CrossOrigin
@RestController
@RequestMapping("/order")
public class OrderController {

    private final OrderService orderService;

    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    //查询订单
    @GetMapping("/find_order/{id}")
    public Order findOrderById(@PathVariable long id) {
        return orderService.findOrderById(id);
    }

    //查询订单状态
    @GetMapping("/find_order_status/{id}")
    public Integer findStatusById(@PathVariable long id) {
        return orderService.findStatusById(id);
    }

    //查询订单类型
    @GetMapping("/find_order_form/{id}")
    public Integer findFormById(@PathVariable long id) {
        return orderService.findFormById(id);
    }

    //直接生成订单
    @PutMapping("/add/{uid}/{gid}/{count}/{price}/{isSeckill}")
    public Integer addOrder(@PathVariable int uid, @PathVariable long gid, @PathVariable int count,
                            @PathVariable double price, @PathVariable int isSeckill) {
        return orderService.addOrder(uid, gid, count, price, isSeckill);
    }

    //取消订单
    @PostMapping("/cancel/{oid}")
    public Integer cancelOrder(@PathVariable long oid) {
        return orderService.cancelOrder(oid);
    }

    //支付并提交订单
    @PostMapping("/pay/{oid}")
    public Integer payOrder(@PathVariable long oid) {
        return orderService.payOrder(oid);
    }

    //查看个人未支付的订单
    @GetMapping("/{uid}/find_all_no_pay_order")
    public Order[] findAllNoPayOrder(@PathVariable int uid) {
        return orderService.findUserAllOrderNoCancelNoPay(uid);
    }

    //查看个人已支付的订单
    @GetMapping("/{uid}/find_all_pay_order")
    public Order[] findAllPayOrder(@PathVariable int uid) {
        return orderService.findUserAllOrderNoCancelPay(uid);
    }

}
