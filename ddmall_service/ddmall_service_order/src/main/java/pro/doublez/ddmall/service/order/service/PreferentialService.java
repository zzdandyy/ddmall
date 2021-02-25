package pro.doublez.ddmall.service.order.service;

import pro.doublez.ddmall.order.pojo.Preferential;
import com.github.pagehelper.PageInfo;

import java.util.List;

public interface PreferentialService {

    // 条件查询
    List<Preferential> findList(Preferential preferential);

    // 分页条件查询
    PageInfo<Preferential> findPage(Preferential preferential, int page, int size);

    Preferential findById(Integer id);

    void add(Preferential preferential);

    void update(Preferential preferential);

    void delete(Integer id);

}
