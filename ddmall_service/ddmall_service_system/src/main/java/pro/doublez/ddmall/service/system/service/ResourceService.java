package pro.doublez.ddmall.service.system.service;

import com.github.pagehelper.PageInfo;
import pro.doublez.ddmall.system.pojo.Resource;

import java.util.List;

public interface ResourceService {

    // 条件查询
    List<Resource> findList(Resource resource);

    // 分页条件查询
    PageInfo<Resource> findPage(Resource resource, int page, int size);

    Resource findById(Integer id);

    void add(Resource resource);

    void update(Resource resource);

    void delete(Integer id);

}
