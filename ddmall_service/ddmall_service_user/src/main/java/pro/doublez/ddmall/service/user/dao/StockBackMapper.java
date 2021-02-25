package pro.doublez.ddmall.service.user.dao;

import org.apache.ibatis.annotations.Mapper;
import pro.doublez.ddmall.user.pojo.StockBack;

import java.util.List;


@Mapper
public interface StockBackMapper {

    List<StockBack> findList(StockBack stockBack);

    StockBack findById(Integer id);

    void add(StockBack stockBack);

    void update(StockBack stockBack);

    void delete(Integer id);

}

