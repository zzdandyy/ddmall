package pro.doublez.ddmall.service.goods.dao;

import pro.doublez.ddmall.goods.pojo.Brand;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;


@Mapper
public interface BrandMapper {

    List<Brand> findList(Brand brand);

    Brand findById(Integer id);

    void add(Brand brand);

    void update(Brand brand);

    void delete(Integer id);

}
