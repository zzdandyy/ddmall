package pro.doublez.ddmall.service.user.service;

import com.github.pagehelper.PageInfo;
import pro.doublez.ddmall.user.pojo.Spec;

import java.util.List;

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
