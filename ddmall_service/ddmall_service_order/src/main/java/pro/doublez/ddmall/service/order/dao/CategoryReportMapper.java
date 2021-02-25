package pro.doublez.ddmall.service.order.dao;

import pro.doublez.ddmall.order.pojo.CategoryReport;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;


@Mapper
public interface CategoryReportMapper {

    List<CategoryReport> findList(CategoryReport categoryReport);

    CategoryReport findById(Integer id);

    void add(CategoryReport categoryReport);

    void update(CategoryReport categoryReport);

    void delete(Integer id);

}

