package pro.doublez.ddmall.service.goods.dao;


import org.apache.ibatis.annotations.Mapper;
import pro.doublez.ddmall.goods.pojo.Log;

import java.util.List;

@Mapper
public interface LogMapper {

    // 条件查询
    List<Log> findList(Log log);

    Log findById(Long id);

    void add(Log log);

    void update(Log log);

    void delete(Long id);

}
