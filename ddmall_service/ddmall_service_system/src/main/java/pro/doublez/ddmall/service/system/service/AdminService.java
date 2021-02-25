package pro.doublez.ddmall.service.system.service;

import com.github.pagehelper.PageInfo;
import pro.doublez.ddmall.system.pojo.Admin;

import java.util.List;

public interface AdminService {

    // 条件查询
    List<Admin> findList(Admin admin);

    // 分页条件查询
    PageInfo<Admin> findPage(Admin admin, int page, int size);

    Admin findById(Integer id);

    void add(Admin admin);

    void update(Admin admin);

    void delete(Integer id);

}
