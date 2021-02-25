package pro.doublez.ddmall.service.order.service;

import pro.doublez.ddmall.order.pojo.OrderItem;
import com.github.pagehelper.PageInfo;

import java.util.List;

public interface OrderItemService {

    // 条件查询
    List<OrderItem> findList(OrderItem orderItem);

    // 分页条件查询
    PageInfo<OrderItem> findPage(OrderItem orderItem, int page, int size);

    OrderItem findById(Integer id);

    void add(OrderItem orderItem);

    void update(OrderItem orderItem);

    void delete(Integer id);

}
