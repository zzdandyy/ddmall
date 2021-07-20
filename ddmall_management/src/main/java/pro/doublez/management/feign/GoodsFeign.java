package pro.doublez.management.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;
import pro.doublez.ddmall_api.pojo.Goods;
import pro.doublez.ddmall_api.pojo.SeckillGoods;

import java.util.Date;


/**
 * @author doublez
 * @version 1.0
 * @date 2021/7/17 16:57
 */
@FeignClient("goods")
public interface GoodsFeign {
    //查询所有上架商品
    @GetMapping("/goods/all_putaway")
    Goods[] findAllPutaway();

    //根据商品名称查询上架商品
    @GetMapping("/goods/name_putaway/{name}")
    Goods[] findGoodsByNamePutaway(@PathVariable String name);

    //根据商品id查询上架商品
    @GetMapping("/goods/id_putaway/{id}")
    Goods findGoodsByIdPutaway(@PathVariable long id);

    //查询所有商品
    @GetMapping("/goods/all")
    Goods[] findAll();

    //根据商品名称查询商品
    @GetMapping("/goods/name/{name}")
    Goods[] findGoodsByName(@PathVariable String name);

    //根据商品id查询商品
    @GetMapping("/goods/id/{id}")
    Goods findGoodsById(@PathVariable long id);

    //根据商品id查询商品库存
    @GetMapping("/goods/find_count_by_id/{id}")
    Integer findGoodsCountById(@PathVariable long id);

    //根据商品id查询商品名称
    @GetMapping("/goods/find_name_by_id/{id}")
    String findGoodsNameById(@PathVariable long id);

    //添加商品
    @PutMapping("/goods/add/{name}/{price}/{count}")
    Integer addGoods(@PathVariable String name, @PathVariable double price, @PathVariable int count);

    //上架商品
    @PostMapping("/goods/up/{id}")
    Integer upGoods(@PathVariable long id);

    //下架商品
    @PostMapping("/goods/down/{id}")
    Integer downGoods(@PathVariable long id);

    //删除商品
    @PostMapping("/goods/delete/{id}")
    Integer deleteGoods(@PathVariable long id);

    //恢复商品
    @PostMapping("/goods/recover/{id}")
    Integer RecoverGoods(@PathVariable long id);

    //修改商品价格
    @PostMapping("/goods/change_price/{price}/{id}")
    Integer changeGoodsPrice(@PathVariable double price, @PathVariable long id);

    //修改商品库存
    @PostMapping("/goods/change_count/{count}/{id}")
    Integer changeGoodsCount(@PathVariable int count, @PathVariable long id);

    //增加商品库存
    @PostMapping("/goods/up_count/{upCount}/{id}")
    Integer upGoodsCount(@PathVariable int upCount, @PathVariable long id);

    //减少商品库存
    @PostMapping("/goods/down_count/{downCount}/{id}")
    Integer downGoodsCount(@PathVariable int downCount, @PathVariable long id);

    //移除所有删除状态的商品
    @DeleteMapping("/goods/delete_all_in_del")
    Integer deleteGoods();

    //用户查询所有秒杀商品
    @GetMapping("/seckillGoods/all_seckill_sale")
    public SeckillGoods[] findAllSeckillOnSale();

    //用户根据id查询秒杀商品
    @GetMapping("/seckillGoods/find_seckill_sale_by_id/{id}")
    public SeckillGoods findSeckillOnSaleById(@PathVariable long id);

    //用户根据名称查询秒杀商品
    @GetMapping("/seckillGoods/find_seckill_sale_by_name/{name}")
    public SeckillGoods[] findSeckillOnSaleByName(@PathVariable String name) ;

    //查询所有秒杀商品
    @GetMapping("/seckillGoods/all_seckill")
    public SeckillGoods[] findAllSeckill();

    //根据id查询秒杀商品
    @GetMapping("/seckillGoods/find_seckill_by_id/{id}")
    public SeckillGoods findSeckillById(@PathVariable long id);

    //根据名称查询秒杀商品
    @GetMapping("/seckillGoods/find_seckill_by_name/{name}")
    public SeckillGoods[] findSeckillByName(@PathVariable String name);

    //减少秒杀商品库存
    @PostMapping("/seckillGoods/down_seckill_count/{count}/{secId}")
    public Integer downSeckillCount(@PathVariable int count,@PathVariable long secId);

    //添加秒杀商品
    @PutMapping("/seckillGoods/add_seckill_goods/{name}/{price}/{count}")
    public SeckillGoods addSeckillGoods(@PathVariable String name, @PathVariable double price,
                                        @PathVariable int count);

    //修改秒杀商品的开始时间和结束时间
    @PostMapping("/seckillGoods/change_seckill_goods_time/{startOrEnd}/{id}/{year}/{month}/{day}/{hour}/{minute}/{second}")
    public Date changeSeckillGoodsTime(@PathVariable int startOrEnd, @PathVariable long id,
                                       @PathVariable String year, @PathVariable String month,
                                       @PathVariable String day, @PathVariable String hour,
                                       @PathVariable String minute, @PathVariable String second);
    //修改秒杀商品的库存
    @PostMapping("/seckillGoods/change_seckill_goods_count/{id}/{count}")
    public Integer changeSeckillGoodsCount(@PathVariable long id, @PathVariable int count);
}
