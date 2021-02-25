package pro.doublez.ddmall.service.user.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Service;
import pro.doublez.ddmall.service.user.dao.CitiesMapper;
import pro.doublez.ddmall.service.user.service.CitiesService;
import pro.doublez.ddmall.user.pojo.Cities;

import javax.annotation.Resource;
import java.util.List;

@Service
public class CitiesServiceImpl implements CitiesService {

    @Resource
    private CitiesMapper citiesMapper;

    @Override
    public List<Cities> findList(Cities cities) {
        return citiesMapper.findList(cities);
    }

    @Override
    public PageInfo<Cities> findPage(Cities cities,int page,int size) {
        PageHelper.startPage(page, size);
        List<Cities> all = citiesMapper.findList(cities);
        return new PageInfo<>(all);
    }

    @Override
    public Cities findById(Integer id) {
        return citiesMapper.findById(id);
    }

    @Override
    public void add(Cities cities) {
        citiesMapper.add(cities);
    }

    @Override
    public void update(Cities cities) {
        citiesMapper.update(cities);
    }

    @Override
    public void delete(Integer id) {
        citiesMapper.delete(id);
    }
}
