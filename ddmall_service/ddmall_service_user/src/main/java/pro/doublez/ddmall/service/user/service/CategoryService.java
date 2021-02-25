package pro.doublez.ddmall.service.user.service;

import com.github.pagehelper.PageInfo;
import pro.doublez.ddmall.user.pojo.Category;

import java.util.List;

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
