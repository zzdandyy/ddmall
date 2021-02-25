package pro.doublez.ddmall.service.user.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Service;
import pro.doublez.ddmall.service.user.dao.OauthRefreshTokenMapper;
import pro.doublez.ddmall.service.user.service.OauthRefreshTokenService;
import pro.doublez.ddmall.user.pojo.OauthRefreshToken;

import javax.annotation.Resource;
import java.util.List;

@Service
public class OauthRefreshTokenServiceImpl implements OauthRefreshTokenService {

    @Resource
    private OauthRefreshTokenMapper oauthRefreshTokenMapper;

    @Override
    public List<OauthRefreshToken> findList(OauthRefreshToken oauthRefreshToken) {
        return oauthRefreshTokenMapper.findList(oauthRefreshToken);
    }

    @Override
    public PageInfo<OauthRefreshToken> findPage(OauthRefreshToken oauthRefreshToken,int page,int size) {
        PageHelper.startPage(page, size);
        List<OauthRefreshToken> all = oauthRefreshTokenMapper.findList(oauthRefreshToken);
        return new PageInfo<>(all);
    }

    @Override
    public OauthRefreshToken findById(Integer id) {
        return oauthRefreshTokenMapper.findById(id);
    }

    @Override
    public void add(OauthRefreshToken oauthRefreshToken) {
        oauthRefreshTokenMapper.add(oauthRefreshToken);
    }

    @Override
    public void update(OauthRefreshToken oauthRefreshToken) {
        oauthRefreshTokenMapper.update(oauthRefreshToken);
    }

    @Override
    public void delete(Integer id) {
        oauthRefreshTokenMapper.delete(id);
    }
}
