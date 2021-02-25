package pro.doublez.ddmall.service.business.service;

import com.github.pagehelper.PageInfo;
import pro.doublez.ddmall.business.pojo.Ad;

import java.util.List;

public interface AdService {

    // 条件查询
    List<Ad> findList(Ad ad);

    // 分页条件查询
    PageInfo<Ad> findPage(Ad ad, int page, int size);

    Ad findById(Integer id);

    void add(Ad ad);

    void update(Ad ad);

    void delete(Integer id);

}
