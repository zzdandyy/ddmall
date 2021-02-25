package pro.doublez.ddmall.service.seckill.service;

import com.github.pagehelper.PageInfo;
import pro.doublez.ddmall.seckill.pojo.SeckillGoods;

import java.util.List;

public interface SeckillGoodsService {

    // 条件查询
    List<SeckillGoods> findList(SeckillGoods seckillGoods);

    // 分页条件查询
    PageInfo<SeckillGoods> findPage(SeckillGoods seckillGoods, int page, int size);

    SeckillGoods findById(Integer id);

    void add(SeckillGoods seckillGoods);

    void update(SeckillGoods seckillGoods);

    void delete(Integer id);

}
