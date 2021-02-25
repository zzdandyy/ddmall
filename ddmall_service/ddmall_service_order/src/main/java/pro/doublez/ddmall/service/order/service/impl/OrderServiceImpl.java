package pro.doublez.ddmall.service.order.service.impl;

import pro.doublez.ddmall.order.pojo.Order;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Service;
import pro.doublez.ddmall.service.order.dao.OrderMapper;
import pro.doublez.ddmall.service.order.service.OrderService;

import javax.annotation.Resource;
import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {

    @Resource
    private OrderMapper orderMapper;

    @Override
    public List<Order> findList(Order order) {
        return orderMapper.findList(order);
    }

    @Override
    public PageInfo<Order> findPage(Order order,int page,int size) {
        PageHelper.startPage(page, size);
        List<Order> all = orderMapper.findList(order);
        return new PageInfo<>(all);
    }

    @Override
    public Order findById(Integer id) {
        return orderMapper.findById(id);
    }

    @Override
    public void add(Order order) {
        orderMapper.add(order);
    }

    @Override
    public void update(Order order) {
        orderMapper.update(order);
    }

    @Override
    public void delete(Integer id) {
        orderMapper.delete(id);
    }
}
