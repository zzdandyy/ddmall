package pro.doublez.ddmall.service.order.service.impl;

import pro.doublez.ddmall.order.pojo.OrderConfig;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Service;
import pro.doublez.ddmall.service.order.dao.OrderConfigMapper;
import pro.doublez.ddmall.service.order.service.OrderConfigService;

import javax.annotation.Resource;
import java.util.List;

@Service
public class OrderConfigServiceImpl implements OrderConfigService {

    @Resource
    private OrderConfigMapper orderConfigMapper;

    @Override
    public List<OrderConfig> findList(OrderConfig orderConfig) {
        return orderConfigMapper.findList(orderConfig);
    }

    @Override
    public PageInfo<OrderConfig> findPage(OrderConfig orderConfig,int page,int size) {
        PageHelper.startPage(page, size);
        List<OrderConfig> all = orderConfigMapper.findList(orderConfig);
        return new PageInfo<>(all);
    }

    @Override
    public OrderConfig findById(Integer id) {
        return orderConfigMapper.findById(id);
    }

    @Override
    public void add(OrderConfig orderConfig) {
        orderConfigMapper.add(orderConfig);
    }

    @Override
    public void update(OrderConfig orderConfig) {
        orderConfigMapper.update(orderConfig);
    }

    @Override
    public void delete(Integer id) {
        orderConfigMapper.delete(id);
    }
}
