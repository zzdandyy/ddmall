package pro.doublez.ddmall.service.user.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Service;
import pro.doublez.ddmall.service.user.dao.ParaMapper;
import pro.doublez.ddmall.service.user.service.ParaService;
import pro.doublez.ddmall.user.pojo.Para;

import javax.annotation.Resource;
import java.util.List;

@Service
public class ParaServiceImpl implements ParaService {

    @Resource
    private ParaMapper paraMapper;

    @Override
    public List<Para> findList(Para para) {
        return paraMapper.findList(para);
    }

    @Override
    public PageInfo<Para> findPage(Para para,int page,int size) {
        PageHelper.startPage(page, size);
        List<Para> all = paraMapper.findList(para);
        return new PageInfo<>(all);
    }

    @Override
    public Para findById(Integer id) {
        return paraMapper.findById(id);
    }

    @Override
    public void add(Para para) {
        paraMapper.add(para);
    }

    @Override
    public void update(Para para) {
        paraMapper.update(para);
    }

    @Override
    public void delete(Integer id) {
        paraMapper.delete(id);
    }
}
