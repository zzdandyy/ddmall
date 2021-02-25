package pro.doublez.ddmall.service.system.service;

import com.github.pagehelper.PageInfo;
import pro.doublez.ddmall.system.pojo.ResourceMenu;

import java.util.List;

public interface ResourceMenuService {

    // 条件查询
    List<ResourceMenu> findList(ResourceMenu resourceMenu);

    // 分页条件查询
    PageInfo<ResourceMenu> findPage(ResourceMenu resourceMenu, int page, int size);

    ResourceMenu findById(Integer id);

    void add(ResourceMenu resourceMenu);

    void update(ResourceMenu resourceMenu);

    void delete(Integer id);

}
