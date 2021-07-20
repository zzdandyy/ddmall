package pro.doublez.common.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import pro.doublez.ddmall_api.pojo.Order;


/**
 * @author doublez
 * @version 1.0
 * @date 2021/7/17 16:57
 */
@FeignClient("order")
public interface OrderFeign {
    //查询订单
    @GetMapping("/order/find_order/{id}")
    public Order findOrderById(@PathVariable long id);

    //查询订单状态
    @GetMapping("/order/find_order_status/{id}")
    public Integer findStatusById(@PathVariable long id);

    //查询订单类型
    @GetMapping("/order/find_order_form/{id}")
    public Integer findFormById(@PathVariable long id);

    //直接生成订单
    @PutMapping("/order/add/{uid}/{gid}/{count}/{price}/{isSeckill}")
    public Integer addOrder(@PathVariable int uid, @PathVariable long gid, @PathVariable int count,
                            @PathVariable double price, @PathVariable int isSeckill);

    //取消订单
    @PostMapping("/order/cancel/{oid}")
    public Integer cancelOrder(@PathVariable long oid);

    //支付并提交订单
    @PostMapping("/order/pay/{oid}")
    public Integer payOrder(@PathVariable long oid);

    //查看个人未支付的订单
    @GetMapping("/order/{uid}/find_all_no_pay_order")
    public Order[] findAllNoPayOrder(@PathVariable int uid);

    //查看个人已支付的订单
    @GetMapping("/order/{uid}/find_all_pay_order")
    public Order[] findAllPayOrder(@PathVariable int uid);

    //管理员查看所有已支付订单
    @GetMapping("/order/find_all_pay")
    public Order[] findAllPay();
}
