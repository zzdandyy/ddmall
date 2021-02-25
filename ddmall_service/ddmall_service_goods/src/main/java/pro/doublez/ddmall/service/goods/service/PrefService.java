package pro.doublez.ddmall.service.goods.service;

import com.github.pagehelper.PageInfo;
import pro.doublez.ddmall.goods.pojo.Album;

import pro.doublez.ddmall.goods.pojo.Pref;

import java.util.List;
import java.util.Map;

public interface PrefService {

    // 条件查询
    List<Pref> findList(Pref pref);

    // 分页条件查询
    PageInfo<Pref> findPage(Pref pref, int page, int size);

    Pref findById(Integer id);

    void add(Pref pref);

    void update(Pref pref);

    void delete(Integer id);

}
