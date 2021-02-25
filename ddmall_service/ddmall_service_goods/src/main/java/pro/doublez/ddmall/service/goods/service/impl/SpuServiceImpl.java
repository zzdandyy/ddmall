package pro.doublez.ddmall.service.goods.service.impl;

import pro.doublez.ddmall.goods.pojo.Spu;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Service;
import pro.doublez.ddmall.service.goods.dao.SpuMapper;
import pro.doublez.ddmall.service.goods.service.SpuService;

import javax.annotation.Resource;
import java.util.List;

@Service
public class SpuServiceImpl implements SpuService {

    @Resource
    private SpuMapper spuMapper;

    @Override
    public List<Spu> findList(Spu spu) {
        return spuMapper.findList(spu);
    }

    @Override
    public PageInfo<Spu> findPage(Spu spu,int page,int size) {
        PageHelper.startPage(page, size);
        List<Spu> all = spuMapper.findList(spu);
        return new PageInfo<>(all);
    }

    @Override
    public Spu findById(String id) {
        return spuMapper.findById(id);
    }

    @Override
    public void add(Spu spu) {
        spuMapper.add(spu);
    }

    @Override
    public void update(Spu spu) {
        spuMapper.update(spu);
    }

    @Override
    public void delete(String id) {
        spuMapper.delete(id);
    }
}
