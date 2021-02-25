package pro.doublez.ddmall.service.config.service;

import com.github.pagehelper.PageInfo;
import pro.doublez.ddmall.config.pojo.User;

import java.util.List;

public interface UserService {

    // 条件查询
    List<User> findList(User user);

    // 分页条件查询
    PageInfo<User> findPage(User user, int page, int size);

    User findById(Integer id);

    void add(User user);

    void update(User user);

    void delete(Integer id);

}
