package pro.doublez.ddmall.service.order.service;

import pro.doublez.ddmall.order.pojo.Order;
import com.github.pagehelper.PageInfo;

import java.util.List;

public interface OrderService {

    // 条件查询
    List<Order> findList(Order order);

    // 分页条件查询
    PageInfo<Order> findPage(Order order, int page, int size);

    Order findById(Integer id);

    void add(Order order);

    void update(Order order);

    void delete(Integer id);

}
