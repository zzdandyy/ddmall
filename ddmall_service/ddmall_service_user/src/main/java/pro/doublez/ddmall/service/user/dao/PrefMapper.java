package pro.doublez.ddmall.service.user.dao;

import org.apache.ibatis.annotations.Mapper;
import pro.doublez.ddmall.user.pojo.Pref;

import java.util.List;


@Mapper
public interface PrefMapper {

    List<Pref> findList(Pref pref);

    Pref findById(Integer id);

    void add(Pref pref);

    void update(Pref pref);

    void delete(Integer id);

}

