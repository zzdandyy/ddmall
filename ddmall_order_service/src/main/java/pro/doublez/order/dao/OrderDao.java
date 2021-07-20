package pro.doublez.order.dao;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import pro.doublez.order.pojo.Order;

/**
 * @author doublez
 * @version 1.0
 * @date 2021/7/13 12:33
 */
@Mapper
public interface OrderDao {

    @Select("select * from tb_order where status = 1")
    Order[] findAllOrderIsPay();

    @Select("select * from tb_order where uid = #{uid}")
    Order[] findUserAllOrder(int uid);

    @Select("select * from tb_order where uid = #{uid} and status !=-1")
    Order[] findUserAllOrderNoCancel(int uid);

    @Select("select * from tb_order where uid = #{uid} and status = 0")
    Order[] findUserAllOrderNoCancelNoPay(int uid);

    @Select("select * from tb_order where uid = #{uid} and status = 1")
    Order[] findUserAllOrderNoCancelPay(int uid);

    @Select("select * from tb_order where id = #{id}")
    Order findOrderById(long id);

    @Select("select count(*) from tb_order where uid = #{uid} and status = 0 and form = 2")
    Integer findSelfSeckillNum(int uid);

    @Select("select status from tb_order where id = #{id}")
    Integer findStatusById(long id);

    @Select("select form from tb_order where id = #{id}")
    Integer findFormById(long id);

    @Select("select * from tb_order where status = 1")
    Order[] findAllPayOrder();

    @Insert("insert into tb_order (id,uid,gid,count,totalPrice,form) " +
            "values (#{id},#{uid},#{gid},#{count},#{totalPrice},#{form})")
    Integer addOrder(Order orderBean);

    @Update("update tb_order set status = -1 where id = #{id}")
    Integer cancelOrder(long id);

    @Update("update tb_order set status = 1 where id = #{id}")
    Integer payOrder(long id);

}
