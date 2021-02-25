package pro.doublez.ddmall.service.config.dao;

import org.apache.ibatis.annotations.Mapper;
import pro.doublez.ddmall.config.pojo.Cities;

import java.util.List;


@Mapper
public interface CitiesMapper {

    List<Cities> findList(Cities cities);

    Cities findById(Integer id);

    void add(Cities cities);

    void update(Cities cities);

    void delete(Integer id);

}

