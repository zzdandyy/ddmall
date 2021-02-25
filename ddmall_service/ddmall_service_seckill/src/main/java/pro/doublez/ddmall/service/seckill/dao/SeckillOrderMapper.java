package pro.doublez.ddmall.service.seckill.dao;

import org.apache.ibatis.annotations.Mapper;
import pro.doublez.ddmall.seckill.pojo.SeckillOrder;

import java.util.List;


@Mapper
public interface SeckillOrderMapper {

    List<SeckillOrder> findList(SeckillOrder seckillOrder);

    SeckillOrder findById(Integer id);

    void add(SeckillOrder seckillOrder);

    void update(SeckillOrder seckillOrder);

    void delete(Integer id);

}

