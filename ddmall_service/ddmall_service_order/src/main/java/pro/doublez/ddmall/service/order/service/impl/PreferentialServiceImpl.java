package pro.doublez.ddmall.service.order.service.impl;

import pro.doublez.ddmall.order.pojo.Preferential;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Service;
import pro.doublez.ddmall.service.order.dao.PreferentialMapper;
import pro.doublez.ddmall.service.order.service.PreferentialService;

import javax.annotation.Resource;
import java.util.List;

@Service
public class PreferentialServiceImpl implements PreferentialService {

    @Resource
    private PreferentialMapper preferentialMapper;

    @Override
    public List<Preferential> findList(Preferential preferential) {
        return preferentialMapper.findList(preferential);
    }

    @Override
    public PageInfo<Preferential> findPage(Preferential preferential,int page,int size) {
        PageHelper.startPage(page, size);
        List<Preferential> all = preferentialMapper.findList(preferential);
        return new PageInfo<>(all);
    }

    @Override
    public Preferential findById(Integer id) {
        return preferentialMapper.findById(id);
    }

    @Override
    public void add(Preferential preferential) {
        preferentialMapper.add(preferential);
    }

    @Override
    public void update(Preferential preferential) {
        preferentialMapper.update(preferential);
    }

    @Override
    public void delete(Integer id) {
        preferentialMapper.delete(id);
    }
}
