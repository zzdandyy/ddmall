package pro.doublez.ddmall.service.user.dao;

import org.apache.ibatis.annotations.Mapper;
import pro.doublez.ddmall.user.pojo.PointLog;

import java.util.List;


@Mapper
public interface PointLogMapper {

    List<PointLog> findList(PointLog pointLog);

    PointLog findById(Integer id);

    void add(PointLog pointLog);

    void update(PointLog pointLog);

    void delete(Integer id);

}

