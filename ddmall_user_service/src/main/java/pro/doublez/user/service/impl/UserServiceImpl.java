package pro.doublez.user.service.impl;

import org.springframework.stereotype.Service;
import pro.doublez.user.dao.UserDao;
import pro.doublez.user.pojo.User;
import pro.doublez.user.service.UserService;

/**
 * @author doublez
 * @version 1.0
 * @date 2021/7/11 14:24
 */
@Service
public class UserServiceImpl implements UserService {


    private final UserDao userDao;

    public UserServiceImpl(UserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    public User findUserByUsername(String username) {
        return userDao.findUserByUsername(username);
    }

    @Override
    public User findUserById(int id) {
        return userDao.findUserById(id);
    }

    @Override
    public String findNameById(int id) {
        return userDao.findNameById(id);
    }

    @Override
    public Integer register(User userBean) {
        return userDao.addUser(userBean);
    }

    @Override
    public User login(String username, String password) {
        User realUser = findUserByUsername(username);
        if (realUser != null) {
            String realPassword = realUser.getPassword();
            if (password.equals(realPassword)) {
                return realUser;
            }
        }
        return null;
    }

    @Override
    public Integer changePassword(String username, String password, String newPassword) {
        User user = findUserByUsername(username);
        String realPassword = user.getPassword();
        if (!password.equals(realPassword)) {
            return -1;
        } else {
            return userDao.changePassword(newPassword, username);
        }
    }

    @Override
    public User[] findAllUser() {
        return userDao.findAllUser();
    }

}
