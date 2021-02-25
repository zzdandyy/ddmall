package pro.doublez.ddmall.service.goods.service;



import com.github.pagehelper.PageInfo;
import pro.doublez.ddmall.goods.pojo.Spec;

import java.util.List;
import java.util.Map;

public interface SpecService {

    // 条件查询
    List<Spec> findList(Spec spec);

    // 分页条件查询
    PageInfo<Spec> findPage(Spec spec, int page, int size);

    Spec findById(Integer id);

    void add(Spec spec);

    void update(Spec spec);

    void delete(Integer id);
}
