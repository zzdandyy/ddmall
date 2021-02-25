package pro.doublez.ddmall.service.goods.service;

import com.github.pagehelper.PageInfo;
import pro.doublez.ddmall.goods.pojo.CategoryBrand;

import java.util.List;

public interface CategoryBrandService {

    // 条件查询
    List<CategoryBrand> findList(CategoryBrand categoryBrand);

    // 分页条件查询
    PageInfo<CategoryBrand> findPage(CategoryBrand categoryBrand, int page, int size);

    CategoryBrand findById(Integer id);

    void add(CategoryBrand categoryBrand);

    void update(CategoryBrand categoryBrand);

    void delete(Integer id);

}
