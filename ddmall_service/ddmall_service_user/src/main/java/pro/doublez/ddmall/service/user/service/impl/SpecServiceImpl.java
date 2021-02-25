package pro.doublez.ddmall.service.user.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Service;
import pro.doublez.ddmall.service.user.dao.SpecMapper;
import pro.doublez.ddmall.service.user.service.SpecService;
import pro.doublez.ddmall.user.pojo.Spec;

import javax.annotation.Resource;
import java.util.List;

@Service
public class SpecServiceImpl implements SpecService {

    @Resource
    private SpecMapper specMapper;

    @Override
    public List<Spec> findList(Spec spec) {
        return specMapper.findList(spec);
    }

    @Override
    public PageInfo<Spec> findPage(Spec spec,int page,int size) {
        PageHelper.startPage(page, size);
        List<Spec> all = specMapper.findList(spec);
        return new PageInfo<>(all);
    }

    @Override
    public Spec findById(Integer id) {
        return specMapper.findById(id);
    }

    @Override
    public void add(Spec spec) {
        specMapper.add(spec);
    }

    @Override
    public void update(Spec spec) {
        specMapper.update(spec);
    }

    @Override
    public void delete(Integer id) {
        specMapper.delete(id);
    }
}
