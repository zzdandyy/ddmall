package pro.doublez.ddmall.service.order.service.impl;

import pro.doublez.ddmall.order.pojo.TaskHis;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Service;
import pro.doublez.ddmall.service.order.dao.TaskHisMapper;
import pro.doublez.ddmall.service.order.service.TaskHisService;

import javax.annotation.Resource;
import java.util.List;

@Service
public class TaskHisServiceImpl implements TaskHisService {

    @Resource
    private TaskHisMapper taskHisMapper;

    @Override
    public List<TaskHis> findList(TaskHis taskHis) {
        return taskHisMapper.findList(taskHis);
    }

    @Override
    public PageInfo<TaskHis> findPage(TaskHis taskHis,int page,int size) {
        PageHelper.startPage(page, size);
        List<TaskHis> all = taskHisMapper.findList(taskHis);
        return new PageInfo<>(all);
    }

    @Override
    public TaskHis findById(Integer id) {
        return taskHisMapper.findById(id);
    }

    @Override
    public void add(TaskHis taskHis) {
        taskHisMapper.add(taskHis);
    }

    @Override
    public void update(TaskHis taskHis) {
        taskHisMapper.update(taskHis);
    }

    @Override
    public void delete(Integer id) {
        taskHisMapper.delete(id);
    }
}
