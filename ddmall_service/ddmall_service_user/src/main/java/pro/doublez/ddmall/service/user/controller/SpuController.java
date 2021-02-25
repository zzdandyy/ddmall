package pro.doublez.ddmall.service.user.controller;

import com.github.pagehelper.PageInfo;
import org.springframework.web.bind.annotation.*;
import pro.doublez.ddmall.common.pojo.Result;
import pro.doublez.ddmall.common.pojo.StatusCode;
import pro.doublez.ddmall.service.user.service.SpuService;
import pro.doublez.ddmall.user.pojo.Spu;

import javax.annotation.Resource;
import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/spu")
public class SpuController {

    @Resource
    private SpuService spuService;

    /**
     * 列表查询
     * @param spu 查询条件
     * @return Result对象
     */
    @GetMapping
    public Result<List<Spu>> findList(Spu spu) {
        List<Spu> spuList = spuService.findList(spu);
        return new Result<>(true, StatusCode.OK, "查询成功", spuList);
    }

    /**
     * 分页查询
     * @param page 页码
     * @param size 每页显示条数
     * @param spu 查询条件
     * @return Result对象
     */
    @GetMapping("/{page}/{size}")
    public Result findPage(@PathVariable int page,@PathVariable int size,Spu spu){
        PageInfo<Spu> pageInfo = spuService.findPage(spu, page, size);
        return new Result(true,StatusCode.OK,"查询成功",pageInfo);
    }

    /**
     * id查询
     * @param id 查询对象的id
     * @return Result对象
     */
    @GetMapping("/{id}")
    public Result<Spu> findById(@PathVariable Integer id) {
        Spu spu = spuService.findById(id);
        return new Result<>(true, StatusCode.OK, "查询成功", spu);
    }

    /**
     * 添加
     * @param spu 对象
     * @return Result对象
     */
    @PostMapping
    public Result add(Spu spu) {
        spuService.add(spu);
        return new Result(true, StatusCode.OK, "添加成功");
    }

    /**
     * 修改
     * @param id 修改对象的id
     * @param spu 修改项
     * @return Result对象
     */
    @PutMapping("/{id}")
    public Result update(@PathVariable Long id, Spu spu) {
        spu.setId(id);
        spuService.update(spu);
        return new Result(true, StatusCode.OK, "修改成功");
    }

    /**
     * 删除
     * @param id 删除对象的id
     * @return Result对象
     */
    @DeleteMapping("/{id}")
    public Result deleteById(@PathVariable Integer id){
        spuService.delete(id);
        return new Result(true, StatusCode.OK, "删除成功");
    }
}
