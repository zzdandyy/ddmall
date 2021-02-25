package pro.doublez.ddmall.service.user.service;

import com.github.pagehelper.PageInfo;
import pro.doublez.ddmall.user.pojo.OauthRefreshToken;

import java.util.List;

public interface OauthRefreshTokenService {

    // 条件查询
    List<OauthRefreshToken> findList(OauthRefreshToken oauthRefreshToken);

    // 分页条件查询
    PageInfo<OauthRefreshToken> findPage(OauthRefreshToken oauthRefreshToken, int page, int size);

    OauthRefreshToken findById(Integer id);

    void add(OauthRefreshToken oauthRefreshToken);

    void update(OauthRefreshToken oauthRefreshToken);

    void delete(Integer id);

}
