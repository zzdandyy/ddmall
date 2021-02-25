package pro.doublez.ddmall.service.goods.dao;



import org.apache.ibatis.annotations.Mapper;
import pro.doublez.ddmall.goods.pojo.Para;

import java.util.List;

@Mapper
public interface ParaMapper{

    // 条件查询
    List<Para> findList(Para para);

    Para findById(Integer id);

    void add(Para para);

    void update(Para para);

    void delete(Integer id);

}
