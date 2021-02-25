package pro.doublez.ddmall.service.system.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Service;
import pro.doublez.ddmall.service.system.dao.AdminRoleMapper;
import pro.doublez.ddmall.service.system.service.AdminRoleService;
import pro.doublez.ddmall.system.pojo.AdminRole;

import javax.annotation.Resource;
import java.util.List;

@Service
public class AdminRoleServiceImpl implements AdminRoleService {

    @Resource
    private AdminRoleMapper adminRoleMapper;

    @Override
    public List<AdminRole> findList(AdminRole adminRole) {
        return adminRoleMapper.findList(adminRole);
    }

    @Override
    public PageInfo<AdminRole> findPage(AdminRole adminRole,int page,int size) {
        PageHelper.startPage(page, size);
        List<AdminRole> all = adminRoleMapper.findList(adminRole);
        return new PageInfo<>(all);
    }

    @Override
    public AdminRole findById(Integer id) {
        return adminRoleMapper.findById(id);
    }

    @Override
    public void add(AdminRole adminRole) {
        adminRoleMapper.add(adminRole);
    }

    @Override
    public void update(AdminRole adminRole) {
        adminRoleMapper.update(adminRole);
    }

    @Override
    public void delete(Integer id) {
        adminRoleMapper.delete(id);
    }
}
