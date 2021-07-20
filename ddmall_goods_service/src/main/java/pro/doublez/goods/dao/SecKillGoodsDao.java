package pro.doublez.goods.dao;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import pro.doublez.goods.pojo.SeckillGoods;

import java.util.Date;

/**
 * @author doublez
 * @version 1.0
 * @date 2021/7/15 21:22
 */
@Mapper
public interface SecKillGoodsDao {

    @Select("select * from tb_seckill_goods")
    SeckillGoods[] findAll();

    @Select("select * from tb_seckill_goods where id=#{id}")
    SeckillGoods findAllById(long id);

    @Select("select * from tb_seckill_goods where name =#{name}")
    SeckillGoods[] findAllByName(String name);

    @Select("select count from tb_seckill_goods where id = #{id}")
    Integer findCountById(long id);

    @Select("select * from tb_seckill_goods where #{curTime} > startTime and #{curTime} < endTime")
    SeckillGoods[] findAllOnSale(Date curTime);

    @Select("select * from tb_seckill_goods where id=#{id} and #{curTime} > startTime and #{curTime} < endTime")
    SeckillGoods findAllByIdOnSale(long id, Date curTime);

    @Select("select * from tb_seckill_goods where name =#{name} and #{curTime} > startTime and #{curTime} < endTime")
    SeckillGoods[] findAllByNameOnSale(String name, Date curTime);

    @Insert("insert into tb_seckill_goods (id,name,price,count,startTime,endTime) " +
            "values (#{id},#{name},#{price},#{count},#{startTime},#{endTime})")
    Integer addGoods(SeckillGoods seckillGoodsBean);

    @Update("update tb_seckill_goods set startTime = #{date} where id =#{id}")
    Integer changeStartTime(Date date, long id);

    @Update("update tb_seckill_goods set EndTime = #{date} where id =#{id}")
    Integer changeEndTime(Date date, long id);

    @Update("update tb_seckill_goods set count = #{count} where id =#{id}")
    Integer changeSeckillGoodsCount(int count,long id);

    @Update("update tb_seckill_goods set count = count - #{downCount} where id =#{id}")
    Integer downCount(int downCount, long id);
}
