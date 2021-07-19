package pro.doublez.common.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;
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
}
