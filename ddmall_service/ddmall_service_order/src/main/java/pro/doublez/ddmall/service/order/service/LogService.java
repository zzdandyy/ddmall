package pro.doublez.ddmall.service.order.service;

import pro.doublez.ddmall.order.pojo.Log;
import com.github.pagehelper.PageInfo;

import java.util.List;

public interface LogService {

    // 条件查询
    List<Log> findList(Log log);

    // 分页条件查询
    PageInfo<Log> findPage(Log log, int page, int size);

    Log findById(Integer id);

    void add(Log log);

    void update(Log log);

    void delete(Integer id);

}
