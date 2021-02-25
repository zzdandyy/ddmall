package pro.doublez.ddmall.service.user.dao;

import org.apache.ibatis.annotations.Mapper;
import pro.doublez.ddmall.user.pojo.Sku;

import java.util.List;


@Mapper
public interface SkuMapper {

    List<Sku> findList(Sku sku);

    Sku findById(Integer id);

    void add(Sku sku);

    void update(Sku sku);

    void delete(Integer id);

}

