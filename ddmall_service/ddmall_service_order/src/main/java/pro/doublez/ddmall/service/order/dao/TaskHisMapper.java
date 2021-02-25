package pro.doublez.ddmall.service.order.dao;

import pro.doublez.ddmall.order.pojo.TaskHis;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;


@Mapper
public interface TaskHisMapper {

    List<TaskHis> findList(TaskHis taskHis);

    TaskHis findById(Integer id);

    void add(TaskHis taskHis);

    void update(TaskHis taskHis);

    void delete(Integer id);

}

