package pro.doublez.ddmall.service.goods.service.impl;

import pro.doublez.ddmall.goods.pojo.Brand;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Service;
import pro.doublez.ddmall.service.goods.dao.BrandMapper;
import pro.doublez.ddmall.service.goods.service.BrandService;

import javax.annotation.Resource;
import java.util.List;

@Service
public class BrandServiceImpl implements BrandService {

    @Resource
    private BrandMapper brandMapper;

    @Override
    public List<Brand> findList(Brand brand) {
        return brandMapper.findList(brand);
    }

    @Override
    public PageInfo<Brand> findPage(Brand brand,int page,int size) {
        PageHelper.startPage(page, size);
        List<Brand> all = brandMapper.findList(brand);
        return new PageInfo<>(all);
    }

    @Override
    public Brand findById(Integer id) {
        return brandMapper.findById(id);
    }

    @Override
    public void add(Brand brand) {
        brandMapper.add(brand);
    }

    @Override
    public void update(Brand brand) {
        brandMapper.update(brand);
    }

    @Override
    public void delete(Integer id) {
        brandMapper.delete(id);
    }
}
