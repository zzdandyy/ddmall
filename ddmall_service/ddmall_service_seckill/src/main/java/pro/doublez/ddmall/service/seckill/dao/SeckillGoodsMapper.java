package pro.doublez.ddmall.service.seckill.dao;

import org.apache.ibatis.annotations.Mapper;
import pro.doublez.ddmall.seckill.pojo.SeckillGoods;

import java.util.List;


@Mapper
public interface SeckillGoodsMapper {

    List<SeckillGoods> findList(SeckillGoods seckillGoods);

    SeckillGoods findById(Integer id);

    void add(SeckillGoods seckillGoods);

    void update(SeckillGoods seckillGoods);

    void delete(Integer id);

}

