package pro.doublez.ddmall.service.config.service;

import com.github.pagehelper.PageInfo;
import pro.doublez.ddmall.config.pojo.OauthAccessToken;

import java.util.List;

public interface OauthAccessTokenService {

    // 条件查询
    List<OauthAccessToken> findList(OauthAccessToken oauthAccessToken);

    // 分页条件查询
    PageInfo<OauthAccessToken> findPage(OauthAccessToken oauthAccessToken, int page, int size);

    OauthAccessToken findById(Integer id);

    void add(OauthAccessToken oauthAccessToken);

    void update(OauthAccessToken oauthAccessToken);

    void delete(Integer id);

}
