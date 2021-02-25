package pro.doublez.ddmall.service.goods.dao;

import org.apache.ibatis.annotations.Mapper;
import pro.doublez.ddmall.goods.pojo.CategoryBrand;

import java.util.List;


@Mapper
public interface CategoryBrandMapper {

    List<CategoryBrand> findList(CategoryBrand categoryBrand);

    CategoryBrand findById(Integer id);

    void add(CategoryBrand categoryBrand);

    void update(CategoryBrand categoryBrand);

    void delete(Integer id);

}

