package pro.doublez.ddmall.service.system.service;

import com.github.pagehelper.PageInfo;
import pro.doublez.ddmall.system.pojo.Role;

import java.util.List;

public interface RoleService {

    // 条件查询
    List<Role> findList(Role role);

    // 分页条件查询
    PageInfo<Role> findPage(Role role, int page, int size);

    Role findById(Integer id);

    void add(Role role);

    void update(Role role);

    void delete(Integer id);

}
