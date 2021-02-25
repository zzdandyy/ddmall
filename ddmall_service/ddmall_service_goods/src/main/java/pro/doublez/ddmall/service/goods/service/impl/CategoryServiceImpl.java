package pro.doublez.ddmall.service.goods.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Service;
import pro.doublez.ddmall.goods.pojo.Category;
import pro.doublez.ddmall.service.goods.dao.CategoryMapper;
import pro.doublez.ddmall.service.goods.service.CategoryService;

import javax.annotation.Resource;
import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService {

    @Resource
    private CategoryMapper categoryMapper;

    @Override
    public List<Category> findList(Category category) {
        return categoryMapper.findList(category);
    }

    @Override
    public PageInfo<Category> findPage(Category category,int page,int size) {
        PageHelper.startPage(page, size);
        List<Category> all = categoryMapper.findList(category);
        return new PageInfo<>(all);
    }

    @Override
    public Category findById(Integer id) {
        return categoryMapper.findById(id);
    }

    @Override
    public void add(Category category) {
        categoryMapper.add(category);
    }

    @Override
    public void update(Category category) {
        categoryMapper.update(category);
    }

    @Override
    public void delete(Integer id) {
        categoryMapper.delete(id);
    }
}
