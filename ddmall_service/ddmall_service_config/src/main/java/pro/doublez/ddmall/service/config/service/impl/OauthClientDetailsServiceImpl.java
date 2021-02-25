package pro.doublez.ddmall.service.config.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Service;
import pro.doublez.ddmall.config.pojo.OauthClientDetails;
import pro.doublez.ddmall.service.config.dao.OauthClientDetailsMapper;
import pro.doublez.ddmall.service.config.service.OauthClientDetailsService;

import javax.annotation.Resource;
import java.util.List;

@Service
public class OauthClientDetailsServiceImpl implements OauthClientDetailsService {

    @Resource
    private OauthClientDetailsMapper oauthClientDetailsMapper;

    @Override
    public List<OauthClientDetails> findList(OauthClientDetails oauthClientDetails) {
        return oauthClientDetailsMapper.findList(oauthClientDetails);
    }

    @Override
    public PageInfo<OauthClientDetails> findPage(OauthClientDetails oauthClientDetails,int page,int size) {
        PageHelper.startPage(page, size);
        List<OauthClientDetails> all = oauthClientDetailsMapper.findList(oauthClientDetails);
        return new PageInfo<>(all);
    }

    @Override
    public OauthClientDetails findById(Integer id) {
        return oauthClientDetailsMapper.findById(id);
    }

    @Override
    public void add(OauthClientDetails oauthClientDetails) {
        oauthClientDetailsMapper.add(oauthClientDetails);
    }

    @Override
    public void update(OauthClientDetails oauthClientDetails) {
        oauthClientDetailsMapper.update(oauthClientDetails);
    }

    @Override
    public void delete(Integer id) {
        oauthClientDetailsMapper.delete(id);
    }
}
