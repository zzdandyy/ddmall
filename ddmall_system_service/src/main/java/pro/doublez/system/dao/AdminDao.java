package pro.doublez.system.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import pro.doublez.system.pojo.Admin;

/**
 * @author doublez
 * @version 1.0
 * @date 2021/7/11 22:21
 */
@Mapper
public interface AdminDao {
    @Select("select * from tb_admin where adminname = #{adminname}")
    Admin findAdmin(String adminname);
}
