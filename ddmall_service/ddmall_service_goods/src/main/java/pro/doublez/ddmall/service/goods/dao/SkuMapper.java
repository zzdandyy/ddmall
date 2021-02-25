package pro.doublez.ddmall.service.goods.dao;


import org.apache.ibatis.annotations.Mapper;
import pro.doublez.ddmall.goods.pojo.Sku;

import java.util.List;

@Mapper
public interface SkuMapper  {

    List<Sku> findList(Sku sku);

    Sku findById(String id);

    void add(Sku sku);

    void update(Sku sku);

    void delete(String id);

}
