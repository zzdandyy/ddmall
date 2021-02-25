package pro.doublez.ddmall.service.config.service;

import com.github.pagehelper.PageInfo;
import pro.doublez.ddmall.config.pojo.Areas;

import java.util.List;

public interface AreasService {

    // 条件查询
    List<Areas> findList(Areas areas);

    // 分页条件查询
    PageInfo<Areas> findPage(Areas areas, int page, int size);

    Areas findById(Integer id);

    void add(Areas areas);

    void update(Areas areas);

    void delete(Integer id);

}
