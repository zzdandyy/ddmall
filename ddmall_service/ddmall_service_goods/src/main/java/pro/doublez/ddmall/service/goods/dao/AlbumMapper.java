package pro.doublez.ddmall.service.goods.dao;


import com.github.pagehelper.PageInfo;
import org.apache.ibatis.annotations.Mapper;
import pro.doublez.ddmall.goods.pojo.Album;

import java.util.List;


@Mapper
public interface AlbumMapper  {

    List<Album> findList(Album album);

    Album findById(Long id);

    void add(Album album);

    void update(Album album);

    void delete(Long id);
}
