package pro.doublez.ddmall.service.order.service.impl;

import pro.doublez.ddmall.order.pojo.Task;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Service;
import pro.doublez.ddmall.service.order.dao.TaskMapper;
import pro.doublez.ddmall.service.order.service.TaskService;

import javax.annotation.Resource;
import java.util.List;

@Service
public class TaskServiceImpl implements TaskService {

    @Resource
    private TaskMapper taskMapper;

    @Override
    public List<Task> findList(Task task) {
        return taskMapper.findList(task);
    }

    @Override
    public PageInfo<Task> findPage(Task task,int page,int size) {
        PageHelper.startPage(page, size);
        List<Task> all = taskMapper.findList(task);
        return new PageInfo<>(all);
    }

    @Override
    public Task findById(Integer id) {
        return taskMapper.findById(id);
    }

    @Override
    public void add(Task task) {
        taskMapper.add(task);
    }

    @Override
    public void update(Task task) {
        taskMapper.update(task);
    }

    @Override
    public void delete(Integer id) {
        taskMapper.delete(id);
    }
}
