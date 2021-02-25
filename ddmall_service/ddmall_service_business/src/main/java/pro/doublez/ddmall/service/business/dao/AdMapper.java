package pro.doublez.ddmall.service.business.dao;

import org.apache.ibatis.annotations.Mapper;
import pro.doublez.ddmall.business.pojo.Ad;

import java.util.List;


@Mapper
public interface AdMapper {

    List<Ad> findList(Ad ad);

    Ad findById(Integer id);

    void add(Ad ad);

    void update(Ad ad);

    void delete(Integer id);

}

