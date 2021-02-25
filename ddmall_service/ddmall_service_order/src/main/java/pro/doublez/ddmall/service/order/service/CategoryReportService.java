package pro.doublez.ddmall.service.order.service;

import pro.doublez.ddmall.order.pojo.CategoryReport;
import com.github.pagehelper.PageInfo;

import java.util.List;

public interface CategoryReportService {

    // 条件查询
    List<CategoryReport> findList(CategoryReport categoryReport);

    // 分页条件查询
    PageInfo<CategoryReport> findPage(CategoryReport categoryReport, int page, int size);

    CategoryReport findById(Integer id);

    void add(CategoryReport categoryReport);

    void update(CategoryReport categoryReport);

    void delete(Integer id);

}
