package pro.doublez.ddmall.service.business.controller;

import com.github.pagehelper.PageInfo;
import org.springframework.web.bind.annotation.*;
import pro.doublez.ddmall.business.pojo.Ad;
import pro.doublez.ddmall.common.pojo.Result;
import pro.doublez.ddmall.common.pojo.StatusCode;
import pro.doublez.ddmall.service.business.service.AdService;

import javax.annotation.Resource;
import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/ad")
public class AdController {

    @Resource
    private AdService adService;

    /**
     * 列表查询
     * @param ad 查询条件
     * @return Result对象
     */
    @GetMapping
    public Result<List<Ad>> findList(Ad ad) {
        List<Ad> adList = adService.findList(ad);
        return new Result<>(true, StatusCode.OK, "查询成功", adList);
    }

    /**
     * 分页查询
     * @param page 页码
     * @param size 每页显示条数
     * @param ad 查询条件
     * @return Result对象
     */
    @GetMapping("/{page}/{size}")
    public Result findPage(@PathVariable int page,@PathVariable int size,Ad ad){
        PageInfo<Ad> pageInfo = adService.findPage(ad, page, size);
        return new Result(true,StatusCode.OK,"查询成功",pageInfo);
    }

    /**
     * id查询
     * @param id 查询对象的id
     * @return Result对象
     */
    @GetMapping("/{id}")
    public Result<Ad> findById(@PathVariable Integer id) {
        Ad ad = adService.findById(id);
        return new Result<>(true, StatusCode.OK, "查询成功", ad);
    }

    /**
     * 添加
     * @param ad 对象
     * @return Result对象
     */
    @PostMapping
    public Result add(Ad ad) {
        adService.add(ad);
        return new Result(true, StatusCode.OK, "添加成功");
    }

    /**
     * 修改
     * @param id 修改对象的id
     * @param ad 修改项
     * @return Result对象
     */
    @PutMapping("/{id}")
    public Result update(@PathVariable Integer id, Ad ad) {
        ad.setId(id);
        adService.update(ad);
        return new Result(true, StatusCode.OK, "修改成功");
    }

    /**
     * 删除
     * @param id 删除对象的id
     * @return Result对象
     */
    @DeleteMapping("/{id}")
    public Result deleteById(@PathVariable Integer id){
        adService.delete(id);
        return new Result(true, StatusCode.OK, "删除成功");
    }
}
