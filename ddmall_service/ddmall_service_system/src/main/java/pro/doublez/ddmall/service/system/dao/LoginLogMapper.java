package pro.doublez.ddmall.service.system.dao;

import org.apache.ibatis.annotations.Mapper;
import pro.doublez.ddmall.system.pojo.LoginLog;

import java.util.List;


@Mapper
public interface LoginLogMapper {

    List<LoginLog> findList(LoginLog loginLog);

    LoginLog findById(Integer id);

    void add(LoginLog loginLog);

    void update(LoginLog loginLog);

    void delete(Integer id);

}

