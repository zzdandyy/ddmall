package pro.doublez.common.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import pro.doublez.ddmall_api.pojo.Admin;


/**
 * @author doublez
 * @version 1.0
 * @date 2021/7/17 16:57
 */
@FeignClient("system")
public interface AdminFeign {
    //管理员登录
    @PostMapping("/admin/login")
    public Admin login(@RequestParam String adminname, @RequestParam String password);
}
