package pro.doublez.ddmall.service.order.service.impl;

import pro.doublez.ddmall.order.pojo.ReturnOrder;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Service;
import pro.doublez.ddmall.service.order.dao.ReturnOrderMapper;
import pro.doublez.ddmall.service.order.service.ReturnOrderService;

import javax.annotation.Resource;
import java.util.List;

@Service
public class ReturnOrderServiceImpl implements ReturnOrderService {

    @Resource
    private ReturnOrderMapper returnOrderMapper;

    @Override
    public List<ReturnOrder> findList(ReturnOrder returnOrder) {
        return returnOrderMapper.findList(returnOrder);
    }

    @Override
    public PageInfo<ReturnOrder> findPage(ReturnOrder returnOrder,int page,int size) {
        PageHelper.startPage(page, size);
        List<ReturnOrder> all = returnOrderMapper.findList(returnOrder);
        return new PageInfo<>(all);
    }

    @Override
    public ReturnOrder findById(Integer id) {
        return returnOrderMapper.findById(id);
    }

    @Override
    public void add(ReturnOrder returnOrder) {
        returnOrderMapper.add(returnOrder);
    }

    @Override
    public void update(ReturnOrder returnOrder) {
        returnOrderMapper.update(returnOrder);
    }

    @Override
    public void delete(Integer id) {
        returnOrderMapper.delete(id);
    }
}
