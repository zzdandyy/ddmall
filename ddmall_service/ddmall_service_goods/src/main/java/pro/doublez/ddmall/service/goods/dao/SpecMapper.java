package pro.doublez.ddmall.service.goods.dao;


import org.apache.ibatis.annotations.Mapper;
import pro.doublez.ddmall.goods.pojo.Spec;

import java.util.List;

@Mapper
public interface SpecMapper  {

    List<Spec> findList(Spec spec);

    Spec findById(Integer id);

    void add(Spec spec);

    void update(Spec spec);

    void delete(Integer id);

}
