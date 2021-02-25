package pro.doublez.ddmall.service.system.service;

import com.github.pagehelper.PageInfo;
import pro.doublez.ddmall.system.pojo.AdminRole;

import java.util.List;

public interface AdminRoleService {

    // 条件查询
    List<AdminRole> findList(AdminRole adminRole);

    // 分页条件查询
    PageInfo<AdminRole> findPage(AdminRole adminRole, int page, int size);

    AdminRole findById(Integer id);

    void add(AdminRole adminRole);

    void update(AdminRole adminRole);

    void delete(Integer id);

}
