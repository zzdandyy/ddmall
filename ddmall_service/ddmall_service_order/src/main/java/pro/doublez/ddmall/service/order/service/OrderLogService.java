package pro.doublez.ddmall.service.order.service;

import pro.doublez.ddmall.order.pojo.OrderLog;
import com.github.pagehelper.PageInfo;

import java.util.List;

public interface OrderLogService {

    // 条件查询
    List<OrderLog> findList(OrderLog orderLog);

    // 分页条件查询
    PageInfo<OrderLog> findPage(OrderLog orderLog, int page, int size);

    OrderLog findById(Integer id);

    void add(OrderLog orderLog);

    void update(OrderLog orderLog);

    void delete(Integer id);

}
