package pro.doublez.ddmall.service.system.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Service;
import pro.doublez.ddmall.service.system.dao.RoleResourceMapper;
import pro.doublez.ddmall.service.system.service.RoleResourceService;
import pro.doublez.ddmall.system.pojo.RoleResource;

import javax.annotation.Resource;
import java.util.List;

@Service
public class RoleResourceServiceImpl implements RoleResourceService {

    @Resource
    private RoleResourceMapper roleResourceMapper;

    @Override
    public List<RoleResource> findList(RoleResource roleResource) {
        return roleResourceMapper.findList(roleResource);
    }

    @Override
    public PageInfo<RoleResource> findPage(RoleResource roleResource,int page,int size) {
        PageHelper.startPage(page, size);
        List<RoleResource> all = roleResourceMapper.findList(roleResource);
        return new PageInfo<>(all);
    }

    @Override
    public RoleResource findById(Integer id) {
        return roleResourceMapper.findById(id);
    }

    @Override
    public void add(RoleResource roleResource) {
        roleResourceMapper.add(roleResource);
    }

    @Override
    public void update(RoleResource roleResource) {
        roleResourceMapper.update(roleResource);
    }

    @Override
    public void delete(Integer id) {
        roleResourceMapper.delete(id);
    }
}
