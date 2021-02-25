package pro.doublez.ddmall.service.user.dao;

import org.apache.ibatis.annotations.Mapper;
import pro.doublez.ddmall.user.pojo.Areas;

import java.util.List;


@Mapper
public interface AreasMapper {

    List<Areas> findList(Areas areas);

    Areas findById(Integer id);

    void add(Areas areas);

    void update(Areas areas);

    void delete(Integer id);

}

