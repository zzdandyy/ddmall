package pro.doublez.ddmall.service.order.service;

import pro.doublez.ddmall.order.pojo.ReturnCause;
import com.github.pagehelper.PageInfo;

import java.util.List;

public interface ReturnCauseService {

    // 条件查询
    List<ReturnCause> findList(ReturnCause returnCause);

    // 分页条件查询
    PageInfo<ReturnCause> findPage(ReturnCause returnCause, int page, int size);

    ReturnCause findById(Integer id);

    void add(ReturnCause returnCause);

    void update(ReturnCause returnCause);

    void delete(Integer id);

}
