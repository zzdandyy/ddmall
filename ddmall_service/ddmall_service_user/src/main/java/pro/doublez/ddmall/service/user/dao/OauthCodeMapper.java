package pro.doublez.ddmall.service.user.dao;

import org.apache.ibatis.annotations.Mapper;
import pro.doublez.ddmall.user.pojo.OauthCode;

import java.util.List;


@Mapper
public interface OauthCodeMapper {

    List<OauthCode> findList(OauthCode oauthCode);

    OauthCode findById(Integer id);

    void add(OauthCode oauthCode);

    void update(OauthCode oauthCode);

    void delete(Integer id);

}

