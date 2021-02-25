package pro.doublez.ddmall.service.config.dao;

import org.apache.ibatis.annotations.Mapper;
import pro.doublez.ddmall.config.pojo.Areas;

import java.util.List;


@Mapper
public interface AreasMapper {

    List<Areas> findList(Areas areas);

    Areas findById(Integer id);

    void add(Areas areas);

    void update(Areas areas);

    void delete(Integer id);

}

