package pro.doublez.ddmall.service.user.dao;

import org.apache.ibatis.annotations.Mapper;
import pro.doublez.ddmall.user.pojo.OauthClientToken;

import java.util.List;


@Mapper
public interface OauthClientTokenMapper {

    List<OauthClientToken> findList(OauthClientToken oauthClientToken);

    OauthClientToken findById(Integer id);

    void add(OauthClientToken oauthClientToken);

    void update(OauthClientToken oauthClientToken);

    void delete(Integer id);

}

