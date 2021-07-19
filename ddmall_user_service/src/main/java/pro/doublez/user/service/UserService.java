package pro.doublez.user.service;

import org.apache.ibatis.annotations.Select;
import pro.doublez.user.pojo.User;

/**
 * @author doublez
 * @version 1.0
 * @date 2021/7/11 14:23
 */
public interface UserService {

    User findUserByUsername(String username);

    User findUserById(int id);

    String findNameById(int id);

    //注册
    Integer register(User userBean);

    //登录
    User login(String username, String password);

    //修改密码
    Integer changePassword(String username, String password, String newPassword);

    //查找所有用户
    User[] findAllUser();
}
