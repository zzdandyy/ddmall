package pro.doublez.ddmall.service.goods.service;

import com.github.pagehelper.PageInfo;
import pro.doublez.ddmall.goods.pojo.Brand;
import pro.doublez.ddmall.goods.pojo.Category;

import java.util.List;
import java.util.Map;

public interface CategoryService {

    // 条件查询
    List<Category> findList(Category category);

    // 分页条件查询
    PageInfo<Category> findPage(Category category, int page, int size);

    Category findById(Integer id);

    void add(Category category);

    void update(Category category);

    void delete(Integer id);

}
