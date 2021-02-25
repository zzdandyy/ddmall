package pro.doublez.ddmall.service.order.service;

import pro.doublez.ddmall.order.pojo.OrderConfig;
import com.github.pagehelper.PageInfo;

import java.util.List;

public interface OrderConfigService {

    // 条件查询
    List<OrderConfig> findList(OrderConfig orderConfig);

    // 分页条件查询
    PageInfo<OrderConfig> findPage(OrderConfig orderConfig, int page, int size);

    OrderConfig findById(Integer id);

    void add(OrderConfig orderConfig);

    void update(OrderConfig orderConfig);

    void delete(Integer id);

}
