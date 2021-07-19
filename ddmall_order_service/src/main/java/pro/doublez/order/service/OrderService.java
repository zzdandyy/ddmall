package pro.doublez.order.service;

import org.apache.ibatis.annotations.Select;
import pro.doublez.order.pojo.Order;

/**
 * @author doublez
 * @version 1.0
 * @date 2021/7/13 12:36
 */
public interface OrderService {

    //查看所有已支付订单
    Order[] findAllOrderIsPay();

    //查看本人所有订单
    Order[] findUserAllOrder(int uid);

    //查看本人所有没有取消的订单
    Order[] findUserAllOrderNoCancel(int uid);

    //查看本人未支付订单
    Order[] findUserAllOrderNoCancelNoPay(int uid);

    //查看本人已支付订单
    Order[] findUserAllOrderNoCancelPay(int uid);

    //根据订单id查询订单
    Order findOrderById(long id);

    //查询个人秒杀订单的数量
    Integer findSelfSeckillNum(int uid);

    //查询订单状态
    Integer findStatusById(long id);

    //查询订单类型
    Integer findFormById(long id);

    //生成订单
    Integer addOrder(int uid, long gid, int count, double price,int isSeckill);

    //取消订单
    Integer cancelOrder(long id);

    //支付并提交
    Integer payOrder(long id);

}
