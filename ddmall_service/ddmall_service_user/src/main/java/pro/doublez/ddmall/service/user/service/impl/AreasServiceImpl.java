package pro.doublez.ddmall.service.user.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Service;
import pro.doublez.ddmall.service.user.dao.AreasMapper;
import pro.doublez.ddmall.service.user.service.AreasService;
import pro.doublez.ddmall.user.pojo.Areas;

import javax.annotation.Resource;
import java.util.List;

@Service
public class AreasServiceImpl implements AreasService {

    @Resource
    private AreasMapper areasMapper;

    @Override
    public List<Areas> findList(Areas areas) {
        return areasMapper.findList(areas);
    }

    @Override
    public PageInfo<Areas> findPage(Areas areas,int page,int size) {
        PageHelper.startPage(page, size);
        List<Areas> all = areasMapper.findList(areas);
        return new PageInfo<>(all);
    }

    @Override
    public Areas findById(Integer id) {
        return areasMapper.findById(id);
    }

    @Override
    public void add(Areas areas) {
        areasMapper.add(areas);
    }

    @Override
    public void update(Areas areas) {
        areasMapper.update(areas);
    }

    @Override
    public void delete(Integer id) {
        areasMapper.delete(id);
    }
}
