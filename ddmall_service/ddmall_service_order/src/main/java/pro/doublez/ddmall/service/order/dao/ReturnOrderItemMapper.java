package pro.doublez.ddmall.service.order.dao;

import pro.doublez.ddmall.order.pojo.ReturnOrderItem;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;


@Mapper
public interface ReturnOrderItemMapper {

    List<ReturnOrderItem> findList(ReturnOrderItem returnOrderItem);

    ReturnOrderItem findById(Integer id);

    void add(ReturnOrderItem returnOrderItem);

    void update(ReturnOrderItem returnOrderItem);

    void delete(Integer id);

}

