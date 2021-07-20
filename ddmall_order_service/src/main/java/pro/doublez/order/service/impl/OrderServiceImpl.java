package pro.doublez.order.service.impl;

import org.springframework.stereotype.Service;

import pro.doublez.order.dao.OrderDao;
import pro.doublez.order.pojo.Order;
import pro.doublez.order.service.OrderService;
import pro.doublez.order.utils.IdWorker;


/**
 * @author doublez
 * @version 1.0
 * @date 2021/7/13 12:36
 */
@Service
public class OrderServiceImpl implements OrderService {

    private final OrderDao orderDao;


    public OrderServiceImpl(OrderDao orderDao) {
        this.orderDao = orderDao;
    }

    @Override
    public Order[] findAllOrderIsPay() {
        return orderDao.findAllOrderIsPay();
    }

    @Override
    public Order[] findUserAllOrder(int uid) {
        return orderDao.findUserAllOrder(uid);
    }

    @Override
    public Order[] findUserAllOrderNoCancel(int uid) {
        return orderDao.findUserAllOrderNoCancel(uid);
    }

    @Override
    public Order[] findUserAllOrderNoCancelNoPay(int uid) {
        return orderDao.findUserAllOrderNoCancelNoPay(uid);
    }

    @Override
    public Order[] findUserAllOrderNoCancelPay(int uid) {
        return orderDao.findUserAllOrderNoCancelPay(uid);
    }

    @Override
    public Order findOrderById(long id) {
        return orderDao.findOrderById(id);
    }

    @Override
    public Integer findSelfSeckillNum(int uid) {
        return orderDao.findSelfSeckillNum(uid);
    }

    @Override
    public Integer findStatusById(long id) {
        return orderDao.findStatusById(id);
    }

    @Override
    public Integer findFormById(long id) {
        return orderDao.findFormById(id);
    }

    @Override
    public Order[] findAllPayOrder() {
        return orderDao.findAllPayOrder();
    }

    @Override
    public Integer addOrder(int uid, long gid, int count, double price, int isSeckill) {
        double totalPrice = price * count;
        Order order = new Order();
        order.setId(new IdWorker().nextId()).setUid(uid).setGid(gid)
                .setCount(count).setTotalPrice(totalPrice).setForm(isSeckill);
        return orderDao.addOrder(order);
    }

    @Override
    public Integer cancelOrder(long id) {
        return orderDao.cancelOrder(id);
    }

    @Override
    public Integer payOrder(long id) {
        Order order = orderDao.findOrderById(id);
        int uid = order.getUid();
        if (order.getStatus() != 0) {
            return 0;
        }
        return orderDao.payOrder(id);
    }
}
