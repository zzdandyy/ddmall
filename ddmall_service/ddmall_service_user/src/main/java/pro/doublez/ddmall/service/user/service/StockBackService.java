package pro.doublez.ddmall.service.user.service;

import com.github.pagehelper.PageInfo;
import pro.doublez.ddmall.user.pojo.StockBack;

import java.util.List;

public interface StockBackService {

    // 条件查询
    List<StockBack> findList(StockBack stockBack);

    // 分页条件查询
    PageInfo<StockBack> findPage(StockBack stockBack, int page, int size);

    StockBack findById(Integer id);

    void add(StockBack stockBack);

    void update(StockBack stockBack);

    void delete(Integer id);

}
