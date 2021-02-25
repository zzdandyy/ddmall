package pro.doublez.ddmall.service.user.dao;

import org.apache.ibatis.annotations.Mapper;
import pro.doublez.ddmall.user.pojo.Category;

import java.util.List;


@Mapper
public interface CategoryMapper {

    List<Category> findList(Category category);

    Category findById(Integer id);

    void add(Category category);

    void update(Category category);

    void delete(Integer id);

}

