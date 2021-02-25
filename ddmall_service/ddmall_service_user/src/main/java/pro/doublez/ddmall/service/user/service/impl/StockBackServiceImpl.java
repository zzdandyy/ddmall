package pro.doublez.ddmall.service.user.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Service;
import pro.doublez.ddmall.service.user.dao.StockBackMapper;
import pro.doublez.ddmall.service.user.service.StockBackService;
import pro.doublez.ddmall.user.pojo.StockBack;

import javax.annotation.Resource;
import java.util.List;

@Service
public class StockBackServiceImpl implements StockBackService {

    @Resource
    private StockBackMapper stockBackMapper;

    @Override
    public List<StockBack> findList(StockBack stockBack) {
        return stockBackMapper.findList(stockBack);
    }

    @Override
    public PageInfo<StockBack> findPage(StockBack stockBack,int page,int size) {
        PageHelper.startPage(page, size);
        List<StockBack> all = stockBackMapper.findList(stockBack);
        return new PageInfo<>(all);
    }

    @Override
    public StockBack findById(Integer id) {
        return stockBackMapper.findById(id);
    }

    @Override
    public void add(StockBack stockBack) {
        stockBackMapper.add(stockBack);
    }

    @Override
    public void update(StockBack stockBack) {
        stockBackMapper.update(stockBack);
    }

    @Override
    public void delete(Integer id) {
        stockBackMapper.delete(id);
    }
}
