package pro.doublez.management.controller;

import org.springframework.web.bind.annotation.*;
import pro.doublez.ddmall_api.constant.StatusCode;
import pro.doublez.ddmall_api.dto.ResultDto;
import pro.doublez.ddmall_api.pojo.Admin;
import pro.doublez.ddmall_api.pojo.Goods;
import pro.doublez.ddmall_api.pojo.Order;
import pro.doublez.ddmall_api.pojo.User;
import pro.doublez.ddmall_api.utils.BaseException;
import pro.doublez.ddmall_api.utils.IdWorker;
import pro.doublez.ddmall_api.utils.JwtUtil;
import pro.doublez.management.feign.AdminFeign;
import pro.doublez.management.feign.GoodsFeign;
import pro.doublez.management.feign.OrderFeign;
import pro.doublez.management.feign.UserFeign;

import javax.servlet.http.HttpServletResponse;
import java.util.Date;

/**
 * @author doublez
 * @version 1.0
 * @date 2021/7/19 16:15
 */
@RestController
@CrossOrigin
public class ManagementController {

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

    //查看所有用户信息
    @GetMapping("/all_user")
    public ResultDto<User[]> findAllUser() {
        ResultDto<User[]> dto = new ResultDto<>();
        User[] allUser = userFeign.findAllUser();
        dto.setBean(allUser).setCode(StatusCode.OK).setMsg("查找成功");
        return dto;
    }

    //查询所有商品
    @GetMapping("/all_goods")
    public ResultDto<Goods[]> findAll() {
        Goods[] allGoods = goodsFeign.findAll();
        ResultDto<Goods[]> dto = new ResultDto<>();
        dto.setBean(allGoods).setCode(StatusCode.OK).setMsg("查询成功");
        return dto;
    }

    //根据商品名称查询商品
    @GetMapping("/find_goods_name/{name}")
    public ResultDto<Goods[]> findGoodsByName(@PathVariable String name) {

        ResultDto<Goods[]> dto = new ResultDto<>();
        Goods[] goodsByName = goodsFeign.findGoodsByName(name);
        if (goodsByName == null) {
            throw new BaseException(StatusCode.GOODSERROR, "商品不存在");
        }
        dto.setBean(goodsByName).setCode(StatusCode.OK).setMsg("查询成功");
        return dto;
    }

    //根据商品id查询商品
    @GetMapping("/find_goods_id/{id}")
    public ResultDto<Goods> findGoodsById(@PathVariable long id) {

        ResultDto<Goods> dto = new ResultDto<>();
        Goods goodsByName = goodsFeign.findGoodsById(id);
        if (goodsByName == null) {
            throw new BaseException(StatusCode.GOODSERROR, "商品不存在");
        }
        dto.setBean(goodsByName).setCode(StatusCode.OK).setMsg("查询成功");
        return dto;
    }

    //添加商品
    @PutMapping("/add_goods/{name}/{price}/{count}")
    public ResultDto<Goods> addGoods(@PathVariable String name, @PathVariable double price,
                                     @PathVariable int count) {

        if (count > Goods.MAXCOUNT) {
            throw new BaseException(StatusCode.GOODSERROR, "库存超出最大值");
        }
        ResultDto<Goods> dto = new ResultDto<>();
        Goods goods = new Goods();
        goods.setId(new IdWorker().nextId());
        goods.setName(name);
        goods.setPrice(price);
        goods.setCount(count);
        Integer flag = goodsFeign.addGoods(name, price, count);
        if (flag > 0) {
            dto.setBean(goods).setCode(StatusCode.OK).setMsg("添加成功");
        } else {
            dto.setBean(null).setCode(StatusCode.GOODSERROR).setMsg("添加失败");
        }
        return dto;
    }

    //上架商品
    @PostMapping("/change_goods/up/{id}")
    public ResultDto<Boolean> upGoods(@PathVariable long id) {
        ResultDto<Boolean> dto = new ResultDto<>();
        Goods goodsById = goodsFeign.findGoodsById(id);
        if (goodsById == null) {
            throw new BaseException(StatusCode.GOODSERROR, "商品不存在");
        }
        int status = goodsById.getStatus();
        if (status < -1) {
            throw new BaseException(StatusCode.GOODSERROR, "不满足上架条件");
        }
        if (status > 0) {
            throw new BaseException(StatusCode.GOODSERROR, "商品已上架");
        }
        Integer flag = goodsFeign.upGoods(id);
        if (flag > 0) {
            dto.setBean(true).setCode(StatusCode.OK).setMsg("上架成功");
        } else {
            dto.setBean(false).setCode(StatusCode.GOODSERROR).setMsg("上架失败");
        }
        return dto;
    }

    //下架商品
    @PostMapping("/change_goods/down/{id}")
    public ResultDto<Boolean> downGoods(@PathVariable long id) {
        ResultDto<Boolean> dto = new ResultDto<>();
        Goods goodsById = goodsFeign.findGoodsById(id);
        if (goodsById == null) {
            throw new BaseException(StatusCode.GOODSERROR, "商品不存在");
        }
        int status = goodsById.getStatus();
        if (status == -1) {
            throw new BaseException(StatusCode.GOODSERROR, "商品已下架");
        }
        if (status < -1) {
            throw new BaseException(StatusCode.GOODSERROR, "不满足下架条件");
        }
        Integer flag = goodsFeign.downGoods(id);
        if (flag > 0) {
            dto.setBean(true).setCode(StatusCode.OK).setMsg("下架成功");
        } else {
            dto.setBean(false).setCode(StatusCode.GOODSERROR).setMsg("下架失败");
        }
        return dto;
    }

