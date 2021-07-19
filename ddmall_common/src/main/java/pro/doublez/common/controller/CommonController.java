package pro.doublez.common.controller;

import org.springframework.web.bind.annotation.*;
import pro.doublez.common.feign.GoodsFeign;
import pro.doublez.common.feign.UserFeign;
import pro.doublez.ddmall_api.constant.StatusCode;
import pro.doublez.ddmall_api.dto.ResultDto;
import pro.doublez.ddmall_api.pojo.Goods;
import pro.doublez.ddmall_api.pojo.User;
import pro.doublez.ddmall_api.utils.JwtUtil;


import javax.servlet.http.HttpServletResponse;
import java.util.Date;

/**
 * @author doublez
 * @version 1.0
 * @date 2021/7/18 15:31
 */
@RestController
@CrossOrigin
public class CommonController {

    private final UserFeign userFeign;
    private final GoodsFeign goodsFeign;

    public CommonController(UserFeign userFeign, GoodsFeign goodsFeign) {
        this.userFeign = userFeign;
        this.goodsFeign = goodsFeign;
    }

    //注册
    @PutMapping("/register")
    public ResultDto<Boolean> register(@RequestParam String username, @RequestParam String password) {

        ResultDto<Boolean> dto = new ResultDto<>();
        Integer flag = userFeign.register(username, password);
        System.out.println(flag);
        if (flag == 0) {
            dto.setBean(false).setCode(StatusCode.USERERROR).setMsg("用户名已存在");
        } else {
            dto.setBean(true).setCode(StatusCode.OK).setMsg("注册成功");
        }
        return dto;
    }

    //登录
    @PostMapping("/login")
    public ResultDto<Boolean> login(@RequestParam String username, @RequestParam String password,
                                    HttpServletResponse response) {
        ResultDto<Boolean> dto = new ResultDto<>();
        User user = userFeign.login(username, password);
        if (user == null) {
            dto.setBean(false).setCode(StatusCode.USERERROR).setMsg("用户名或密码错误");
        } else {
            Integer id = user.getId();
            String s = String.valueOf(new Date().getTime());
            dto.setBean(true).setCode(StatusCode.OK).setMsg("登录成功");
            String jwt = JwtUtil.createJWT(s, id.toString(),JwtUtil.JWT_TTL);
            response.setHeader("user-token", jwt);
        }
        return dto;
    }

    //查找所有商品
    @GetMapping("/find_all_goods")
    public ResultDto<Goods[]> findAllGoods() {
        ResultDto<Goods[]> dto = new ResultDto<>();
        Goods[] allPutaway = goodsFeign.findAllPutaway();
        dto.setBean(allPutaway).setCode(StatusCode.OK).setMsg("查找成功");
        return dto;
    }

    //根据id查找商品
    @GetMapping("/find_goods_id/{id}")
    public ResultDto<Goods> findGoodsById(@PathVariable long id) {
        ResultDto<Goods> dto = new ResultDto<>();
        Goods goods = goodsFeign.findGoodsByIdPutaway(id);
        dto.setBean(goods).setCode(StatusCode.OK).setMsg("查找成功");
        return dto;
    }

    //根据商品名称查找商品
    @GetMapping("/find_goods_name/{name}")
    public ResultDto<Goods[]> findGoodsByName(@PathVariable String name) {
        ResultDto<Goods[]> dto = new ResultDto<>();
        Goods[] goodsByName = goodsFeign.findGoodsByName(name);
        dto.setBean(goodsByName).setCode(StatusCode.OK).setMsg("查找成功");
        return dto;
    }
}