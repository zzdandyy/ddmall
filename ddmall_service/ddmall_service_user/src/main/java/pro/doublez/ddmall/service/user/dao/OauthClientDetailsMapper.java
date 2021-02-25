package pro.doublez.ddmall.service.user.dao;

import org.apache.ibatis.annotations.Mapper;
import pro.doublez.ddmall.user.pojo.OauthClientDetails;

import java.util.List;


@Mapper
public interface OauthClientDetailsMapper {

    List<OauthClientDetails> findList(OauthClientDetails oauthClientDetails);

    OauthClientDetails findById(Integer id);

    void add(OauthClientDetails oauthClientDetails);

    void update(OauthClientDetails oauthClientDetails);

    void delete(Integer id);

}

