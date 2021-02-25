package pro.doublez.ddmall.service.system.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Service;
import pro.doublez.ddmall.service.system.dao.MenuMapper;
import pro.doublez.ddmall.service.system.service.MenuService;
import pro.doublez.ddmall.system.pojo.Menu;

import javax.annotation.Resource;
import java.util.List;

@Service
public class MenuServiceImpl implements MenuService {

    @Resource
    private MenuMapper menuMapper;

    @Override
    public List<Menu> findList(Menu menu) {
        return menuMapper.findList(menu);
    }

    @Override
    public PageInfo<Menu> findPage(Menu menu,int page,int size) {
        PageHelper.startPage(page, size);
        List<Menu> all = menuMapper.findList(menu);
        return new PageInfo<>(all);
    }

    @Override
    public Menu findById(Integer id) {
        return menuMapper.findById(id);
    }

    @Override
    public void add(Menu menu) {
        menuMapper.add(menu);
    }

    @Override
    public void update(Menu menu) {
        menuMapper.update(menu);
    }

    @Override
    public void delete(Integer id) {
        menuMapper.delete(id);
    }
}
