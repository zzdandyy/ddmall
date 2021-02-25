package pro.doublez.ddmall.service.order.dao;

import pro.doublez.ddmall.order.pojo.OrderLog;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;


@Mapper
public interface OrderLogMapper {

    List<OrderLog> findList(OrderLog orderLog);

    OrderLog findById(Integer id);

    void add(OrderLog orderLog);

    void update(OrderLog orderLog);

    void delete(Integer id);

}

