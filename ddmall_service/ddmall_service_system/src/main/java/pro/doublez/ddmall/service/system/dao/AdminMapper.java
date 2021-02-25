package pro.doublez.ddmall.service.system.dao;

import org.apache.ibatis.annotations.Mapper;
import pro.doublez.ddmall.system.pojo.Admin;

import java.util.List;


@Mapper
public interface AdminMapper {

    List<Admin> findList(Admin admin);

    Admin findById(Integer id);

    void add(Admin admin);

    void update(Admin admin);

    void delete(Integer id);

}

