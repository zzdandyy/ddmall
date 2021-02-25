package pro.doublez.ddmall.service.goods.service;

import com.github.pagehelper.PageInfo;
import pro.doublez.ddmall.goods.pojo.Album;
import pro.doublez.ddmall.goods.pojo.Template;

import java.util.List;
import java.util.Map;

public interface TemplateService {

    // 条件查询
    List<Template> findList(Template template);

    // 分页条件查询
    PageInfo<Template> findPage(Template template, int page, int size);

    Template findById(Integer id);

    void add(Template template);

    void update(Template template);

    void delete(Integer id);
}
