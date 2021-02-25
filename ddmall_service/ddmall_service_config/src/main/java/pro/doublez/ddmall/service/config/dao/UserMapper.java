package pro.doublez.ddmall.service.config.dao;

import org.apache.ibatis.annotations.Mapper;
import pro.doublez.ddmall.config.pojo.User;

import java.util.List;


@Mapper
public interface UserMapper {

    List<User> findList(User user);

    User findById(Integer id);

    void add(User user);

    void update(User user);

    void delete(Integer id);

}

