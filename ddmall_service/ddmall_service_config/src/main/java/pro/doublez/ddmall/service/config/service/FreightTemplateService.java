package pro.doublez.ddmall.service.config.service;

import com.github.pagehelper.PageInfo;
import pro.doublez.ddmall.config.pojo.FreightTemplate;

import java.util.List;

public interface FreightTemplateService {

    // 条件查询
    List<FreightTemplate> findList(FreightTemplate freightTemplate);

    // 分页条件查询
    PageInfo<FreightTemplate> findPage(FreightTemplate freightTemplate, int page, int size);

    FreightTemplate findById(Integer id);

    void add(FreightTemplate freightTemplate);

    void update(FreightTemplate freightTemplate);

    void delete(Integer id);

}
