package pro.doublez.ddmall.service.order.dao;

import pro.doublez.ddmall.order.pojo.OrderConfig;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;


@Mapper
public interface OrderConfigMapper {

    List<OrderConfig> findList(OrderConfig orderConfig);

    OrderConfig findById(Integer id);

    void add(OrderConfig orderConfig);

    void update(OrderConfig orderConfig);

    void delete(Integer id);

}

