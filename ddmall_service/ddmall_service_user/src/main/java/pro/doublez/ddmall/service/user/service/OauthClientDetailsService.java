package pro.doublez.ddmall.service.user.service;

import com.github.pagehelper.PageInfo;
import pro.doublez.ddmall.user.pojo.OauthClientDetails;

import java.util.List;

public interface OauthClientDetailsService {

    // 条件查询
    List<OauthClientDetails> findList(OauthClientDetails oauthClientDetails);

    // 分页条件查询
    PageInfo<OauthClientDetails> findPage(OauthClientDetails oauthClientDetails, int page, int size);

    OauthClientDetails findById(Integer id);

    void add(OauthClientDetails oauthClientDetails);

    void update(OauthClientDetails oauthClientDetails);

    void delete(Integer id);

}
