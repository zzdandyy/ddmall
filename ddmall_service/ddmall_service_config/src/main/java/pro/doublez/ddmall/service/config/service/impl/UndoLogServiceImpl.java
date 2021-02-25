package pro.doublez.ddmall.service.config.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Service;
import pro.doublez.ddmall.config.pojo.UndoLog;
import pro.doublez.ddmall.service.config.dao.UndoLogMapper;
import pro.doublez.ddmall.service.config.service.UndoLogService;

import javax.annotation.Resource;
import java.util.List;

@Service
public class UndoLogServiceImpl implements UndoLogService {

    @Resource
    private UndoLogMapper undoLogMapper;

    @Override
    public List<UndoLog> findList(UndoLog undoLog) {
        return undoLogMapper.findList(undoLog);
    }

    @Override
    public PageInfo<UndoLog> findPage(UndoLog undoLog,int page,int size) {
        PageHelper.startPage(page, size);
        List<UndoLog> all = undoLogMapper.findList(undoLog);
        return new PageInfo<>(all);
    }

    @Override
    public UndoLog findById(Integer id) {
        return undoLogMapper.findById(id);
    }

    @Override
    public void add(UndoLog undoLog) {
        undoLogMapper.add(undoLog);
    }

    @Override
    public void update(UndoLog undoLog) {
        undoLogMapper.update(undoLog);
    }

    @Override
    public void delete(Integer id) {
        undoLogMapper.delete(id);
    }
}
