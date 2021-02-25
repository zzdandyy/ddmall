package pro.doublez.ddmall.service.system.dao;

import org.apache.ibatis.annotations.Mapper;
import pro.doublez.ddmall.system.pojo.ResourceMenu;

import java.util.List;


@Mapper
public interface ResourceMenuMapper {

    List<ResourceMenu> findList(ResourceMenu resourceMenu);

    ResourceMenu findById(Integer id);

    void add(ResourceMenu resourceMenu);

    void update(ResourceMenu resourceMenu);

    void delete(Integer id);

}

