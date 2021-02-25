package pro.doublez.ddmall.service.user.service;

import com.github.pagehelper.PageInfo;
import pro.doublez.ddmall.user.pojo.OauthApprovals;

import java.util.List;

public interface OauthApprovalsService {

    // 条件查询
    List<OauthApprovals> findList(OauthApprovals oauthApprovals);

    // 分页条件查询
    PageInfo<OauthApprovals> findPage(OauthApprovals oauthApprovals, int page, int size);

    OauthApprovals findById(Integer id);

    void add(OauthApprovals oauthApprovals);

    void update(OauthApprovals oauthApprovals);

    void delete(Integer id);

}
