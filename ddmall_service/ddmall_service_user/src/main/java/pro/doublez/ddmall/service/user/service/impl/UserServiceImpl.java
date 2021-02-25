package pro.doublez.ddmall.service.user.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Service;
import pro.doublez.ddmall.service.user.dao.UserMapper;
import pro.doublez.ddmall.service.user.service.UserService;
import pro.doublez.ddmall.user.pojo.User;

import javax.annotation.Resource;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Resource
    private UserMapper userMapper;

    @Override
    public List<User> findList(User user) {
        return userMapper.findList(user);
    }

    @Override
    public PageInfo<User> findPage(User user,int page,int size) {
        PageHelper.startPage(page, size);
        List<User> all = userMapper.findList(user);
        return new PageInfo<>(all);
    }

    @Override
    public User findById(Integer id) {
        return userMapper.findById(id);
    }

    @Override
    public void add(User user) {
        userMapper.add(user);
    }

    @Override
    public void update(User user) {
        userMapper.update(user);
    }

    @Override
    public void delete(Integer id) {
        userMapper.delete(id);
    }
}
