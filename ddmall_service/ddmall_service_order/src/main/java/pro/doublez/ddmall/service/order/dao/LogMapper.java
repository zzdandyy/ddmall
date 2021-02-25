package pro.doublez.ddmall.service.order.dao;

import pro.doublez.ddmall.order.pojo.Log;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;


@Mapper
public interface LogMapper {

    List<Log> findList(Log log);

    Log findById(Integer id);

    void add(Log log);

    void update(Log log);

    void delete(Integer id);

}

