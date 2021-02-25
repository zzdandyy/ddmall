package pro.doublez.ddmall.service.order.service.impl;

import pro.doublez.ddmall.order.pojo.ReturnCause;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Service;
import pro.doublez.ddmall.service.order.dao.ReturnCauseMapper;
import pro.doublez.ddmall.service.order.service.ReturnCauseService;

import javax.annotation.Resource;
import java.util.List;

@Service
public class ReturnCauseServiceImpl implements ReturnCauseService {

    @Resource
    private ReturnCauseMapper returnCauseMapper;

    @Override
    public List<ReturnCause> findList(ReturnCause returnCause) {
        return returnCauseMapper.findList(returnCause);
    }

    @Override
    public PageInfo<ReturnCause> findPage(ReturnCause returnCause,int page,int size) {
        PageHelper.startPage(page, size);
        List<ReturnCause> all = returnCauseMapper.findList(returnCause);
        return new PageInfo<>(all);
    }

    @Override
    public ReturnCause findById(Integer id) {
        return returnCauseMapper.findById(id);
    }

    @Override
    public void add(ReturnCause returnCause) {
        returnCauseMapper.add(returnCause);
    }

    @Override
    public void update(ReturnCause returnCause) {
        returnCauseMapper.update(returnCause);
    }

    @Override
    public void delete(Integer id) {
        returnCauseMapper.delete(id);
    }
}
