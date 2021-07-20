package pro.doublez.management.controller;

import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;
import pro.doublez.management.feign.AdminFeign;
import pro.doublez.management.feign.GoodsFeign;
import pro.doublez.management.feign.OrderFeign;
import pro.doublez.management.feign.UserFeign;

import javax.annotation.Resource;

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
    private final UserFeign userFeign;
    private final AdminFeign adminFeign;


    public ManagementController(GoodsFeign goodsFeign, OrderFeign orderFeign, UserFeign userFeign,
                                AdminFeign adminFeign) {
        this.goodsFeign = goodsFeign;
        this.orderFeign = orderFeign;
        this.userFeign = userFeign;
        this.adminFeign = adminFeign;
    }




}
