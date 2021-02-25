package pro.doublez.ddmall.service.system.dao;

import org.apache.ibatis.annotations.Mapper;
import pro.doublez.ddmall.system.pojo.Role;

import java.util.List;


@Mapper
public interface RoleMapper {

    List<Role> findList(Role role);

    Role findById(Integer id);

    void add(Role role);

    void update(Role role);

    void delete(Integer id);

}

