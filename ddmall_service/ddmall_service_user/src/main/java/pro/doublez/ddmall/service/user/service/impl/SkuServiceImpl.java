package pro.doublez.ddmall.service.user.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Service;
import pro.doublez.ddmall.service.user.dao.SkuMapper;
import pro.doublez.ddmall.service.user.service.SkuService;
import pro.doublez.ddmall.user.pojo.Sku;

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
    public Sku findById(Integer id) {
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
    public void delete(Integer id) {
        skuMapper.delete(id);
    }
}
