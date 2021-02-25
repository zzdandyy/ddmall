package pro.doublez.ddmall.service.business.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Service;
import pro.doublez.ddmall.business.pojo.Ad;
import pro.doublez.ddmall.service.business.dao.AdMapper;
import pro.doublez.ddmall.service.business.service.AdService;

import javax.annotation.Resource;
import java.util.List;

@Service
public class AdServiceImpl implements AdService {

    @Resource
    private AdMapper adMapper;

    @Override
    public List<Ad> findList(Ad ad) {
        return adMapper.findList(ad);
    }

    @Override
    public PageInfo<Ad> findPage(Ad ad,int page,int size) {
        PageHelper.startPage(page, size);
        List<Ad> all = adMapper.findList(ad);
        return new PageInfo<>(all);
    }

    @Override
    public Ad findById(Integer id) {
        return adMapper.findById(id);
    }

    @Override
    public void add(Ad ad) {
        adMapper.add(ad);
    }

    @Override
    public void update(Ad ad) {
        adMapper.update(ad);
    }

    @Override
    public void delete(Integer id) {
        adMapper.delete(id);
    }
}
