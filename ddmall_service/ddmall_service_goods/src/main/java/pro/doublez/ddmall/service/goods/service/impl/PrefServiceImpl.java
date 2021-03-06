package pro.doublez.ddmall.service.goods.service.impl;

import pro.doublez.ddmall.goods.pojo.Pref;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Service;
import pro.doublez.ddmall.service.goods.dao.PrefMapper;
import pro.doublez.ddmall.service.goods.service.PrefService;

import javax.annotation.Resource;
import java.util.List;

@Service
public class PrefServiceImpl implements PrefService {

    @Resource
    private PrefMapper prefMapper;

    @Override
    public List<Pref> findList(Pref pref) {
        return prefMapper.findList(pref);
    }

    @Override
    public PageInfo<Pref> findPage(Pref pref,int page,int size) {
        PageHelper.startPage(page, size);
        List<Pref> all = prefMapper.findList(pref);
        return new PageInfo<>(all);
    }

    @Override
    public Pref findById(Integer id) {
        return prefMapper.findById(id);
    }

    @Override
    public void add(Pref pref) {
        prefMapper.add(pref);
    }

    @Override
    public void update(Pref pref) {
        prefMapper.update(pref);
    }

    @Override
    public void delete(Integer id) {
        prefMapper.delete(id);
    }
}
