package pro.doublez.system.controller;


import org.springframework.web.bind.annotation.*;
import pro.doublez.system.pojo.Admin;
import pro.doublez.system.service.AdminService;

/**
 * @author doublez
 * @version 1.0
 * @date 2021/7/11 22:21
 */
@CrossOrigin
@RestController
@RequestMapping("/admin")
public class AdminController {

    private final AdminService adminService;

    public AdminController(AdminService adminService) {
        this.adminService = adminService;

    }

    //管理员登录
    @PostMapping("/login")
    public Admin login(@RequestParam String adminname, @RequestParam String password) {
        return adminService.login(adminname, password);
    }
}
