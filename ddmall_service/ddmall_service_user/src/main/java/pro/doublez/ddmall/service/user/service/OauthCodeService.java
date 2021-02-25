package pro.doublez.ddmall.service.user.service;

import com.github.pagehelper.PageInfo;
import pro.doublez.ddmall.user.pojo.OauthCode;

import java.util.List;

public interface OauthCodeService {

    // 条件查询
    List<OauthCode> findList(OauthCode oauthCode);

    // 分页条件查询
    PageInfo<OauthCode> findPage(OauthCode oauthCode, int page, int size);

    OauthCode findById(Integer id);

    void add(OauthCode oauthCode);

    void update(OauthCode oauthCode);

    void delete(Integer id);

}
