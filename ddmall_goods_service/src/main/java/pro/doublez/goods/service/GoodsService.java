package pro.doublez.goods.service;

import pro.doublez.goods.pojo.Goods;

/**
 * @author doublez
 * @version 1.0
 * @date 2021/7/12 15:43
 */
public interface GoodsService {

    //查询所有商品
    Goods[] findAllGoods();

    //根据商品名称查询商品
    Goods[] findGoodsByName(String name);

    //根据商品id查询商品
    Goods findGoodsById(long id);

    //用户查询所有商品
    Goods[] findAllGoodsToUser();

    //用户根据商品名称查询商品
    Goods[] findGoodsByNameToUser(String name);

    //用户根据商品id查询商品
    Goods findGoodsByIdToUser(long id);

    //根据商品id查询商品库存
    Integer findCountById(long id);

    //根据商品id查询商品名字
    String findNameById(long id);

    //添加商品
    Integer addGoods(Goods goodsBean);

    //修改商品价格
    Integer changeGoodsPrice(double price, long id);

    //修改商品状态
    Integer changeGoodsStatus(int status, long id);

    //修改商品库存
    Integer changeGoodsCount(int count, long id);

    //增加商品库存
    Integer upGoodsCount(int upCount, long id);

    //减少商品库存
    Integer downGoodsCount(int downCount, long id);

    //删除商品
    Integer deleteGoodsById(long id);
}
