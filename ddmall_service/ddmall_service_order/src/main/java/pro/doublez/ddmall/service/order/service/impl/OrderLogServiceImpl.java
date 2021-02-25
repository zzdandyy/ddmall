package pro.doublez.ddmall.service.order.service.impl;

import pro.doublez.ddmall.order.pojo.OrderLog;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Service;
import pro.doublez.ddmall.service.order.dao.OrderLogMapper;
import pro.doublez.ddmall.service.order.service.OrderLogService;

import javax.annotation.Resource;
import java.util.List;

@Service
public class OrderLogServiceImpl implements OrderLogService {

    @Resource
    private OrderLogMapper orderLogMapper;

    @Override
    public List<OrderLog> findList(OrderLog orderLog) {
        return orderLogMapper.findList(orderLog);
    }

    @Override
    public PageInfo<OrderLog> findPage(OrderLog orderLog,int page,int size) {
        PageHelper.startPage(page, size);
        List<OrderLog> all = orderLogMapper.findList(orderLog);
        return new PageInfo<>(all);
    }

    @Override
    public OrderLog findById(Integer id) {
        return orderLogMapper.findById(id);
    }

    @Override
    public void add(OrderLog orderLog) {
        orderLogMapper.add(orderLog);
    }

    @Override
    public void update(OrderLog orderLog) {
        orderLogMapper.update(orderLog);
    }

    @Override
    public void delete(Integer id) {
        orderLogMapper.delete(id);
    }
}
