package pro.doublez.goods.controller;

import org.springframework.web.bind.annotation.*;
import pro.doublez.goods.pojo.Goods;
import pro.doublez.goods.service.GoodsService;
import pro.doublez.goods.utils.IdWorker;

/**
 * @author doublez
 * @version 1.0
 * @date 2021/7/12 16:42
 */
@RestController
@CrossOrigin
@RequestMapping("/goods")
public class GoodsController {

    private final GoodsService goodsService;

    public GoodsController(GoodsService goodsService) {
        this.goodsService = goodsService;
    }

    //查询所有上架商品
    @GetMapping("/all_putaway")
    public Goods[] findAllPutaway() {
        return goodsService.findAllGoodsToUser();
    }

    //根据商品名称查询上架商品
    @GetMapping("/name_putaway/{name}")
    public Goods[] findGoodsByNamePutaway(@PathVariable String name) {
        return goodsService.findGoodsByNameToUser(name);
    }

    //根据商品id查询上架商品
    @GetMapping("/id_putaway/{id}")
    public Goods findGoodsByIdPutaway(@PathVariable long id) {
        return goodsService.findGoodsByIdToUser(id);
    }

    //查询所有商品
    @GetMapping("/all")
    public Goods[] findAll() {
        return goodsService.findAllGoods();
    }

    //根据商品名称查询商品
    @GetMapping("/name/{name}")
    public Goods[] findGoodsByName(@PathVariable String name) {
        return goodsService.findGoodsByName(name);
    }

    //根据商品id查询商品
    @GetMapping("/id/{id}")
    public Goods findGoodsById(@PathVariable long id) {
        return goodsService.findGoodsById(id);
    }

    //根据商品id查询商品库存
    @GetMapping("/find_count_by_id/{id}")
    public Integer findGoodsCountById(@PathVariable long id){
        return goodsService.findCountById(id);
    }

    //根据商品id查询商品库存
    @GetMapping("/find_name_by_id/{id}")
    public String findGoodsNameById(@PathVariable long id){
        return goodsService.findNameById(id);
    }

    //添加商品
    @PutMapping("/add/{name}/{price}/{count}")
    public Integer addGoods(@PathVariable String name, @PathVariable double price,
                            @PathVariable int count) {
        Goods goods = new Goods();
        goods.setId(new IdWorker().nextId());
        goods.setName(name);
        goods.setPrice(price);
        goods.setCount(count);
        return goodsService.addGoods(goods);
    }

    //上架商品
    @PostMapping("/up/{id}")
    public Integer upGoods(@PathVariable long id) {
        return goodsService.changeGoodsStatus(Goods.PUTAWAY, id);
    }

    //下架商品
    @PostMapping("/down/{id}")
    public Integer downGoods(@PathVariable long id) {
        return goodsService.changeGoodsStatus(Goods.NOPUTAWAY, id);
    }

    //删除商品
    @PostMapping("/delete/{id}")
    public Integer deleteGoods(@PathVariable long id) {
        return goodsService.changeGoodsStatus(Goods.DELETE, id);
    }

    //恢复商品
    @PostMapping("/recover/{id}")
    public Integer RecoverGoods(@PathVariable long id) {
        return goodsService.changeGoodsStatus(Goods.NOPUTAWAY, id);
    }

    //修改商品价格
    @PostMapping("/change_price/{price}/{id}")
    public Integer changeGoodsPrice(@PathVariable double price, @PathVariable long id) {
        if (price < 0) {
            return 0;
        }
        return goodsService.changeGoodsPrice(price, id);
    }

    //修改商品库存
    @PostMapping("/change_count/{count}/{id}")
    public Integer changeGoodsCount(@PathVariable int count, @PathVariable long id) {
        if (count < 0 || count > Goods.MAXCOUNT) {
            return 0;
        }
        return goodsService.changeGoodsCount(count, id);
    }

    //增加商品库存
    @PostMapping("/up_count/{upCount}/{id}")
    public Integer upGoodsCount(@PathVariable int upCount, @PathVariable long id) {
        if (upCount < 0) {
            return 0;
        }
        return goodsService.upGoodsCount(upCount, id);
    }

    //减少商品库存
    @PostMapping("/down_count/{downCount}/{id}")
    public Integer downGoodsCount(@PathVariable int downCount, @PathVariable long id) {
        if (downCount < 0) {
            return 0;
        }
        return goodsService.downGoodsCount(downCount, id);
    }

    //移除所有删除状态的商品
    @DeleteMapping("/delete_all_in_del")
    public Integer deleteGoods() {
        Goods[] allGoods = goodsService.findAllGoods();
        if (allGoods == null) {
            return 0;
        }
        int count = 0;
        for (Goods goods : allGoods) {
            if (goods.getStatus() == Goods.DELETE) {
                count += goodsService.deleteGoodsById(goods.getId());
            }
        }
        return count;
    }
}
