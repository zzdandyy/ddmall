package pro.doublez.ddmall.service.system.dao;

import org.apache.ibatis.annotations.Mapper;
import pro.doublez.ddmall.system.pojo.AdminRole;

import java.util.List;


@Mapper
public interface AdminRoleMapper {

    List<AdminRole> findList(AdminRole adminRole);

    AdminRole findById(Integer id);

    void add(AdminRole adminRole);

    void update(AdminRole adminRole);

    void delete(Integer id);

}

