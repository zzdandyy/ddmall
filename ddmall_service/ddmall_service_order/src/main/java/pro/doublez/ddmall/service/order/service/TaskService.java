package pro.doublez.ddmall.service.order.service;

import pro.doublez.ddmall.order.pojo.Task;
import com.github.pagehelper.PageInfo;

import java.util.List;

public interface TaskService {

    // 条件查询
    List<Task> findList(Task task);

    // 分页条件查询
    PageInfo<Task> findPage(Task task, int page, int size);

    Task findById(Integer id);

    void add(Task task);

    void update(Task task);

    void delete(Integer id);

}
