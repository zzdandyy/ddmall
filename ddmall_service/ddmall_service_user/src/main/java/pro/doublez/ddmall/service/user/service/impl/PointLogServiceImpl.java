package pro.doublez.ddmall.service.user.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Service;
import pro.doublez.ddmall.service.user.dao.PointLogMapper;
import pro.doublez.ddmall.service.user.service.PointLogService;
import pro.doublez.ddmall.user.pojo.PointLog;

import javax.annotation.Resource;
import java.util.List;

@Service
public class PointLogServiceImpl implements PointLogService {

    @Resource
    private PointLogMapper pointLogMapper;

    @Override
    public List<PointLog> findList(PointLog pointLog) {
        return pointLogMapper.findList(pointLog);
    }

    @Override
    public PageInfo<PointLog> findPage(PointLog pointLog,int page,int size) {
        PageHelper.startPage(page, size);
        List<PointLog> all = pointLogMapper.findList(pointLog);
        return new PageInfo<>(all);
    }

    @Override
    public PointLog findById(Integer id) {
        return pointLogMapper.findById(id);
    }

    @Override
    public void add(PointLog pointLog) {
        pointLogMapper.add(pointLog);
    }

    @Override
    public void update(PointLog pointLog) {
        pointLogMapper.update(pointLog);
    }

    @Override
    public void delete(Integer id) {
        pointLogMapper.delete(id);
    }
}
