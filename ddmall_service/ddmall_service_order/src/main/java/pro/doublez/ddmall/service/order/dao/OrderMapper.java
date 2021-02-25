package pro.doublez.ddmall.service.order.dao;

import pro.doublez.ddmall.order.pojo.Order;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;


@Mapper
public interface OrderMapper {

    List<Order> findList(Order order);

    Order findById(Integer id);

    void add(Order order);

    void update(Order order);

    void delete(Integer id);

}

