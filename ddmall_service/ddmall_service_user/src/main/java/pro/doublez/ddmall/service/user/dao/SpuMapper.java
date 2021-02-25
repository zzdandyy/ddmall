package pro.doublez.ddmall.service.user.dao;

import org.apache.ibatis.annotations.Mapper;
import pro.doublez.ddmall.user.pojo.Spu;

import java.util.List;


@Mapper
public interface SpuMapper {

    List<Spu> findList(Spu spu);

    Spu findById(Integer id);

    void add(Spu spu);

    void update(Spu spu);

    void delete(Integer id);

}

