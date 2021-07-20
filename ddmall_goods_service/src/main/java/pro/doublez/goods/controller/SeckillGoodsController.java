package pro.doublez.goods.controller;

import org.springframework.web.bind.annotation.*;
import pro.doublez.goods.pojo.SeckillGoods;
import pro.doublez.goods.service.SeckillGoodsService;
import pro.doublez.goods.utils.IdWorker;
import pro.doublez.goods.utils.TimeUtil;

import java.util.Date;

/**
 * @author doublez
 * @version 1.0
 * @date 2021/7/20 14:24
 */
@RestController
@CrossOrigin
@RequestMapping("/seckillGoods")
public class SeckillGoodsController {

    private final SeckillGoodsService seckillGoodsService;

    public SeckillGoodsController(SeckillGoodsService seckillGoodsService) {
        this.seckillGoodsService = seckillGoodsService;
    }

    //用户查询所有秒杀商品
    @GetMapping("/all_seckill_sale")
    public SeckillGoods[] findAllSeckillOnSale() {
        return seckillGoodsService.findAllOnSale();
    }

    //用户根据id查询秒杀商品
    @GetMapping("/find_seckill_sale_by_id/{id}")
    public SeckillGoods findSeckillOnSaleById(@PathVariable long id) {
        return seckillGoodsService.findAllByIdOnSale(id);
    }

    //用户根据名称查询秒杀商品
    @GetMapping("/find_seckill_sale_by_name/{name}")
    public SeckillGoods[] findSeckillOnSaleByName(@PathVariable String name) {
        return seckillGoodsService.findAllByNameOnSale(name);
    }

    //查询所有秒杀商品
    @GetMapping("/all_seckill")
    public SeckillGoods[] findAllSeckill() {
        return seckillGoodsService.findAll();
    }

    //根据id查询秒杀商品
    @GetMapping("/find_seckill_by_id/{id}")
    public SeckillGoods findSeckillById(@PathVariable long id) {
        return seckillGoodsService.findAllById(id);
    }

    //根据名称查询秒杀商品
    @GetMapping("/find_seckill_by_name/{name}")
    public SeckillGoods[] findSeckillByName(@PathVariable String name) {
        return seckillGoodsService.findAllByName(name);
    }

    //减少秒杀商品库存
    @PostMapping("/down_seckill_count/{count}/{secId}")
    public Integer downSeckillCount(@PathVariable int count,@PathVariable long secId){
        return seckillGoodsService.downCount(count,secId);
    }

    //添加秒杀商品
    @PutMapping("/add_seckill_goods/{name}/{price}/{count}")
    public SeckillGoods addSeckillGoods(@PathVariable String name, @PathVariable double price,
                                        @PathVariable int count) {
        SeckillGoods seckillGoods = new SeckillGoods();
        seckillGoods.setId(new IdWorker().nextId());
        seckillGoods.setName(name);
        seckillGoods.setPrice(price);
        seckillGoods.setCount(count);
        //默认该商品秒杀开始时间为一小时之后，持续时间为一小时
        Date startDate = new Date();
        long cur = startDate.getTime();
        startDate.setTime(cur + (9000 * 60 * 60));
        seckillGoods.setStartTime(startDate);
        Date endDate = new Date();
        endDate.setTime(cur + (10000 * 60 * 60));
        seckillGoods.setEndTime(endDate);
        Integer flag = seckillGoodsService.addGoods(seckillGoods);
        if (flag > 0) {
            return seckillGoods;
        } else {
            return null;
        }
    }

    //修改秒杀商品的开始时间和结束时间
    @PostMapping("/change_seckill_goods_time/{startOrEnd}/{id}/{year}/{month}/{day}/{hour}/{minute}/{second}")
    public Date changeSeckillGoodsTime(@PathVariable int startOrEnd, @PathVariable long id,
                                       @PathVariable String year, @PathVariable String month,
                                       @PathVariable String day, @PathVariable String hour,
                                       @PathVariable String minute, @PathVariable String second) {
        Date startDate = TimeUtil.getDate(year, month, day, hour, minute, second);
        Integer flag = 0;
        if (startOrEnd == 0) {
            flag = seckillGoodsService.changeStartTime(startDate, id);
        } else if (startOrEnd == 1) {
            flag = seckillGoodsService.changeEndTime(startDate, id);
        }
        if (flag > 0) {
            return startDate;
        } else {
            return null;
        }
    }

    //修改秒杀商品的库存
    @PostMapping("/change_seckill_goods_count/{id}/{count}")
    public Integer changeSeckillGoodsCount(@PathVariable long id, @PathVariable int count) {
        return seckillGoodsService.changeSeckillGoodsCount(count, id);
    }
}
