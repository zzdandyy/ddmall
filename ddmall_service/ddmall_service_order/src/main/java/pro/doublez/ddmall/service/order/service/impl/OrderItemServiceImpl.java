package pro.doublez.ddmall.service.order.service.impl;

import pro.doublez.ddmall.order.pojo.OrderItem;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Service;
import pro.doublez.ddmall.service.order.dao.OrderItemMapper;
import pro.doublez.ddmall.service.order.service.OrderItemService;

import javax.annotation.Resource;
import java.util.List;

@Service
public class OrderItemServiceImpl implements OrderItemService {

    @Resource
    private OrderItemMapper orderItemMapper;

    @Override
    public List<OrderItem> findList(OrderItem orderItem) {
        return orderItemMapper.findList(orderItem);
    }

    @Override
    public PageInfo<OrderItem> findPage(OrderItem orderItem,int page,int size) {
        PageHelper.startPage(page, size);
        List<OrderItem> all = orderItemMapper.findList(orderItem);
        return new PageInfo<>(all);
    }

    @Override
    public OrderItem findById(Integer id) {
        return orderItemMapper.findById(id);
    }

    @Override
    public void add(OrderItem orderItem) {
        orderItemMapper.add(orderItem);
    }

    @Override
    public void update(OrderItem orderItem) {
        orderItemMapper.update(orderItem);
    }

    @Override
    public void delete(Integer id) {
        orderItemMapper.delete(id);
    }
}
