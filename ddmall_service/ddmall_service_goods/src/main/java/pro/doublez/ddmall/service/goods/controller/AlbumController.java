package pro.doublez.ddmall.service.goods.controller;

//import pro.doublez.ddmall.goods.pojo.Album;
import com.github.pagehelper.PageInfo;
import org.springframework.web.bind.annotation.*;
import pro.doublez.ddmall.common.pojo.Result;
import pro.doublez.ddmall.common.pojo.StatusCode;
import pro.doublez.ddmall.goods.pojo.Album;
import pro.doublez.ddmall.service.goods.service.AlbumService;

import javax.annotation.Resource;
import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/album")
public class AlbumController {

    @Resource
    private AlbumService albumService;
    
    /**
     * 列表查询
     * @param album 查询条件
     * @return Result对象
     */
    @GetMapping
    public Result<List<Album>> findList(Album album) {
        List<Album> albumList = albumService.findList(album);
        return new Result<>(true, StatusCode.OK, "查询成功", albumList);
    }

    /**
     * 分页查询
     * @param page 页码
     * @param size 每页显示条数
     * @param album 查询条件
     * @return Result对象
     */
    @GetMapping("/{page}/{size}")
    public Result findPage(@PathVariable int page,@PathVariable int size,Album album){
        PageInfo<Album> pageInfo = albumService.findPage(album, page, size);
        return new Result(true,StatusCode.OK,"查询成功",pageInfo);
    }

    /**
     * id查询
     * @param id 查询对象的id
     * @return Result对象
     */
    @GetMapping("/{id}")
    public Result<Album> findById(@PathVariable Long id) {
        Album album = albumService.findById(id);
        return new Result<>(true, StatusCode.OK, "查询成功", album);
    }

    /**
     * 添加
     * @param album 对象
     * @return Result对象
     */
    @PostMapping
    public Result add(Album album) {
        albumService.add(album);
        return new Result(true, StatusCode.OK, "添加成功");
    }

    /**
     * 修改
     * @param id 修改对象的id
     * @param album 修改项
     * @return Result对象
     */
    @PutMapping("/{id}")
    public Result update(@PathVariable Long id, Album album) {
        album.setId(id);
        albumService.update(album);
        return new Result(true, StatusCode.OK, "修改成功");
    }

    /**
     * 删除
     * @param id 删除对象的id
     * @return Result对象
     */
    @DeleteMapping("/{id}")
    public Result deleteById(@PathVariable Long id){
        albumService.delete(id);
        return new Result(true, StatusCode.OK, "删除成功");
    }
}
