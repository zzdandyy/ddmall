package pro.doublez.ddmall.service.goods.service;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageInfo;
import pro.doublez.ddmall.goods.pojo.Album;
import pro.doublez.ddmall.goods.pojo.Para;

import java.util.List;
import java.util.Map;

public interface ParaService {


    // 条件查询
    List<Para> findList(Para para);

    // 分页条件查询
    PageInfo<Para> findPage(Para para, int page, int size);

    Para findById(Integer id);

    void add(Para para);

    void update(Para para);

    void delete(Integer id);

}
