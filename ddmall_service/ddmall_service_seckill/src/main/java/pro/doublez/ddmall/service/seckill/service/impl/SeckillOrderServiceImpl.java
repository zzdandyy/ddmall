package pro.doublez.ddmall.service.seckill.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Service;
import pro.doublez.ddmall.seckill.pojo.SeckillOrder;
import pro.doublez.ddmall.service.seckill.dao.SeckillOrderMapper;
import pro.doublez.ddmall.service.seckill.service.SeckillOrderService;

import javax.annotation.Resource;
import java.util.List;

@Service
public class SeckillOrderServiceImpl implements SeckillOrderService {

    @Resource
    private SeckillOrderMapper seckillOrderMapper;

    @Override
    public List<SeckillOrder> findList(SeckillOrder seckillOrder) {
        return seckillOrderMapper.findList(seckillOrder);
    }

    @Override
    public PageInfo<SeckillOrder> findPage(SeckillOrder seckillOrder,int page,int size) {
        PageHelper.startPage(page, size);
        List<SeckillOrder> all = seckillOrderMapper.findList(seckillOrder);
        return new PageInfo<>(all);
    }

    @Override
    public SeckillOrder findById(Integer id) {
        return seckillOrderMapper.findById(id);
    }

    @Override
    public void add(SeckillOrder seckillOrder) {
        seckillOrderMapper.add(seckillOrder);
    }

    @Override
    public void update(SeckillOrder seckillOrder) {
        seckillOrderMapper.update(seckillOrder);
    }

    @Override
    public void delete(Integer id) {
        seckillOrderMapper.delete(id);
    }
}
