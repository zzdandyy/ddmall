package pro.doublez.ddmall.service.user.controller;

import com.github.pagehelper.PageInfo;
import org.springframework.web.bind.annotation.*;
import pro.doublez.ddmall.common.pojo.Result;
import pro.doublez.ddmall.common.pojo.StatusCode;
import pro.doublez.ddmall.service.user.service.SpecService;
import pro.doublez.ddmall.user.pojo.Spec;

import javax.annotation.Resource;
import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/spec")
public class SpecController {

    @Resource
    private SpecService specService;

    /**
     * 列表查询
     * @param spec 查询条件
     * @return Result对象
     */
    @GetMapping
    public Result<List<Spec>> findList(Spec spec) {
        List<Spec> specList = specService.findList(spec);
        return new Result<>(true, StatusCode.OK, "查询成功", specList);
    }

    /**
     * 分页查询
     * @param page 页码
     * @param size 每页显示条数
     * @param spec 查询条件
     * @return Result对象
     */
    @GetMapping("/{page}/{size}")
    public Result findPage(@PathVariable int page,@PathVariable int size,Spec spec){
        PageInfo<Spec> pageInfo = specService.findPage(spec, page, size);
        return new Result(true,StatusCode.OK,"查询成功",pageInfo);
    }

    /**
     * id查询
     * @param id 查询对象的id
     * @return Result对象
     */
    @GetMapping("/{id}")
    public Result<Spec> findById(@PathVariable Integer id) {
        Spec spec = specService.findById(id);
        return new Result<>(true, StatusCode.OK, "查询成功", spec);
    }

    /**
     * 添加
     * @param spec 对象
     * @return Result对象
     */
    @PostMapping
    public Result add(Spec spec) {
        specService.add(spec);
        return new Result(true, StatusCode.OK, "添加成功");
    }

    /**
     * 修改
     * @param id 修改对象的id
     * @param spec 修改项
     * @return Result对象
     */
    @PutMapping("/{id}")
    public Result update(@PathVariable Integer id, Spec spec) {
        spec.setId(id);
        specService.update(spec);
        return new Result(true, StatusCode.OK, "修改成功");
    }

    /**
     * 删除
     * @param id 删除对象的id
     * @return Result对象
     */
    @DeleteMapping("/{id}")
    public Result deleteById(@PathVariable Integer id){
        specService.delete(id);
        return new Result(true, StatusCode.OK, "删除成功");
    }
}
