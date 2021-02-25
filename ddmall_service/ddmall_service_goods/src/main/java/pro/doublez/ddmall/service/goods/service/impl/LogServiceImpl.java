package pro.doublez.ddmall.service.goods.service.impl;

import pro.doublez.ddmall.goods.pojo.Log;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Service;
import pro.doublez.ddmall.service.goods.dao.LogMapper;
import pro.doublez.ddmall.service.goods.service.LogService;

import javax.annotation.Resource;
import java.util.List;

@Service
public class LogServiceImpl implements LogService {

    @Resource
    private LogMapper logMapper;

    @Override
    public List<Log> findList(Log log) {
        return logMapper.findList(log);
    }

    @Override
    public PageInfo<Log> findPage(Log log,int page,int size) {
        PageHelper.startPage(page, size);
        List<Log> all = logMapper.findList(log);
        return new PageInfo<>(all);
    }

    @Override
    public Log findById(Long id) {
        return logMapper.findById(id);
    }

    @Override
    public void add(Log log) {
        logMapper.add(log);
    }

    @Override
    public void update(Log log) {
        logMapper.update(log);
    }

    @Override
    public void delete(Long id) {
        logMapper.delete(id);
    }
}
