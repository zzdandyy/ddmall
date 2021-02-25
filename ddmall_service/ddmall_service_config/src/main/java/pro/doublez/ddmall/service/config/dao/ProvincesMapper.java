package pro.doublez.ddmall.service.config.dao;

import org.apache.ibatis.annotations.Mapper;
import pro.doublez.ddmall.config.pojo.Provinces;

import java.util.List;


@Mapper
public interface ProvincesMapper {

    List<Provinces> findList(Provinces provinces);

    Provinces findById(Integer id);

    void add(Provinces provinces);

    void update(Provinces provinces);

    void delete(Integer id);

}

