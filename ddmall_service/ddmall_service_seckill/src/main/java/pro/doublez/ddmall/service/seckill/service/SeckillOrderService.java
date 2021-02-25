package pro.doublez.ddmall.service.seckill.service;

import com.github.pagehelper.PageInfo;
import pro.doublez.ddmall.seckill.pojo.SeckillOrder;

import java.util.List;

public interface SeckillOrderService {

    // 条件查询
    List<SeckillOrder> findList(SeckillOrder seckillOrder);

    // 分页条件查询
    PageInfo<SeckillOrder> findPage(SeckillOrder seckillOrder, int page, int size);

    SeckillOrder findById(Integer id);

    void add(SeckillOrder seckillOrder);

    void update(SeckillOrder seckillOrder);

    void delete(Integer id);

}
