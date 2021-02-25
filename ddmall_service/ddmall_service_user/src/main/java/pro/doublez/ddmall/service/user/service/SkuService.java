package pro.doublez.ddmall.service.user.service;

import com.github.pagehelper.PageInfo;
import pro.doublez.ddmall.user.pojo.Sku;

import java.util.List;

public interface SkuService {

    // 条件查询
    List<Sku> findList(Sku sku);

    // 分页条件查询
    PageInfo<Sku> findPage(Sku sku, int page, int size);

    Sku findById(Integer id);

    void add(Sku sku);

    void update(Sku sku);

    void delete(Integer id);

}
