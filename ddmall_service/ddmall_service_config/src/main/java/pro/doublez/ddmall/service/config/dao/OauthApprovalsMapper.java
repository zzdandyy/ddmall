package pro.doublez.ddmall.service.config.dao;

import org.apache.ibatis.annotations.Mapper;
import pro.doublez.ddmall.config.pojo.OauthApprovals;

import java.util.List;


@Mapper
public interface OauthApprovalsMapper {

    List<OauthApprovals> findList(OauthApprovals oauthApprovals);

    OauthApprovals findById(Integer id);

    void add(OauthApprovals oauthApprovals);

    void update(OauthApprovals oauthApprovals);

    void delete(Integer id);

}

