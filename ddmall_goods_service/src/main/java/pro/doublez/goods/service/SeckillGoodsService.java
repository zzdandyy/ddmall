package pro.doublez.goods.service;


import pro.doublez.goods.pojo.SeckillGoods;

import java.util.Date;

/**
 * @author doublez
 * @version 1.0
 * @date 2021/7/15 21:39
 */
public interface SeckillGoodsService {

    //查询所有秒杀商品
    SeckillGoods[] findAll();

    //根据id查询秒杀商品
    SeckillGoods findAllById(long id);

    //根据名称查询秒杀商品
    SeckillGoods[] findAllByName(String name);

    //根据id查询商品库存
    Integer findCountById(long id);

    //查询所有在售的秒杀商品
    SeckillGoods[] findAllOnSale();

    //根据id查询在售的秒杀商品
    SeckillGoods findAllByIdOnSale(long id);

    //根据名称查询在售的秒杀商品
    SeckillGoods[] findAllByNameOnSale(String name);

    //添加秒杀商品
    Integer addGoods(SeckillGoods seckillGoodsBean);

    //修改秒杀商品的开始时间
    Integer changeStartTime(Date date,long id);

    //修改秒杀商品的结束时间
    Integer changeEndTime(Date date, long id);

    //修改秒杀商品库存
    Integer changeSeckillGoodsCount(int count ,long id);

    Integer downCount(int count, long secId);
}
