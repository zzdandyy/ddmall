package pro.doublez.ddmall.service.user.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Service;
import pro.doublez.ddmall.service.user.dao.AlbumMapper;
import pro.doublez.ddmall.service.user.service.AlbumService;
import pro.doublez.ddmall.user.pojo.Album;

import javax.annotation.Resource;
import java.util.List;

@Service
public class AlbumServiceImpl implements AlbumService {

    @Resource
    private AlbumMapper albumMapper;

    @Override
    public List<Album> findList(Album album) {
        return albumMapper.findList(album);
    }

    @Override
    public PageInfo<Album> findPage(Album album,int page,int size) {
        PageHelper.startPage(page, size);
        List<Album> all = albumMapper.findList(album);
        return new PageInfo<>(all);
    }

    @Override
    public Album findById(Integer id) {
        return albumMapper.findById(id);
    }

    @Override
    public void add(Album album) {
        albumMapper.add(album);
    }

    @Override
    public void update(Album album) {
        albumMapper.update(album);
    }

    @Override
    public void delete(Integer id) {
        albumMapper.delete(id);
    }
}
