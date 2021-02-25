package pro.doublez.ddmall.service.system.service;

import com.github.pagehelper.PageInfo;
import pro.doublez.ddmall.system.pojo.LoginLog;

import java.util.List;

public interface LoginLogService {

    // 条件查询
    List<LoginLog> findList(LoginLog loginLog);

    // 分页条件查询
    PageInfo<LoginLog> findPage(LoginLog loginLog, int page, int size);

    LoginLog findById(Integer id);

    void add(LoginLog loginLog);

    void update(LoginLog loginLog);

    void delete(Integer id);

}
