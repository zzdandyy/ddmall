package pro.doublez.ddmall.service.order.dao;

import pro.doublez.ddmall.order.pojo.Preferential;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;


@Mapper
public interface PreferentialMapper {

    List<Preferential> findList(Preferential preferential);

    Preferential findById(Integer id);

    void add(Preferential preferential);

    void update(Preferential preferential);

    void delete(Integer id);

}

