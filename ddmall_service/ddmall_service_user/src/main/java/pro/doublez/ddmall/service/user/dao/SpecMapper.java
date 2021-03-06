package pro.doublez.ddmall.service.user.dao;

import org.apache.ibatis.annotations.Mapper;
import pro.doublez.ddmall.user.pojo.Spec;

import java.util.List;


@Mapper
public interface SpecMapper {

    List<Spec> findList(Spec spec);

    Spec findById(Integer id);

    void add(Spec spec);

    void update(Spec spec);

    void delete(Integer id);

}

