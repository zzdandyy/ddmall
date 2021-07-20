package pro.doublez.goods.service.impl;

import org.springframework.stereotype.Service;
import pro.doublez.goods.dao.SecKillGoodsDao;
import pro.doublez.goods.pojo.SeckillGoods;
import pro.doublez.goods.service.SeckillGoodsService;

import java.util.Date;

/**
 * @author doublez
 * @version 1.0
 * @date 2021/7/15 21:40
 */
@Service
public class SeckillGoodsServiceImpl implements SeckillGoodsService {

    private final SecKillGoodsDao secKillGoodsDao;

    public SeckillGoodsServiceImpl(SecKillGoodsDao secKillGoodsDao) {
        this.secKillGoodsDao = secKillGoodsDao;
    }

    @Override
    public SeckillGoods[] findAll() {
        return secKillGoodsDao.findAll();
    }

    @Override
    public SeckillGoods findAllById(long id) {

        return secKillGoodsDao.findAllById(id);
    }

    @Override
    public SeckillGoods[] findAllByName(String name) {
        return secKillGoodsDao.findAllByName(name);
    }

    @Override
    public Integer findCountById(long id) {
        return secKillGoodsDao.findCountById(id);
    }

    @Override
    public SeckillGoods[] findAllOnSale() {
        Date curTime = new Date();
        //时区
        curTime.setTime(curTime.getTime() + 8 * 60 * 60 * 1000);
        return secKillGoodsDao.findAllOnSale(curTime);
    }

    @Override
    public SeckillGoods findAllByIdOnSale(long id) {
        Date curTime = new Date();
        //时区
        curTime.setTime(curTime.getTime() + 8 * 60 * 60 * 1000);
        return secKillGoodsDao.findAllByIdOnSale(id, curTime);
    }

    @Override
    public SeckillGoods[] findAllByNameOnSale(String name) {
        Date curTime = new Date();
        //时区
        curTime.setTime(curTime.getTime() + 8 * 60 * 60 * 1000);
        return secKillGoodsDao.findAllByNameOnSale(name, curTime);
    }

    @Override
    public Integer addGoods(SeckillGoods seckillGoodsBean) {
        return secKillGoodsDao.addGoods(seckillGoodsBean);
    }

    @Override
    public Integer changeStartTime(Date date, long id) {
        return secKillGoodsDao.changeStartTime(date, id);
    }

    @Override
    public Integer changeEndTime(Date date, long id) {
        return secKillGoodsDao.changeEndTime(date, id);
    }

    @Override
    public Integer changeSeckillGoodsCount(int count, long id) {
        if (count < 0) {
            return 0;
        }
        return secKillGoodsDao.changeSeckillGoodsCount(count,id);
    }

    @Override
    public Integer downCount(int count, long secId) {
        return secKillGoodsDao.downCount(count,secId);
    }
}
