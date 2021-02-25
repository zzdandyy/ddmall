package pro.doublez.ddmall.service.system.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Service;
import pro.doublez.ddmall.service.system.dao.RoleMapper;
import pro.doublez.ddmall.service.system.service.RoleService;
import pro.doublez.ddmall.system.pojo.Role;

import javax.annotation.Resource;
import java.util.List;

@Service
public class RoleServiceImpl implements RoleService {

    @Resource
    private RoleMapper roleMapper;

    @Override
    public List<Role> findList(Role role) {
        return roleMapper.findList(role);
    }

    @Override
    public PageInfo<Role> findPage(Role role,int page,int size) {
        PageHelper.startPage(page, size);
        List<Role> all = roleMapper.findList(role);
        return new PageInfo<>(all);
    }

    @Override
    public Role findById(Integer id) {
        return roleMapper.findById(id);
    }

    @Override
    public void add(Role role) {
        roleMapper.add(role);
    }

    @Override
    public void update(Role role) {
        roleMapper.update(role);
    }

    @Override
    public void delete(Integer id) {
        roleMapper.delete(id);
    }
}
