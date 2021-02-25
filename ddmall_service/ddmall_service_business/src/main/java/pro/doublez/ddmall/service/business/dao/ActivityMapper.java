package pro.doublez.ddmall.service.business.dao;

import org.apache.ibatis.annotations.Mapper;
import pro.doublez.ddmall.business.pojo.Activity;

import java.util.List;


@Mapper
public interface ActivityMapper {

    List<Activity> findList(Activity activity);

    Activity findById(Integer id);

    void add(Activity activity);

    void update(Activity activity);

    void delete(Integer id);

}

