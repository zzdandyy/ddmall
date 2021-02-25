package pro.doublez.ddmall.service.config.service;

import com.github.pagehelper.PageInfo;
import pro.doublez.ddmall.config.pojo.Provinces;

import java.util.List;

public interface ProvincesService {

    // 条件查询
    List<Provinces> findList(Provinces provinces);

    // 分页条件查询
    PageInfo<Provinces> findPage(Provinces provinces, int page, int size);

    Provinces findById(Integer id);

    void add(Provinces provinces);

    void update(Provinces provinces);

    void delete(Integer id);

}
