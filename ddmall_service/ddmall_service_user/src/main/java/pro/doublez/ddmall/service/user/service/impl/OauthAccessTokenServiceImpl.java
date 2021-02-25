package pro.doublez.ddmall.service.user.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Service;
import pro.doublez.ddmall.service.user.dao.OauthAccessTokenMapper;
import pro.doublez.ddmall.service.user.service.OauthAccessTokenService;
import pro.doublez.ddmall.user.pojo.OauthAccessToken;

import javax.annotation.Resource;
import java.util.List;

@Service
public class OauthAccessTokenServiceImpl implements OauthAccessTokenService {

    @Resource
    private OauthAccessTokenMapper oauthAccessTokenMapper;

    @Override
    public List<OauthAccessToken> findList(OauthAccessToken oauthAccessToken) {
        return oauthAccessTokenMapper.findList(oauthAccessToken);
    }

    @Override
    public PageInfo<OauthAccessToken> findPage(OauthAccessToken oauthAccessToken,int page,int size) {
        PageHelper.startPage(page, size);
        List<OauthAccessToken> all = oauthAccessTokenMapper.findList(oauthAccessToken);
        return new PageInfo<>(all);
    }

    @Override
    public OauthAccessToken findById(Integer id) {
        return oauthAccessTokenMapper.findById(id);
    }

    @Override
    public void add(OauthAccessToken oauthAccessToken) {
        oauthAccessTokenMapper.add(oauthAccessToken);
    }

    @Override
    public void update(OauthAccessToken oauthAccessToken) {
        oauthAccessTokenMapper.update(oauthAccessToken);
    }

    @Override
    public void delete(Integer id) {
        oauthAccessTokenMapper.delete(id);
    }
}
