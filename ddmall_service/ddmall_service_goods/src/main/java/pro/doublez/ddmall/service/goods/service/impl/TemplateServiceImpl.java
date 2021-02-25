package pro.doublez.ddmall.service.goods.service.impl;

import pro.doublez.ddmall.goods.pojo.Template;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Service;
import pro.doublez.ddmall.service.goods.dao.TemplateMapper;
import pro.doublez.ddmall.service.goods.service.TemplateService;

import javax.annotation.Resource;
import java.util.List;

@Service
public class TemplateServiceImpl implements TemplateService {

    @Resource
    private TemplateMapper templateMapper;

    @Override
    public List<Template> findList(Template template) {
        return templateMapper.findList(template);
    }

    @Override
    public PageInfo<Template> findPage(Template template,int page,int size) {
        PageHelper.startPage(page, size);
        List<Template> all = templateMapper.findList(template);
        return new PageInfo<>(all);
    }

    @Override
    public Template findById(Integer id) {
        return templateMapper.findById(id);
    }

    @Override
    public void add(Template template) {
        templateMapper.add(template);
    }

    @Override
    public void update(Template template) {
        templateMapper.update(template);
    }

    @Override
    public void delete(Integer id) {
        templateMapper.delete(id);
    }
}
