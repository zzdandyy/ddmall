package pro.doublez.ddmall.service.goods.dao;


import org.apache.ibatis.annotations.Mapper;
import pro.doublez.ddmall.goods.pojo.Spu;

import java.util.List;

@Mapper
public interface SpuMapper {

    List<Spu> findList(Spu spu);

    Spu findById(String id);

    void add(Spu spu);

    void update(Spu spu);

    void delete(String id);
}
