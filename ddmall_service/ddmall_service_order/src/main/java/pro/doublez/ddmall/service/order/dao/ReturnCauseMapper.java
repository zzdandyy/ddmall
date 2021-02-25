package pro.doublez.ddmall.service.order.dao;

import pro.doublez.ddmall.order.pojo.ReturnCause;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;


@Mapper
public interface ReturnCauseMapper {

    List<ReturnCause> findList(ReturnCause returnCause);

    ReturnCause findById(Integer id);

    void add(ReturnCause returnCause);

    void update(ReturnCause returnCause);

    void delete(Integer id);

}

