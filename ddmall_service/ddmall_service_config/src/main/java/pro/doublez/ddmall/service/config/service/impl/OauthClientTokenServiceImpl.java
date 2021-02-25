package pro.doublez.ddmall.service.config.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Service;
import pro.doublez.ddmall.config.pojo.OauthClientToken;
import pro.doublez.ddmall.service.config.dao.OauthClientTokenMapper;
import pro.doublez.ddmall.service.config.service.OauthClientTokenService;

import javax.annotation.Resource;
import java.util.List;

@Service
public class OauthClientTokenServiceImpl implements OauthClientTokenService {

    @Resource
    private OauthClientTokenMapper oauthClientTokenMapper;

    @Override
    public List<OauthClientToken> findList(OauthClientToken oauthClientToken) {
        return oauthClientTokenMapper.findList(oauthClientToken);
    }

    @Override
    public PageInfo<OauthClientToken> findPage(OauthClientToken oauthClientToken,int page,int size) {
        PageHelper.startPage(page, size);
        List<OauthClientToken> all = oauthClientTokenMapper.findList(oauthClientToken);
        return new PageInfo<>(all);
    }

    @Override
    public OauthClientToken findById(Integer id) {
        return oauthClientTokenMapper.findById(id);
    }

    @Override
    public void add(OauthClientToken oauthClientToken) {
        oauthClientTokenMapper.add(oauthClientToken);
    }

    @Override
    public void update(OauthClientToken oauthClientToken) {
        oauthClientTokenMapper.update(oauthClientToken);
    }

    @Override
    public void delete(Integer id) {
        oauthClientTokenMapper.delete(id);
    }
}
