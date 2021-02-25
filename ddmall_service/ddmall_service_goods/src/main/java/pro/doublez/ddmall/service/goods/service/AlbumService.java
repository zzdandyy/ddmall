package pro.doublez.ddmall.service.goods.service;



import com.github.pagehelper.PageInfo;
import pro.doublez.ddmall.goods.pojo.Album;
import pro.doublez.ddmall.goods.pojo.Brand;

import java.util.List;
import java.util.Map;

public interface AlbumService {

    // 条件查询
    List<Album> findList(Album album);

    // 分页条件查询
    PageInfo<Album> findPage(Album album, int page, int size);

    Album findById(Long id);

    void add(Album album);

    void update(Album album);

    void delete(Long id);

}
