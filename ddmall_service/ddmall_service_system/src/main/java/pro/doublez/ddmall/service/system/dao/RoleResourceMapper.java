package pro.doublez.ddmall.service.system.dao;

import org.apache.ibatis.annotations.Mapper;
import pro.doublez.ddmall.system.pojo.RoleResource;

import java.util.List;


@Mapper
public interface RoleResourceMapper {

    List<RoleResource> findList(RoleResource roleResource);

    RoleResource findById(Integer id);

    void add(RoleResource roleResource);

    void update(RoleResource roleResource);

    void delete(Integer id);

}

