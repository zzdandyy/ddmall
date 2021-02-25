package pro.doublez.ddmall.service.user.service;

import com.github.pagehelper.PageInfo;
import pro.doublez.ddmall.user.pojo.Spu;

import java.util.List;

public interface SpuService {

    // 条件查询
    List<Spu> findList(Spu spu);

    // 分页条件查询
    PageInfo<Spu> findPage(Spu spu, int page, int size);

    Spu findById(Integer id);

    void add(Spu spu);

    void update(Spu spu);

    void delete(Integer id);

}
