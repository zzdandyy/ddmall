package pro.doublez.ddmall.service.order.dao;

import pro.doublez.ddmall.order.pojo.UndoLog;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;


@Mapper
public interface UndoLogMapper {

    List<UndoLog> findList(UndoLog undoLog);

    UndoLog findById(Integer id);

    void add(UndoLog undoLog);

    void update(UndoLog undoLog);

    void delete(Integer id);

}

