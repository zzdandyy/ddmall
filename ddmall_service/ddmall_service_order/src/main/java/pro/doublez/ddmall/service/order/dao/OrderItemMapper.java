package pro.doublez.ddmall.service.order.dao;

import pro.doublez.ddmall.order.pojo.OrderItem;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;


@Mapper
public interface OrderItemMapper {

    List<OrderItem> findList(OrderItem orderItem);

    OrderItem findById(Integer id);

    void add(OrderItem orderItem);

    void update(OrderItem orderItem);

    void delete(Integer id);

}

