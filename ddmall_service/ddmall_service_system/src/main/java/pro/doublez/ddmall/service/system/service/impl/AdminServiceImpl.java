package pro.doublez.ddmall.service.system.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Service;
import pro.doublez.ddmall.service.system.dao.AdminMapper;
import pro.doublez.ddmall.service.system.service.AdminService;
import pro.doublez.ddmall.system.pojo.Admin;

import javax.annotation.Resource;
import java.util.List;

@Service
public class AdminServiceImpl implements AdminService {

    @Resource
    private AdminMapper adminMapper;

    @Override
    public List<Admin> findList(Admin admin) {
        return adminMapper.findList(admin);
    }

    @Override
    public PageInfo<Admin> findPage(Admin admin,int page,int size) {
        PageHelper.startPage(page, size);
        List<Admin> all = adminMapper.findList(admin);
        return new PageInfo<>(all);
    }

    @Override
    public Admin findById(Integer id) {
        return adminMapper.findById(id);
    }

    @Override
    public void add(Admin admin) {
        adminMapper.add(admin);
    }

    @Override
    public void update(Admin admin) {
        adminMapper.update(admin);
    }

    @Override
    public void delete(Integer id) {
        adminMapper.delete(id);
    }
}
