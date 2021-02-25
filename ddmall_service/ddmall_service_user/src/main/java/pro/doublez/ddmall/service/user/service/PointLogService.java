package pro.doublez.ddmall.service.user.service;

import com.github.pagehelper.PageInfo;
import pro.doublez.ddmall.user.pojo.PointLog;

import java.util.List;

public interface PointLogService {

    // 条件查询
    List<PointLog> findList(PointLog pointLog);

    // 分页条件查询
    PageInfo<PointLog> findPage(PointLog pointLog, int page, int size);

    PointLog findById(Integer id);

    void add(PointLog pointLog);

    void update(PointLog pointLog);

    void delete(Integer id);

}
