package pro.doublez.goods.dao;

import org.apache.ibatis.annotations.*;
import pro.doublez.goods.pojo.Goods;


/**
 * @author doublez
 * @version 1.0
 * @date 2021/7/12 15:37
 */
@Mapper
public interface GoodsDao {
    @Select("select * from tb_goods")
    Goods[] findAllGoods();

    @Select("select * from tb_goods where name = #{name}")
    Goods[] findGoodsByName(String name);

    @Select("select * from tb_goods where id = #{id}")
    Goods findGoodsById(long id);

    @Select("select * from tb_goods where status>0")
    Goods[] findAllGoodsToUser();

    @Select("select * from tb_goods where name = #{name} and status>0")
    Goods[] findGoodsByNameToUser(String name);

    @Select("select * from tb_goods where id = #{id} and status>0")
    Goods findGoodsByIdToUser(long id);

    @Select("select count from tb_goods where id=#{id}")
    Integer findCountById(long id);

    @Select("select name from tb_goods where id=#{id}")
    String findNameById(long id);

    @Insert("insert into tb_goods (id,name,price,count,status) values (#{id},#{name},#{price},#{count},#{status})")
    Integer addGoods(Goods goodsBean);

    @Update("update tb_goods set price = #{price} where id = #{id}")
    Integer changeGoodsPrice(double price, long id);

    @Update("update tb_goods set status = #{status} where id = #{id}")
    Integer changeGoodsStatus(int status, long id);

    @Update("update tb_goods set count = #{count} where id = #{id}")
    Integer changeGoodsCount(int count, long id);

    @Update("update tb_goods set count = count+#{upCount} where id = #{id}")
    Integer upGoodsCount(int upCount, long id);

    @Update("update tb_goods set count = count-#{downCount} where id = #{id}")
    Integer downGoodsCount(int downCount, long id);

    @Delete("delete from tb_goods where id = #{id}")
    Integer deleteGoodsById(long id);
}
