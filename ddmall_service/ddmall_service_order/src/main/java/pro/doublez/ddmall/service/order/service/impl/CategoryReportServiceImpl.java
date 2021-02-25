package pro.doublez.ddmall.service.order.service.impl;

import pro.doublez.ddmall.order.pojo.CategoryReport;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Service;
import pro.doublez.ddmall.service.order.dao.CategoryReportMapper;
import pro.doublez.ddmall.service.order.service.CategoryReportService;

import javax.annotation.Resource;
import java.util.List;

@Service
public class CategoryReportServiceImpl implements CategoryReportService {

    @Resource
    private CategoryReportMapper categoryReportMapper;

    @Override
    public List<CategoryReport> findList(CategoryReport categoryReport) {
        return categoryReportMapper.findList(categoryReport);
    }

    @Override
    public PageInfo<CategoryReport> findPage(CategoryReport categoryReport,int page,int size) {
        PageHelper.startPage(page, size);
        List<CategoryReport> all = categoryReportMapper.findList(categoryReport);
        return new PageInfo<>(all);
    }

    @Override
    public CategoryReport findById(Integer id) {
        return categoryReportMapper.findById(id);
    }

    @Override
    public void add(CategoryReport categoryReport) {
        categoryReportMapper.add(categoryReport);
    }

    @Override
    public void update(CategoryReport categoryReport) {
        categoryReportMapper.update(categoryReport);
    }

    @Override
    public void delete(Integer id) {
        categoryReportMapper.delete(id);
    }
}
