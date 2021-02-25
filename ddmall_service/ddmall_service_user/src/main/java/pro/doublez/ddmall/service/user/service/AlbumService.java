package pro.doublez.ddmall.service.user.service;

import com.github.pagehelper.PageInfo;
import pro.doublez.ddmall.user.pojo.Album;

import java.util.List;

public interface AlbumService {

    // 条件查询
    List<Album> findList(Album album);

    // 分页条件查询
    PageInfo<Album> findPage(Album album, int page, int size);

    Album findById(Integer id);

    void add(Album album);

    void update(Album album);

    void delete(Integer id);

}
