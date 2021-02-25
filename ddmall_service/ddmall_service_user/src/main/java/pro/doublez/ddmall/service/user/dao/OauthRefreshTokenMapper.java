package pro.doublez.ddmall.service.user.dao;

import org.apache.ibatis.annotations.Mapper;
import pro.doublez.ddmall.user.pojo.OauthRefreshToken;

import java.util.List;


@Mapper
public interface OauthRefreshTokenMapper {

    List<OauthRefreshToken> findList(OauthRefreshToken oauthRefreshToken);

    OauthRefreshToken findById(Integer id);

    void add(OauthRefreshToken oauthRefreshToken);

    void update(OauthRefreshToken oauthRefreshToken);

    void delete(Integer id);

}

