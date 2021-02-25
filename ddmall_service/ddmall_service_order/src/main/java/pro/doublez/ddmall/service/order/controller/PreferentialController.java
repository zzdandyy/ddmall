package pro.doublez.ddmall.service.order.controller;

import pro.doublez.ddmall.order.pojo.Preferential;
import com.github.pagehelper.PageInfo;
import org.springframework.web.bind.annotation.*;
import pro.doublez.ddmall.common.pojo.Result;
import pro.doublez.ddmall.common.pojo.StatusCode;
import pro.doublez.ddmall.service.order.service.PreferentialService;

import javax.annotation.Resource;
import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/preferential")
public class PreferentialController {

    @Resource
    private PreferentialService preferentialService;

    /**
     * 列表查询
     * @param preferential 查询条件
     * @return Result对象
     */
    @GetMapping
    public Result<List<Preferential>> findList(Preferential preferential) {
        List<Preferential> preferentialList = preferentialService.findList(preferential);
        return new Result<>(true, StatusCode.OK, "查询成功", preferentialList);
    }

    /**
     * 分页查询
     * @param page 页码
     * @param size 每页显示条数
     * @param preferential 查询条件
     * @return Result对象
     */
    @GetMapping("/{page}/{size}")
    public Result findPage(@PathVariable int page,@PathVariable int size,Preferential preferential){
        PageInfo<Preferential> pageInfo = preferentialService.findPage(preferential, page, size);
        return new Result(true,StatusCode.OK,"查询成功",pageInfo);
    }

    /**
     * id查询
     * @param id 查询对象的id
     * @return Result对象
     */
    @GetMapping("/{id}")
    public Result<Preferential> findById(@PathVariable Integer id) {
        Preferential preferential = preferentialService.findById(id);
        return new Result<>(true, StatusCode.OK, "查询成功", preferential);
    }

    /**
     * 添加
     * @param preferential 对象
     * @return Result对象
     */
    @PostMapping
    public Result add(Preferential preferential) {
        preferentialService.add(preferential);
        return new Result(true, StatusCode.OK, "添加成功");
    }

    /**
     * 修改
     * @param id 修改对象的id
     * @param preferential 修改项
     * @return Result对象
     */
    @PutMapping("/{id}")
    public Result update(@PathVariable Integer id, Preferential preferential) {
        preferential.setId(id);
        preferentialService.update(preferential);
        return new Result(true, StatusCode.OK, "修改成功");
    }

    /**
     * 删除
     * @param id 删除对象的id
     * @return Result对象
     */
    @DeleteMapping("/{id}")
    public Result deleteById(@PathVariable Integer id){
        preferentialService.delete(id);
        return new Result(true, StatusCode.OK, "删除成功");
    }
}
