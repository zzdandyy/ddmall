package pro.doublez.ddmall.service.system.dao;

import org.apache.ibatis.annotations.Mapper;
import pro.doublez.ddmall.system.pojo.Menu;

import java.util.List;


@Mapper
public interface MenuMapper {

    List<Menu> findList(Menu menu);

    Menu findById(Integer id);

    void add(Menu menu);

    void update(Menu menu);

    void delete(Integer id);

}