    //删除商品
    @PostMapping("/change_goods/delete/{id}")
    public ResultDto<Boolean> deleteGoods(@PathVariable long id) {
        ResultDto<Boolean> dto = new ResultDto<>();
        Goods goodsById = goodsFeign.findGoodsById(id);
        if (goodsById == null) {
            throw new BaseException(StatusCode.GOODSERROR, "商品不存在");
        }
        int status = goodsById.getStatus();
        if (status == -2) {
            throw new BaseException(StatusCode.GOODSERROR, "商品已删除");
        }
        if (status > 0) {
            throw new BaseException(StatusCode.GOODSERROR, "请先下架商品");
        }
        Integer flag = goodsFeign.deleteGoods(id);
        if (flag > 0) {
            dto.setBean(true).setCode(StatusCode.OK).setMsg("删除成功");
        } else {
            dto.setBean(false).setCode(StatusCode.GOODSERROR).setMsg("删除失败");
        }
        return dto;
    }

    //恢复商品
    @PostMapping("/change_goods/recover/{id}")
    public ResultDto<Boolean> RecoverGoods(@PathVariable long id) {
        ResultDto<Boolean> dto = new ResultDto<>();
        Goods goodsById = goodsFeign.findGoodsById(id);
        if (goodsById == null) {
            throw new BaseException(StatusCode.GOODSERROR, "商品不存在");
        }
        int status = goodsById.getStatus();
        if (status != -2) {
            throw new BaseException(StatusCode.GOODSERROR, "商品未删除");
        }
        Integer flag = goodsFeign.RecoverGoods(id);
        if (flag > 0) {
            dto.setBean(true).setCode(StatusCode.OK).setMsg("恢复成功");
        } else {
            dto.setBean(false).setCode(StatusCode.GOODSERROR).setMsg("恢复失败");
        }
        return dto;
    }

    //修改商品价格
    @PostMapping("/change_goods_price/{price}/{id}")
    public ResultDto<Boolean> changeGoodsPrice(@PathVariable double price, @PathVariable long id) {
        ResultDto<Boolean> dto = new ResultDto<>();
        Integer flag = goodsFeign.changeGoodsPrice(price, id);
        if (flag > 0) {
            dto.setBean(true).setCode(StatusCode.OK).setMsg("修改成功");
        } else {
            dto.setBean(false).setCode(StatusCode.GOODSERROR).setMsg("修改失败");
        }
        return dto;
    }


    //修改商品库存
    @PostMapping("/change_goods_count/{count}/{id}")
    public ResultDto<Boolean> changeGoodsCount(@PathVariable int count, @PathVariable long id) {
        if (count < 0 || count > Goods.MAXCOUNT) {
            throw new BaseException(StatusCode.ADMINERROR, "库存数不合法");
        }
        ResultDto<Boolean> dto = new ResultDto<>();
        Integer flag = goodsFeign.changeGoodsCount(count, id);
        if (flag > 0) {
            dto.setBean(true).setCode(StatusCode.OK).setMsg("修改成功");
        } else {
            dto.setBean(false).setCode(StatusCode.GOODSERROR).setMsg("修改失败");
        }
        return dto;
    }

    //增加商品库存
    @PostMapping("/up_goods_count/{upCount}/{id}")
    public ResultDto<Boolean> upGoodsCount(@PathVariable int upCount, @PathVariable long id) {
        ResultDto<Boolean> dto = new ResultDto<>();
        Integer flag = goodsFeign.upGoodsCount(upCount, id);
        if (flag > 0) {
            dto.setBean(true).setCode(StatusCode.OK).setMsg("增加成功");
        } else {
            dto.setBean(false).setCode(StatusCode.GOODSERROR).setMsg("增加失败");
        }
        return dto;
    }

    //减少商品库存
    @PostMapping("/down_goods_count/{downCount}/{id}")
    public ResultDto<Boolean> downGoodsCount(@PathVariable int downCount, @PathVariable long id) {
        ResultDto<Boolean> dto = new ResultDto<>();
        Integer flag = goodsFeign.downGoodsCount(downCount, id);
        if (flag > 0) {
            dto.setBean(true).setCode(StatusCode.OK).setMsg("减少成功");
        } else {
            dto.setBean(false).setCode(StatusCode.GOODSERROR).setMsg("减少失败");
        }
        return dto;
    }

    //移除所有删除状态的商品
    @DeleteMapping("/delete_goods")
    public ResultDto<Integer> deleteGoods() {

        Integer count = goodsFeign.deleteGoods();
        ResultDto<Integer> dto = new ResultDto<>();
        dto.setBean(count).setCode(StatusCode.OK).setMsg("清空回收站成功");
        return dto;
    }

    @GetMapping("/find_all_order_pay")
    public ResultDto<Order[]> findAllOrderPay() {
        Order[] allOrderIsPay = orderFeign.findAllPay();
        ResultDto<Order[]> dto = new ResultDto<>();
        dto.setBean(allOrderIsPay).setCode(StatusCode.OK).setMsg("查询成功");
        return dto;
    }
}
