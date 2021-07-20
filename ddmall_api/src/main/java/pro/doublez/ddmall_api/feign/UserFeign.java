package pro.doublez.ddmall_api.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;
import pro.doublez.ddmall_api.pojo.User;

/**
 * @author doublez
 * @version 1.0
 * @date 2021/7/17 16:57
 */
@FeignClient("user")
public interface UserFeign {
    //注册
    @PutMapping("/user/register")
    public Integer register(@RequestParam String username, @RequestParam String password);

    //登录
    @PostMapping("/user/login")
    public User login(@RequestParam String username, @RequestParam String password);

    //修改密码
    @PostMapping("/user/change_password/{username}")
    public Integer changePassword(@PathVariable String username, @RequestParam String password,
                                  @RequestParam String newPassword);

    //根据id获取User
    @GetMapping("/user/find_user_by_id/{id}")
    public User findUserById(@PathVariable int id);

    //根据id获取name
    @GetMapping("/user/find_name_by_id/{id}")
    public String findUsernameById(@PathVariable int id);

    //查找所有用户
    @GetMapping("user/find_all_user")
    public User[] findAllUser();
}
