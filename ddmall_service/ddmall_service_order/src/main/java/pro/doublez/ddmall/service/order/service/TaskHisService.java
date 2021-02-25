package pro.doublez.ddmall.service.order.service;

import pro.doublez.ddmall.order.pojo.TaskHis;
import com.github.pagehelper.PageInfo;

import java.util.List;

public interface TaskHisService {

    // 条件查询
    List<TaskHis> findList(TaskHis taskHis);

    // 分页条件查询
    PageInfo<TaskHis> findPage(TaskHis taskHis, int page, int size);

    TaskHis findById(Integer id);

    void add(TaskHis taskHis);

    void update(TaskHis taskHis);

    void delete(Integer id);

}
