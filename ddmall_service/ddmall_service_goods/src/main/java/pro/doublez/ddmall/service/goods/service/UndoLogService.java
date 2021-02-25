package pro.doublez.ddmall.service.goods.service;

import com.github.pagehelper.PageInfo;
import pro.doublez.ddmall.goods.pojo.UndoLog;

import java.util.List;

public interface UndoLogService {

    // 条件查询
    List<UndoLog> findList(UndoLog undoLog);

    // 分页条件查询
    PageInfo<UndoLog> findPage(UndoLog undoLog, int page, int size);

    UndoLog findById(Integer id);

    void add(UndoLog undoLog);

    void update(UndoLog undoLog);

    void delete(Integer id);

}
