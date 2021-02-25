package pro.doublez.ddmall.service.user.controller;

import com.github.pagehelper.PageInfo;
import org.springframework.web.bind.annotation.*;
import pro.doublez.ddmall.common.pojo.Result;
import pro.doublez.ddmall.common.pojo.StatusCode;
import pro.doublez.ddmall.service.user.service.SkuService;
import pro.doublez.ddmall.user.pojo.Sku;

import javax.annotation.Resource;
import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/sku")
public class SkuController {

    @Resource
    private SkuService skuService;

    /**
     * 列表查询
     * @param sku 查询条件
     * @return Result对象
     */
    @GetMapping
    public Result<List<Sku>> findList(Sku sku) {
        List<Sku> skuList = skuService.findList(sku);
        return new Result<>(true, StatusCode.OK, "查询成功", skuList);
    }

    /**
     * 分页查询
     * @param page 页码
     * @param size 每页显示条数
     * @param sku 查询条件
     * @return Result对象
     */
    @GetMapping("/{page}/{size}")
    public Result findPage(@PathVariable int page,@PathVariable int size,Sku sku){
        PageInfo<Sku> pageInfo = skuService.findPage(sku, page, size);
        return new Result(true,StatusCode.OK,"查询成功",pageInfo);
    }

    /**
     * id查询
     * @param id 查询对象的id
     * @return Result对象
     */
    @GetMapping("/{id}")
    public Result<Sku> findById(@PathVariable Integer id) {
        Sku sku = skuService.findById(id);
        return new Result<>(true, StatusCode.OK, "查询成功", sku);
    }

    /**
     * 添加
     * @param sku 对象
     * @return Result对象
     */
    @PostMapping
    public Result add(Sku sku) {
        skuService.add(sku);
        return new Result(true, StatusCode.OK, "添加成功");
    }

    /**
     * 修改
     * @param id 修改对象的id
     * @param sku 修改项
     * @return Result对象
     */
    @PutMapping("/{id}")
    public Result update(@PathVariable Long id, Sku sku) {
        sku.setId(id);
        skuService.update(sku);
        return new Result(true, StatusCode.OK, "修改成功");
    }

    /**
     * 删除
     * @param id 删除对象的id
     * @return Result对象
     */
    @DeleteMapping("/{id}")
    public Result deleteById(@PathVariable Integer id){
        skuService.delete(id);
        return new Result(true, StatusCode.OK, "删除成功");
    }
}
