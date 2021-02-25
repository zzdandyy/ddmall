package pro.doublez.ddmall.service.goods.dao;

import org.apache.ibatis.annotations.Mapper;
import pro.doublez.ddmall.goods.pojo.UndoLog;

import java.util.List;


@Mapper
public interface UndoLogMapper {

    List<UndoLog> findList(UndoLog undoLog);

    UndoLog findById(Integer id);

    void add(UndoLog undoLog);

    void update(UndoLog undoLog);

    void delete(Integer id);

}

