package pro.doublez.ddmall.service.user.dao;

import org.apache.ibatis.annotations.Mapper;
import pro.doublez.ddmall.user.pojo.Para;

import java.util.List;


@Mapper
public interface ParaMapper {

    List<Para> findList(Para para);

    Para findById(Integer id);

    void add(Para para);

    void update(Para para);

    void delete(Integer id);

}

