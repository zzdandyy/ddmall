package pro.doublez.ddmall.service.goods.service;

import pro.doublez.ddmall.goods.pojo.Brand;
import com.github.pagehelper.PageInfo;

import java.util.List;

public interface BrandService {

    // 条件查询
    List<Brand> findList(Brand brand);

    // 分页条件查询
    PageInfo<Brand> findPage(Brand brand, int page, int size);

    Brand findById(Integer id);

    void add(Brand brand);

    void update(Brand brand);

    void delete(Integer id);

}
