package pro.doublez.ddmall.service.system.service;

import com.github.pagehelper.PageInfo;
import pro.doublez.ddmall.system.pojo.Menu;

import java.util.List;

public interface MenuService {

    // 条件查询
    List<Menu> findList(Menu menu);

    // 分页条件查询
    PageInfo<Menu> findPage(Menu menu, int page, int size);

    Menu findById(Integer id);

    void add(Menu menu);

    void update(Menu menu);

    void delete(Integer id);

}
