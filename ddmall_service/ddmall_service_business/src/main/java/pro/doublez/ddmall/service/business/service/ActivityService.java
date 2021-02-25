package pro.doublez.ddmall.service.business.service;

import com.github.pagehelper.PageInfo;
import pro.doublez.ddmall.business.pojo.Activity;

import java.util.List;

public interface ActivityService {

    // 条件查询
    List<Activity> findList(Activity activity);

    // 分页条件查询
    PageInfo<Activity> findPage(Activity activity, int page, int size);

    Activity findById(Integer id);

    void add(Activity activity);

    void update(Activity activity);

    void delete(Integer id);

}
