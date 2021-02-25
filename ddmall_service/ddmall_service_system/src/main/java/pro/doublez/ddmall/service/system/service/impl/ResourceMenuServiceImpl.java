package pro.doublez.ddmall.service.system.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Service;
import pro.doublez.ddmall.service.system.dao.ResourceMenuMapper;
import pro.doublez.ddmall.service.system.service.ResourceMenuService;
import pro.doublez.ddmall.system.pojo.ResourceMenu;

import javax.annotation.Resource;
import java.util.List;

@Service
public class ResourceMenuServiceImpl implements ResourceMenuService {

    @Resource
    private ResourceMenuMapper resourceMenuMapper;

    @Override
    public List<ResourceMenu> findList(ResourceMenu resourceMenu) {
        return resourceMenuMapper.findList(resourceMenu);
    }

    @Override
    public PageInfo<ResourceMenu> findPage(ResourceMenu resourceMenu,int page,int size) {
        PageHelper.startPage(page, size);
        List<ResourceMenu> all = resourceMenuMapper.findList(resourceMenu);
        return new PageInfo<>(all);
    }

    @Override
    public ResourceMenu findById(Integer id) {
        return resourceMenuMapper.findById(id);
    }

    @Override
    public void add(ResourceMenu resourceMenu) {
        resourceMenuMapper.add(resourceMenu);
    }

    @Override
    public void update(ResourceMenu resourceMenu) {
        resourceMenuMapper.update(resourceMenu);
    }

    @Override
    public void delete(Integer id) {
        resourceMenuMapper.delete(id);
    }
}
