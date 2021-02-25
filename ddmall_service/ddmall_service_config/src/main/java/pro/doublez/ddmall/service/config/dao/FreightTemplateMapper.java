package pro.doublez.ddmall.service.config.dao;

import org.apache.ibatis.annotations.Mapper;
import pro.doublez.ddmall.config.pojo.FreightTemplate;

import java.util.List;


@Mapper
public interface FreightTemplateMapper {

    List<FreightTemplate> findList(FreightTemplate freightTemplate);

    FreightTemplate findById(Integer id);

    void add(FreightTemplate freightTemplate);

    void update(FreightTemplate freightTemplate);

    void delete(Integer id);

}

