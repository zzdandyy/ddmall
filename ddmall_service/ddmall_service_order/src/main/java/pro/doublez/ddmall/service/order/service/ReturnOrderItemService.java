package pro.doublez.ddmall.service.order.service;

import pro.doublez.ddmall.order.pojo.ReturnOrderItem;
import com.github.pagehelper.PageInfo;

import java.util.List;

public interface ReturnOrderItemService {

    // 条件查询
    List<ReturnOrderItem> findList(ReturnOrderItem returnOrderItem);

    // 分页条件查询
    PageInfo<ReturnOrderItem> findPage(ReturnOrderItem returnOrderItem, int page, int size);

    ReturnOrderItem findById(Integer id);

    void add(ReturnOrderItem returnOrderItem);

    void update(ReturnOrderItem returnOrderItem);

    void delete(Integer id);

}
