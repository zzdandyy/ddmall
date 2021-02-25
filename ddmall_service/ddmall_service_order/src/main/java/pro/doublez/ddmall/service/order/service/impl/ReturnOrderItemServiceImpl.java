package pro.doublez.ddmall.service.order.service.impl;

import pro.doublez.ddmall.order.pojo.ReturnOrderItem;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Service;
import pro.doublez.ddmall.service.order.dao.ReturnOrderItemMapper;
import pro.doublez.ddmall.service.order.service.ReturnOrderItemService;

import javax.annotation.Resource;
import java.util.List;

@Service
public class ReturnOrderItemServiceImpl implements ReturnOrderItemService {

    @Resource
    private ReturnOrderItemMapper returnOrderItemMapper;

    @Override
    public List<ReturnOrderItem> findList(ReturnOrderItem returnOrderItem) {
        return returnOrderItemMapper.findList(returnOrderItem);
    }

    @Override
    public PageInfo<ReturnOrderItem> findPage(ReturnOrderItem returnOrderItem,int page,int size) {
        PageHelper.startPage(page, size);
        List<ReturnOrderItem> all = returnOrderItemMapper.findList(returnOrderItem);
        return new PageInfo<>(all);
    }

    @Override
    public ReturnOrderItem findById(Integer id) {
        return returnOrderItemMapper.findById(id);
    }

    @Override
    public void add(ReturnOrderItem returnOrderItem) {
        returnOrderItemMapper.add(returnOrderItem);
    }

    @Override
    public void update(ReturnOrderItem returnOrderItem) {
        returnOrderItemMapper.update(returnOrderItem);
    }

    @Override
    public void delete(Integer id) {
        returnOrderItemMapper.delete(id);
    }
}
