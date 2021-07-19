package pro.doublez.personal.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;
import pro.doublez.ddmall_api.pojo.Goods;


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
}
