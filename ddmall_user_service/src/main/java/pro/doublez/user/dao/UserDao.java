package pro.doublez.user.dao;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import pro.doublez.user.pojo.User;

/**
 * @author doublez
 * @version 1.0
 * @date 2021/7/11 14:19
 */
@Mapper
public interface UserDao {

    @Select("select * from tb_user")
    User[] findAllUser();

    @Select("select * from tb_user where username = #{username}")
    User findUserByUsername(String username);

    @Select("select * from tb_user where id=#{id}")
    User findUserById(int id);

    @Select("select name from tb_user where id=#{id}")
    String findNameById(int id);

    @Insert("insert into tb_user (username,password) values (#{username},#{password})")
    Integer addUser(User userBean);

    @Update("update tb_user set password = #{newPassword} where username = #{username}")
    Integer changePassword(String newPassword, String username);
}
