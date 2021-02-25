package pro.doublez.ddmall.service.business.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Service;
import pro.doublez.ddmall.business.pojo.Activity;
import pro.doublez.ddmall.service.business.dao.ActivityMapper;
import pro.doublez.ddmall.service.business.service.ActivityService;

import javax.annotation.Resource;
import java.util.List;

@Service
public class ActivityServiceImpl implements ActivityService {

    @Resource
    private ActivityMapper activityMapper;

    @Override
    public List<Activity> findList(Activity activity) {
        return activityMapper.findList(activity);
    }

    @Override
    public PageInfo<Activity> findPage(Activity activity,int page,int size) {
        PageHelper.startPage(page, size);
        List<Activity> all = activityMapper.findList(activity);
        return new PageInfo<>(all);
    }

    @Override
    public Activity findById(Integer id) {
        return activityMapper.findById(id);
    }

    @Override
    public void add(Activity activity) {
        activityMapper.add(activity);
    }

    @Override
    public void update(Activity activity) {
        activityMapper.update(activity);
    }

    @Override
    public void delete(Integer id) {
        activityMapper.delete(id);
    }
}
