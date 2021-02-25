package pro.doublez.ddmall.service.seckill.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Service;
import pro.doublez.ddmall.seckill.pojo.SeckillGoods;
import pro.doublez.ddmall.service.seckill.dao.SeckillGoodsMapper;
import pro.doublez.ddmall.service.seckill.service.SeckillGoodsService;

import javax.annotation.Resource;
import java.util.List;

@Service
public class SeckillGoodsServiceImpl implements SeckillGoodsService {

    @Resource
    private SeckillGoodsMapper seckillGoodsMapper;

    @Override
    public List<SeckillGoods> findList(SeckillGoods seckillGoods) {
        return seckillGoodsMapper.findList(seckillGoods);
    }

    @Override
    public PageInfo<SeckillGoods> findPage(SeckillGoods seckillGoods,int page,int size) {
        PageHelper.startPage(page, size);
        List<SeckillGoods> all = seckillGoodsMapper.findList(seckillGoods);
        return new PageInfo<>(all);
    }

    @Override
    public SeckillGoods findById(Integer id) {
        return seckillGoodsMapper.findById(id);
    }

    @Override
    public void add(SeckillGoods seckillGoods) {
        seckillGoodsMapper.add(seckillGoods);
    }

    @Override
    public void update(SeckillGoods seckillGoods) {
        seckillGoodsMapper.update(seckillGoods);
    }

    @Override
    public void delete(Integer id) {
        seckillGoodsMapper.delete(id);
    }
}
