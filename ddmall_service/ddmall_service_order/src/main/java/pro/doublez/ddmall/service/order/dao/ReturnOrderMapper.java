package pro.doublez.ddmall.service.order.dao;

import pro.doublez.ddmall.order.pojo.ReturnOrder;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;


@Mapper
public interface ReturnOrderMapper {

    List<ReturnOrder> findList(ReturnOrder returnOrder);

    ReturnOrder findById(Integer id);

    void add(ReturnOrder returnOrder);

    void update(ReturnOrder returnOrder);

    void delete(Integer id);

}

