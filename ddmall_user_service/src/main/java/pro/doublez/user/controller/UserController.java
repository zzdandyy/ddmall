package pro.doublez.user.controller;

import org.springframework.web.bind.annotation.*;
import pro.doublez.user.pojo.User;
import pro.doublez.user.service.UserService;

/**
 * @author doublez
 * @version 1.0
 * @date 2021/7/17 16:24
 */
@RestController
@CrossOrigin
@RequestMapping("/user")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    //注册
    @PutMapping("/register")
    public Integer register(@RequestParam String username, @RequestParam String password) {
        User usered = userService.findUserByUsername(username);
        if (usered != null) {
            return 0;
        } else {
            User user = new User();
            user.setUsername(username).setPassword(password).setId(0);
            return userService.register(user);
        }
    }

    //登录
    @PostMapping("/login")
    public User login(@RequestParam String username, @RequestParam String password) {
        return userService.login(username, password);
    }

    //修改密码
    @PostMapping("/change_password/{username}")
    public Integer changePassword(@PathVariable String username, @RequestParam String password,
                                  @RequestParam String newPassword) {
        return userService.changePassword(username, password, newPassword);
    }

    //根据id获取User
    @GetMapping("/find_user_by_id/{id}")
    public User findUserById(@PathVariable int id) {
        return userService.findUserById(id);
    }

    //根据id获取name
    @GetMapping("/find_name_by_id/{id}")
    public String findUsernameById(@PathVariable int id) {
        return userService.findNameById(id);
    }
}
