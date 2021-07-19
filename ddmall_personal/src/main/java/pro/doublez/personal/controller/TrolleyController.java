package pro.doublez.personal.controller;

import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.*;

import pro.doublez.ddmall_api.bean.TrolleyGoods;
import pro.doublez.ddmall_api.constant.StatusCode;
import pro.doublez.ddmall_api.dto.ResultDto;
import pro.doublez.ddmall_api.pojo.Goods;
import pro.doublez.ddmall_api.utils.BaseException;
import pro.doublez.ddmall_api.utils.TokenUtil;
import pro.doublez.personal.feign.GoodsFeign;


import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.Map;
import java.util.Set;

/**
 * @author doublez
 * @version 1.0
 * @date 2021/7/18 20:20
 */
@RestController
@CrossOrigin
public class TrolleyController {

    @Resource
    RedisTemplate<String, Object> redisTemplate;

    private final GoodsFeign goodsFeign;

    public TrolleyController(GoodsFeign goodsFeign) {
        this.goodsFeign = goodsFeign;
    }

    //查看购物车
    @GetMapping("/find_trolley")
    public ResultDto<ArrayList<TrolleyGoods>> findTrolley(HttpServletRequest request) {
        HashOperations<String, String, Integer> operations = redisTemplate.opsForHash();
        String jwt = request.getHeader("user-token");
        int uid = TokenUtil.getUid(jwt);
        String key = "shopping-trolley-" + uid;
        ArrayList<TrolleyGoods> res = new ArrayList<>();
        ArrayList<Long> delGoods = new ArrayList<>();
        Map<String, Integer> map = operations.entries(key);
        Set<Map.Entry<String, Integer>> entries = map.entrySet();
        for (Map.Entry<String, Integer> entry : entries) {
            long gid = Long.parseLong(entry.getKey());
            int num = entry.getValue();
            Goods goods = goodsFeign.findGoodsByIdPutaway(gid);
            if (goods != null) {
                TrolleyGoods forGoods = new TrolleyGoods(gid, goods.getName(), num * goods.getPrice(), num);
                res.add(forGoods);
            } else {
                delGoods.add(gid);
            }
        }
        for (Long delGid : delGoods) {
            operations.delete(key, String.valueOf(delGid));
        }
        ResultDto<ArrayList<TrolleyGoods>> dto = new ResultDto<>();
        dto.setBean(res).setCode(StatusCode.OK).setMsg("查询成功");
        return dto;
    }

    //添加商品到购物车
    @PutMapping("/add_trolley/{gid}/{count}")
    public ResultDto<Long> addShopping(@PathVariable long gid, @PathVariable int count,
                                       HttpServletRequest request) {
        return upTrolleyCount(gid, count, request);
    }

    //增加购物车商品数量
    @PostMapping("/up_trolley_count/{gid}/{count}")
    public ResultDto<Long> upTrolleyCount(@PathVariable long gid, @PathVariable int count,
                                          HttpServletRequest request) {
        String jwt = request.getHeader("user-token");
        int uid = TokenUtil.getUid(jwt);
        HashOperations<String, String, Integer> operations = redisTemplate.opsForHash();
        String key = "shopping-trolley-" + uid;
        String gKey = String.valueOf(gid);
        Long flag = operations.increment(key, gKey, count);
        ResultDto<Long> dto = new ResultDto<>();
        dto.setBean(flag).setCode(StatusCode.OK).setMsg("增加成功");
        return dto;
    }

    //减少购物车商品数量
    @PostMapping("/down_trolley_count/{gid}/{count}")
    public ResultDto<Long> downTrolleyCount(@PathVariable long gid, @PathVariable int count,
                                            HttpServletRequest request) {
        String jwt = request.getHeader("user-token");
        int uid = TokenUtil.getUid(jwt);
        HashOperations<String, String, Integer> operations = redisTemplate.opsForHash();
        String key = "shopping-trolley-" + uid;
        String gKey = String.valueOf(gid);
        ResultDto<Long> dto = new ResultDto<>();
        Integer num = operations.get(key, gKey);
        if (num == null || num <= 1) {
            throw new BaseException(StatusCode.SHOPPINGERROR, "减少失败");
        }
        Long flag = operations.increment(key, gKey, -count);
        dto.setBean(flag).setCode(StatusCode.OK).setMsg("减少成功");
        return dto;
    }

    //删除购物车商品
    @DeleteMapping("/delete_trolley/{gid}")
    public ResultDto<Long> deleteTrolley(@PathVariable long gid, HttpServletRequest request) {
        String jwt = request.getHeader("user-token");
        int uid = TokenUtil.getUid(jwt);
        HashOperations<String, String, Integer> operations = redisTemplate.opsForHash();
        String key = "shopping-trolley-" + uid;
        String gKey = String.valueOf(gid);
        Long flag = operations.delete(key, gKey);
        ResultDto<Long> dto = new ResultDto<>();
        if (flag == 0) {
            throw new BaseException(StatusCode.SHOPPINGERROR, "商品不存在");
        }
        dto.setBean(flag).setCode(StatusCode.OK).setMsg("删除成功");
        return dto;
    }
}
