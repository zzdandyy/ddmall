package pro.doublez.goods.service.impl;

import org.springframework.stereotype.Service;
import pro.doublez.goods.dao.GoodsDao;
import pro.doublez.goods.pojo.Goods;
import pro.doublez.goods.service.GoodsService;

/**
 * @author doublez
 * @version 1.0
 * @date 2021/7/12 15:44
 */
@Service
public class GoodsServiceImpl implements GoodsService {

    private final GoodsDao goodsDao;

    public GoodsServiceImpl(GoodsDao goodsDao) {
        this.goodsDao = goodsDao;
    }

    @Override
    public Goods[] findAllGoods() {
        return goodsDao.findAllGoods();
    }

    @Override
    public Goods[] findGoodsByName(String name) {
        return goodsDao.findGoodsByName(name);
    }

    @Override
    public Goods findGoodsById(long id) {
        return goodsDao.findGoodsById(id);
    }

    @Override
    public Goods[] findAllGoodsToUser() {
        return goodsDao.findAllGoodsToUser();
    }

    @Override
    public Goods[] findGoodsByNameToUser(String name) {
        return goodsDao.findGoodsByNameToUser(name);
    }

    @Override
    public Goods findGoodsByIdToUser(long id) {
        return goodsDao.findGoodsByIdToUser(id);
    }

    @Override
    public Integer findCountById(long id) {
        return goodsDao.findCountById(id);
    }

    @Override
    public String findNameById(long id) {
        return goodsDao.findNameById(id);
    }

    @Override
    public Integer addGoods(Goods goodsBean) {
        return goodsDao.addGoods(goodsBean);
    }

    @Override
    public Integer changeGoodsPrice(double price, long id) {
        return goodsDao.changeGoodsPrice(price, id);
    }

    @Override
    public Integer changeGoodsStatus(int status, long id) {
        return goodsDao.changeGoodsStatus(status, id);
    }

    @Override
    public Integer changeGoodsCount(int count, long id) {
        return goodsDao.changeGoodsCount(count, id);
    }

    @Override
    public Integer upGoodsCount(int upCount, long id) {
        return goodsDao.upGoodsCount(upCount, id);
    }

    @Override
    public Integer downGoodsCount(int downCount, long id) {
        return goodsDao.downGoodsCount(downCount, id);
    }

    @Override
    public Integer deleteGoodsById(long id) {
        return goodsDao.deleteGoodsById(id);
    }

    @Override
    public Integer deleteGoodsInDel() {
        return goodsDao.deleteGoodsInDel();
    }
}
