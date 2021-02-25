package pro.doublez.ddmall.service.goods.service;


import com.github.pagehelper.Page;
import com.github.pagehelper.PageInfo;
import pro.doublez.ddmall.goods.pojo.Album;
import pro.doublez.ddmall.goods.pojo.Spu;

import java.util.List;
import java.util.Map;

public interface SpuService {

    // 条件查询
    List<Spu> findList(Spu spu);

    // 分页条件查询
    PageInfo<Spu> findPage(Spu spu, int page, int size);

    Spu findById(String id);

    void add(Spu spu);

    void update(Spu spu);

    void delete(String id);

}
