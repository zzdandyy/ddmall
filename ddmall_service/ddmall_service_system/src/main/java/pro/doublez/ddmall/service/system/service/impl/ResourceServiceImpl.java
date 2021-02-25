package pro.doublez.ddmall.service.system.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pro.doublez.ddmall.service.system.dao.ResourceMapper;
import pro.doublez.ddmall.service.system.service.ResourceService;
import pro.doublez.ddmall.system.pojo.Resource;


import java.util.List;

@Service
public class ResourceServiceImpl implements ResourceService {

    @Autowired
    private ResourceMapper resourceMapper;

    @Override
    public List<Resource> findList(Resource resource) {
        return resourceMapper.findList(resource);
    }

    @Override
    public PageInfo<Resource> findPage(Resource resource, int page, int size) {
        PageHelper.startPage(page, size);
        List<Resource> all = resourceMapper.findList(resource);
        return new PageInfo<>(all);
    }

    @Override
    public Resource findById(Integer id) {
        return resourceMapper.findById(id);
    }

    @Override
    public void add(Resource resource) {
        resourceMapper.add(resource);
    }

    @Override
    public void update(Resource resource) {
        resourceMapper.update(resource);
    }

    @Override
    public void delete(Integer id) {
        resourceMapper.delete(id);
    }
}
