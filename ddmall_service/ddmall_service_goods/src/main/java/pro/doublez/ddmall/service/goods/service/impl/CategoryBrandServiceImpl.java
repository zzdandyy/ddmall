package pro.doublez.ddmall.service.goods.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Service;
import pro.doublez.ddmall.goods.pojo.CategoryBrand;
import pro.doublez.ddmall.service.goods.dao.CategoryBrandMapper;
import pro.doublez.ddmall.service.goods.service.CategoryBrandService;

import javax.annotation.Resource;
import java.util.List;

@Service
public class CategoryBrandServiceImpl implements CategoryBrandService {

    @Resource
    private CategoryBrandMapper categoryBrandMapper;

    @Override
    public List<CategoryBrand> findList(CategoryBrand categoryBrand) {

        return categoryBrandMapper.findList(categoryBrand);
    }

    @Override
    public PageInfo<CategoryBrand> findPage(CategoryBrand categoryBrand,int page,int size) {
        PageHelper.startPage(page, size);
        List<CategoryBrand> all = categoryBrandMapper.findList(categoryBrand);
        return new PageInfo<>(all);
    }

    @Override
    public CategoryBrand findById(Integer id) {
        return categoryBrandMapper.findById(id);
    }

    @Override
    public void add(CategoryBrand categoryBrand) {
        categoryBrandMapper.add(categoryBrand);
    }

    @Override
    public void update(CategoryBrand categoryBrand) {
        categoryBrandMapper.update(categoryBrand);
    }

    @Override
    public void delete(Integer id) {
        categoryBrandMapper.delete(id);
    }
}
