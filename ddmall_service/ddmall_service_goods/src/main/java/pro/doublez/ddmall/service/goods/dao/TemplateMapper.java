package pro.doublez.ddmall.service.goods.dao;


import org.apache.ibatis.annotations.Mapper;
import pro.doublez.ddmall.goods.pojo.Template;

import java.util.List;

@Mapper
public interface TemplateMapper  {

    List<Template> findList(Template template);

    Template findById(Integer id);

    void add(Template template);

    void update(Template template);

    void delete(Integer id);
}
