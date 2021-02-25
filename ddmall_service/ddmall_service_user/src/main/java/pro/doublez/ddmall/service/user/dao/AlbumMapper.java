package pro.doublez.ddmall.service.user.dao;

import org.apache.ibatis.annotations.Mapper;
import pro.doublez.ddmall.user.pojo.Album;

import java.util.List;


@Mapper
public interface AlbumMapper {

    List<Album> findList(Album album);

    Album findById(Integer id);

    void add(Album album);

    void update(Album album);

    void delete(Integer id);

}

