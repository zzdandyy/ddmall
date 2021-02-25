package pro.doublez.ddmall.service.config.dao;

import org.apache.ibatis.annotations.Mapper;
import pro.doublez.ddmall.config.pojo.OauthAccessToken;

import java.util.List;


@Mapper
public interface OauthAccessTokenMapper {

    List<OauthAccessToken> findList(OauthAccessToken oauthAccessToken);

    OauthAccessToken findById(Integer id);

    void add(OauthAccessToken oauthAccessToken);

    void update(OauthAccessToken oauthAccessToken);

    void delete(Integer id);

}

