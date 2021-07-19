package pro.doublez.management.controller;

import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.*;
import pro.doublez.ddmall_api.bean.ShowOrder;
import pro.doublez.ddmall_api.constant.StatusCode;
import pro.doublez.ddmall_api.dto.ResultDto;
import pro.doublez.ddmall_api.pojo.Goods;
import pro.doublez.ddmall_api.pojo.Order;
import pro.doublez.ddmall_api.utils.BaseException;
import pro.doublez.ddmall_api.utils.TokenUtil;
import pro.doublez.management.feign.GoodsFeign;
import pro.doublez.management.feign.OrderFeign;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

/**
 * @author doublez
 * @version 1.0
 * @date 2021/7/19 16:15
 */
@RestController
@CrossOrigin
public class ManagementController {

    @Resource
    RedisTemplate<String, Object> redisTemplate;

    private final GoodsFeign goodsFeign;
    private final OrderFeign orderFeign;


    public ManagementController(GoodsFeign goodsFeign, OrderFeign orderFeign) {
        this.goodsFeign = goodsFeign;
        this.orderFeign = orderFeign;
    }


}
