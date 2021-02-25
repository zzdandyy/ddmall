package pro.doublez.ddmall.service.order.service;

import pro.doublez.ddmall.order.pojo.ReturnOrder;
import com.github.pagehelper.PageInfo;

import java.util.List;

public interface ReturnOrderService {

    // 条件查询
    List<ReturnOrder> findList(ReturnOrder returnOrder);

    // 分页条件查询
    PageInfo<ReturnOrder> findPage(ReturnOrder returnOrder, int page, int size);

    ReturnOrder findById(Integer id);

    void add(ReturnOrder returnOrder);

    void update(ReturnOrder returnOrder);

    void delete(Integer id);

}
