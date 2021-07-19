package pro.doublez.personal.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import pro.doublez.ddmall_api.constant.StatusCode;
import pro.doublez.ddmall_api.dto.ResultDto;
import pro.doublez.ddmall_api.utils.TokenUtil;
import pro.doublez.personal.feign.UserFeign;


import javax.servlet.http.HttpServletRequest;

/**
 * @author doublez
 * @version 1.0
 * @date 2021/7/18 15:31
 */
@RestController
@CrossOrigin
public class PersonalController {

    private final UserFeign userFeign;

    public PersonalController(UserFeign userFeign) {
        this.userFeign = userFeign;
    }

    //修改密码
    @PostMapping("/change_password")
    public ResultDto<Boolean> changePassword(@RequestParam String password, @RequestParam String newPassword,
                                             HttpServletRequest request) {
        ResultDto<Boolean> dto = new ResultDto<>();
        String jwt = request.getHeader("user-token");
        int id = TokenUtil.getUid(jwt);
        String usernameById = userFeign.findUsernameById(id);
        Integer flag = userFeign.changePassword(usernameById, password, newPassword);
        if (flag == 1) {
            dto.setBean(true).setCode(StatusCode.OK).setMsg("修改成功，请重新登陆");
        } else {
            dto.setBean(false).setCode(StatusCode.USERERROR).setMsg("修改失败");
        }
        return dto;
    }
}
