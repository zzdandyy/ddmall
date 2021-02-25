package pro.doublez.ddmall.service.system.dao;

import org.apache.ibatis.annotations.Mapper;
import pro.doublez.ddmall.system.pojo.Resource;

import java.util.List;


@Mapper
public interface ResourceMapper {

    List<Resource> findList(Resource resource);

    Resource findById(Integer id);

    void add(Resource resource);

    void update(Resource resource);

    void delete(Integer id);

}

