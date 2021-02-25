package pro.doublez.ddmall.service.goods.service.impl;

import pro.doublez.ddmall.goods.pojo.Sku;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Service;
import pro.doublez.ddmall.service.goods.dao.SkuMapper;
import pro.doublez.ddmall.service.goods.service.SkuService;

import javax.annotation.Resource;
import java.util.List;

@Service
public class SkuServiceImpl implements SkuService {

    @Resource
    private SkuMapper skuMapper;

    @Override
    public List<Sku> findList(Sku sku) {
        return skuMapper.findList(sku);
    }

    @Override
    public PageInfo<Sku> findPage(Sku sku,int page,int size) {
        PageHelper.startPage(page, size);
        List<Sku> all = skuMapper.findList(sku);
        return new PageInfo<>(all);
    }

    @Override
    public Sku findById(String id) {
        return skuMapper.findById(id);
    }

    @Override
    public void add(Sku sku) {
        skuMapper.add(sku);
    }

    @Override
    public void update(Sku sku) {
        skuMapper.update(sku);
    }

    @Override
    public void delete(String id) {
        skuMapper.delete(id);
    }
}
