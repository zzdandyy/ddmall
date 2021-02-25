package pro.doublez.ddmall.service.user.controller;

import com.github.pagehelper.PageInfo;
import org.springframework.web.bind.annotation.*;
import pro.doublez.ddmall.common.pojo.Result;
import pro.doublez.ddmall.common.pojo.StatusCode;
import pro.doublez.ddmall.service.user.service.PrefService;
import pro.doublez.ddmall.user.pojo.Pref;

import javax.annotation.Resource;
import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/pref")
public class PrefController {

    @Resource
    private PrefService prefService;

    /**
     * 列表查询
     * @param pref 查询条件
     * @return Result对象
     */
    @GetMapping
    public Result<List<Pref>> findList(Pref pref) {
        List<Pref> prefList = prefService.findList(pref);
        return new Result<>(true, StatusCode.OK, "查询成功", prefList);
    }

    /**
     * 分页查询
     * @param page 页码
     * @param size 每页显示条数
     * @param pref 查询条件
     * @return Result对象
     */
    @GetMapping("/{page}/{size}")
    public Result findPage(@PathVariable int page,@PathVariable int size,Pref pref){
        PageInfo<Pref> pageInfo = prefService.findPage(pref, page, size);
        return new Result(true,StatusCode.OK,"查询成功",pageInfo);
    }

    /**
     * id查询
     * @param id 查询对象的id
     * @return Result对象
     */
    @GetMapping("/{id}")
    public Result<Pref> findById(@PathVariable Integer id) {
        Pref pref = prefService.findById(id);
        return new Result<>(true, StatusCode.OK, "查询成功", pref);
    }

    /**
     * 添加
     * @param pref 对象
     * @return Result对象
     */
    @PostMapping
    public Result add(Pref pref) {
        prefService.add(pref);
        return new Result(true, StatusCode.OK, "添加成功");
    }

    /**
     * 修改
     * @param id 修改对象的id
     * @param pref 修改项
     * @return Result对象
     */
    @PutMapping("/{id}")
    public Result update(@PathVariable Integer id, Pref pref) {
        pref.setId(id);
        prefService.update(pref);
        return new Result(true, StatusCode.OK, "修改成功");
    }

    /**
     * 删除
     * @param id 删除对象的id
     * @return Result对象
     */
    @DeleteMapping("/{id}")
    public Result deleteById(@PathVariable Integer id){
        prefService.delete(id);
        return new Result(true, StatusCode.OK, "删除成功");
    }
}
