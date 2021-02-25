package pro.doublez.ddmall.service.user.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Service;
import pro.doublez.ddmall.service.user.dao.ProvincesMapper;
import pro.doublez.ddmall.service.user.service.ProvincesService;
import pro.doublez.ddmall.user.pojo.Provinces;

import javax.annotation.Resource;
import java.util.List;

@Service
public class ProvincesServiceImpl implements ProvincesService {

    @Resource
    private ProvincesMapper provincesMapper;

    @Override
    public List<Provinces> findList(Provinces provinces) {
        return provincesMapper.findList(provinces);
    }

    @Override
    public PageInfo<Provinces> findPage(Provinces provinces,int page,int size) {
        PageHelper.startPage(page, size);
        List<Provinces> all = provincesMapper.findList(provinces);
        return new PageInfo<>(all);
    }

    @Override
    public Provinces findById(Integer id) {
        return provincesMapper.findById(id);
    }

    @Override
    public void add(Provinces provinces) {
        provincesMapper.add(provinces);
    }

    @Override
    public void update(Provinces provinces) {
        provincesMapper.update(provinces);
    }

    @Override
    public void delete(Integer id) {
        provincesMapper.delete(id);
    }
}
