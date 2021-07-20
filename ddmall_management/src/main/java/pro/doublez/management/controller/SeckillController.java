package pro.doublez.management.controller;

import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.web.bind.annotation.*;
import pro.doublez.ddmall_api.constant.StatusCode;
import pro.doublez.ddmall_api.dto.ResultDto;
import pro.doublez.ddmall_api.pojo.SeckillGoods;
import pro.doublez.management.feign.GoodsFeign;

import javax.annotation.Resource;
import java.util.Date;
import java.util.concurrent.TimeUnit;

/**
 * @author doublez
 * @version 1.0
 * @date 2021/7/20 15:31
 */
@RestController
@CrossOrigin
public class SeckillController {

    @Resource
    RedisTemplate<String, Integer> redisTemplate;
    private final GoodsFeign goodsFeign;

    public SeckillController(GoodsFeign goodsFeign) {
        this.goodsFeign = goodsFeign;
    }

    //查询所有秒杀商品
    @GetMapping("/all_seckill")
    public ResultDto<SeckillGoods[]> findAllSeckill() {
        SeckillGoods[] goods = goodsFeign.findAllSeckill();
        ResultDto<SeckillGoods[]> dto = new ResultDto<>();
        dto.setBean(goods).setCode(StatusCode.OK).setMsg("查询成功");
        return dto;
    }

    //根据id查询秒杀商品
    @GetMapping("/find_seckill_by_id/{id}")
    public ResultDto<SeckillGoods> findSeckillById(@PathVariable long id) {
        SeckillGoods goods = goodsFeign.findSeckillById(id);
        ResultDto<SeckillGoods> dto = new ResultDto<>();
        dto.setBean(goods).setCode(StatusCode.OK).setMsg("查询成功");
        return dto;
    }

    //根据名称查询秒杀商品
    @GetMapping("/find_seckill_by_name/{name}")
    public ResultDto<SeckillGoods[]> findSeckillByName(@PathVariable String name) {
        SeckillGoods[] goods = goodsFeign.findSeckillByName(name);
        ResultDto<SeckillGoods[]> dto = new ResultDto<>();
        dto.setBean(goods).setCode(StatusCode.OK).setMsg("查询成功");
        return dto;
    }

    //添加秒杀商品
    @PutMapping("/add_seckill_goods/{name}/{price}/{count}")
    public ResultDto<SeckillGoods> addSeckillGoods(@PathVariable String name, @PathVariable double price,
                                                   @PathVariable int count) {
        SeckillGoods seckillGoods = goodsFeign.addSeckillGoods(name, price, count);
        ResultDto<SeckillGoods> dto = new ResultDto<>();
        if (seckillGoods != null) {
            dto.setBean(seckillGoods).setCode(StatusCode.OK).setMsg("添加成功");
        } else {
            dto.setBean(null).setCode(StatusCode.GOODSERROR).setMsg("添加失败");
        }
        return dto;
    }

    //修改秒杀商品的开始时间和结束时间
    @PostMapping("/change_seckill_goods_time/{startOrEnd}/{id}/{year}/{month}/{day}/{hour}/{minute}/{second}")
    public ResultDto<Date> changeSeckillGoodsTime(@PathVariable int startOrEnd, @PathVariable long id,
                                                  @PathVariable String year, @PathVariable String month,
                                                  @PathVariable String day, @PathVariable String hour,
                                                  @PathVariable String minute, @PathVariable String second) {
        Date date = goodsFeign.changeSeckillGoodsTime(startOrEnd, id, year, month, day, hour, minute, second);
        ResultDto<Date> dto = new ResultDto<>();
        if (date != null) {
            dto.setBean(date).setCode(StatusCode.OK).setMsg("修改成功");
        } else {
            dto.setBean(null).setCode(StatusCode.SECKILLERROR).setMsg("修改失败");
        }
        return dto;
    }

    //修改秒杀商品的库存
    @PostMapping("/change_seckill_goods_count/{id}/{count}")
    public ResultDto<Boolean> changeSeckillGoodsCount(@PathVariable long id, @PathVariable int count) {
        Integer flag = goodsFeign.changeSeckillGoodsCount(id, count);
        ResultDto<Boolean> dto = new ResultDto<>();
        if (flag > 0) {
            dto.setBean(true).setCode(StatusCode.OK).setMsg("修改成功");
        } else {
            dto.setBean(false).setCode(StatusCode.SECKILLERROR).setMsg("修改失败");
        }
        return dto;
    }

    //将在售的秒杀商品加入redis缓存
    @PutMapping("/add_on_sale_to_cache")
    public ResultDto<Boolean> addOnSaleToCache() {
        SeckillGoods[] allGoods = goodsFeign.findAllSeckillOnSale();
        ValueOperations<String, Integer> operations = redisTemplate.opsForValue();
        for (SeckillGoods goods : allGoods) {
            long endTime = goods.getEndTime().getTime();
            long id = goods.getId();
            int count = goods.getCount();
            String key = "seckill-goods " + id;
            redisTemplate.delete(key);
            operations.set(key, count, endTime - new Date().getTime() - 8 * 60 * 60 * 1000, TimeUnit.MILLISECONDS);
        }
        return new ResultDto<Boolean>().setBean(true).setCode(StatusCode.OK).setMsg("成功添加到缓存");
    }
}
