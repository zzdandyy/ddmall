package pro.doublez.shopping.controller;

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
import pro.doublez.shopping.feign.GoodsFeign;
import pro.doublez.shopping.feign.OrderFeign;


import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

/**
 * @author doublez
 * @version 1.0
 * @date 2021/7/19 16:15
 */
@RestController
@CrossOrigin
public class ShoppingController {

    @Resource
    RedisTemplate<String, Object> redisTemplate;

    private final GoodsFeign goodsFeign;
    private final OrderFeign orderFeign;


    public ShoppingController(GoodsFeign goodsFeign, OrderFeign orderFeign) {
        this.goodsFeign = goodsFeign;
        this.orderFeign = orderFeign;
    }


    private ResultDto<Boolean> newCommonOrder(int uid, long gid, int count, double price) {
        if(orderFeign.findAllNoPayOrder(uid).length>=5){
            throw new BaseException(StatusCode.ORDERERROR, "超过五个未支付的订单");
        }
        Integer flag = orderFeign.addOrder(uid, gid, count, price, 1);
        ResultDto<Boolean> dto = new ResultDto<>();
        if (flag == 0) {
            dto.setBean(false).setCode(StatusCode.ORDERERROR).setMsg("生成订单失败");
        } else {
            dto.setBean(true).setCode(StatusCode.OK).setMsg("生成订单成功");
        }
        return dto;
    }

    //生成购物车订单
    @PutMapping("/add_shopping_order/{gid}")
    public ResultDto<Boolean> addShoppingOrder(@PathVariable long gid, HttpServletRequest request) {
        Goods goods = goodsFeign.findGoodsByIdPutaway(gid);
        if (goods == null) {
            throw new BaseException(StatusCode.ORDERERROR, "该商品已下架");
        }
        HashOperations<String, String, Integer> operations = redisTemplate.opsForHash();
        String jwt = request.getHeader("user-token");
        int uid = TokenUtil.getUid(jwt);
        String key = "shopping-trolley-" + uid;
        String gKey = String.valueOf(gid);
        Integer count = operations.get(key, gKey);
        double price = goods.getPrice();
        if (count == null) {
            throw new BaseException(StatusCode.ORDERERROR, "该商品不存在");
        }
        if (count > goodsFeign.findGoodsCountById(gid)) {
            throw new BaseException(StatusCode.ORDERERROR, "库存不足");
        }
        return newCommonOrder(uid, gid, count, price);
    }

    //直接生成订单
    @PutMapping("/add_order/{gid}/{count}")
    public ResultDto<Boolean> addOrder(@PathVariable long gid, @PathVariable int count,
                                       HttpServletRequest request) {
        Goods goods = goodsFeign.findGoodsByIdPutaway(gid);
        if (goods == null) {
            throw new BaseException(StatusCode.ORDERERROR, "该商品已下架");
        }
        String jwt = request.getHeader("user-token");
        int uid = TokenUtil.getUid(jwt);
        double price = goods.getPrice();
        if (count > goodsFeign.findGoodsCountById(gid)) {
            throw new BaseException(StatusCode.ORDERERROR, "库存不足");
        }
        return newCommonOrder(uid, gid, count, price);
    }


    //取消订单
    @PostMapping("/cancel_order/{oid}")
    public ResultDto<Boolean> cancelOrder(@PathVariable long oid) {
        ResultDto<Boolean> dto = new ResultDto<>();
        Integer flag = orderFeign.cancelOrder(oid);
        if (flag == 0) {
            dto.setBean(false).setCode(StatusCode.ORDERERROR).setMsg("取消订单失败");
        } else {
            dto.setBean(true).setCode(StatusCode.OK).setMsg("取消订单成功");
        }
        return dto;
    }

    //支付并提交订单
    @PostMapping("/pay_order/{oid}")
    public ResultDto<Boolean> payOrder(@PathVariable long oid) {
        ResultDto<Boolean> dto = new ResultDto<>();
        Integer flag = orderFeign.payOrder(oid);
        if (flag == 0) {
            dto.setBean(false).setCode(StatusCode.ORDERERROR).setMsg("支付失败");
        } else {
            dto.setBean(true).setCode(StatusCode.OK).setMsg("支付成功");
        }
        return dto;
    }

    private ShowOrder[] getOrderShow(Order[] orderBeans) {
        ShowOrder[] showOrders = new ShowOrder[orderBeans.length];
        for (int i = 0; i < orderBeans.length; i++) {
            long oid = orderBeans[i].getId();
            long gid = orderBeans[i].getGid();
            String gName = goodsFeign.findGoodsNameById(gid);
            int count = orderBeans[i].getCount();
            double totalPrice = orderBeans[i].getTotalPrice();
            showOrders[i] = new ShowOrder(oid, gid, gName, count, totalPrice);
        }
        return showOrders;
    }

    //查看个人未支付的订单
    @GetMapping("/find_all_no_pay_order")
    public ResultDto<ShowOrder[]> findAllNoPayOrder(HttpServletRequest request) {
        String jwt = request.getHeader("user-token");
        int uid = TokenUtil.getUid(jwt);
        Order[] allNoPayOrder = orderFeign.findAllNoPayOrder(uid);
        ShowOrder[] orderShow = getOrderShow(allNoPayOrder);
        ResultDto<ShowOrder[]> dto = new ResultDto<>();
        dto.setBean(orderShow).setCode(StatusCode.OK).setMsg("查询成功");
        return dto;
    }

    //查看个人已支付的订单
    @GetMapping("/find_all_pay_order")
    public ResultDto<ShowOrder[]> findAllPayOrder(HttpServletRequest request) {
        String jwt = request.getHeader("user-token");
        int uid = TokenUtil.getUid(jwt);
        Order[] allPayOrder = orderFeign.findAllPayOrder(uid);
        ShowOrder[] orderShow = getOrderShow(allPayOrder);
        ResultDto<ShowOrder[]> dto = new ResultDto<>();
        dto.setBean(orderShow).setCode(StatusCode.OK).setMsg("查询成功");
        return dto;
    }
}
