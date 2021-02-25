package pro.doublez.ddmall.service.system.service;

import com.github.pagehelper.PageInfo;
import pro.doublez.ddmall.system.pojo.RoleResource;

import java.util.List;

public interface RoleResourceService {

    // 条件查询
    List<RoleResource> findList(RoleResource roleResource);

    // 分页条件查询
    PageInfo<RoleResource> findPage(RoleResource roleResource, int page, int size);

    RoleResource findById(Integer id);

    void add(RoleResource roleResource);

    void update(RoleResource roleResource);

    void delete(Integer id);

}
