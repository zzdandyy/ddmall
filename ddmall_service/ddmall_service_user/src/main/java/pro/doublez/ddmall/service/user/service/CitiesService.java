package pro.doublez.ddmall.service.user.service;

import com.github.pagehelper.PageInfo;
import pro.doublez.ddmall.user.pojo.Cities;

import java.util.List;

public interface CitiesService {

    // 条件查询
    List<Cities> findList(Cities cities);

    // 分页条件查询
    PageInfo<Cities> findPage(Cities cities, int page, int size);

    Cities findById(Integer id);

    void add(Cities cities);

    void update(Cities cities);

    void delete(Integer id);

}
