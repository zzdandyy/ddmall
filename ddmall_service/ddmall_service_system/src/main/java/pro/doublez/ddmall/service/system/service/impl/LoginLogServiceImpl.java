package pro.doublez.ddmall.service.system.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Service;
import pro.doublez.ddmall.service.system.dao.LoginLogMapper;
import pro.doublez.ddmall.service.system.service.LoginLogService;
import pro.doublez.ddmall.system.pojo.LoginLog;

import javax.annotation.Resource;
import java.util.List;

@Service
public class LoginLogServiceImpl implements LoginLogService {

    @Resource
    private LoginLogMapper loginLogMapper;

    @Override
    public List<LoginLog> findList(LoginLog loginLog) {
        return loginLogMapper.findList(loginLog);
    }

    @Override
    public PageInfo<LoginLog> findPage(LoginLog loginLog,int page,int size) {
        PageHelper.startPage(page, size);
        List<LoginLog> all = loginLogMapper.findList(loginLog);
        return new PageInfo<>(all);
    }

    @Override
    public LoginLog findById(Integer id) {
        return loginLogMapper.findById(id);
    }

    @Override
    public void add(LoginLog loginLog) {
        loginLogMapper.add(loginLog);
    }

    @Override
    public void update(LoginLog loginLog) {
        loginLogMapper.update(loginLog);
    }

    @Override
    public void delete(Integer id) {
        loginLogMapper.delete(id);
    }
}
