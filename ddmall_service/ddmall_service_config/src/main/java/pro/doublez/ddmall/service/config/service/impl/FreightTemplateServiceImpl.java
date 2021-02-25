package pro.doublez.ddmall.service.config.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Service;
import pro.doublez.ddmall.config.pojo.FreightTemplate;
import pro.doublez.ddmall.service.config.dao.FreightTemplateMapper;
import pro.doublez.ddmall.service.config.service.FreightTemplateService;

import javax.annotation.Resource;
import java.util.List;

@Service
public class FreightTemplateServiceImpl implements FreightTemplateService {

    @Resource
    private FreightTemplateMapper freightTemplateMapper;

    @Override
    public List<FreightTemplate> findList(FreightTemplate freightTemplate) {
        return freightTemplateMapper.findList(freightTemplate);
    }

    @Override
    public PageInfo<FreightTemplate> findPage(FreightTemplate freightTemplate,int page,int size) {
        PageHelper.startPage(page, size);
        List<FreightTemplate> all = freightTemplateMapper.findList(freightTemplate);
        return new PageInfo<>(all);
    }

    @Override
    public FreightTemplate findById(Integer id) {
        return freightTemplateMapper.findById(id);
    }

    @Override
    public void add(FreightTemplate freightTemplate) {
        freightTemplateMapper.add(freightTemplate);
    }

    @Override
    public void update(FreightTemplate freightTemplate) {
        freightTemplateMapper.update(freightTemplate);
    }

    @Override
    public void delete(Integer id) {
        freightTemplateMapper.delete(id);
    }
}
