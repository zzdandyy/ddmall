package pro.doublez.ddmall.service.goods.service;


import com.github.pagehelper.PageInfo;
import pro.doublez.ddmall.goods.pojo.Album;
import pro.doublez.ddmall.goods.pojo.Brand;
import pro.doublez.ddmall.goods.pojo.Log;

import java.util.List;
import java.util.Map;

public interface LogService {

    // 条件查询
    List<Log> findList(Log log);

    // 分页条件查询
    PageInfo<Log> findPage(Log log, int page, int size);

    Log findById(Long id);

    void add(Log log);

    void update(Log log);

    void delete(Long id);

}
