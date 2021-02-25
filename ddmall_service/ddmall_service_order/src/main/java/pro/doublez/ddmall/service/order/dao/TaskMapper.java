package pro.doublez.ddmall.service.order.dao;

import pro.doublez.ddmall.order.pojo.Task;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;


@Mapper
public interface TaskMapper {

    List<Task> findList(Task task);

    Task findById(Integer id);

    void add(Task task);

    void update(Task task);

    void delete(Integer id);

}

