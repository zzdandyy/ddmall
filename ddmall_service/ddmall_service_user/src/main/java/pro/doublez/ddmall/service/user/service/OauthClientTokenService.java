package pro.doublez.ddmall.service.user.service;

import com.github.pagehelper.PageInfo;
import pro.doublez.ddmall.user.pojo.OauthClientToken;

import java.util.List;

public interface OauthClientTokenService {

    // 条件查询
    List<OauthClientToken> findList(OauthClientToken oauthClientToken);

    // 分页条件查询
    PageInfo<OauthClientToken> findPage(OauthClientToken oauthClientToken, int page, int size);

    OauthClientToken findById(Integer id);

    void add(OauthClientToken oauthClientToken);

    void update(OauthClientToken oauthClientToken);

    void delete(Integer id);

}
