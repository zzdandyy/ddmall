package pro.doublez.ddmall.service.user.controller;

import com.github.pagehelper.PageInfo;
import org.springframework.web.bind.annotation.*;
import pro.doublez.ddmall.common.pojo.Result;
import pro.doublez.ddmall.common.pojo.StatusCode;
import pro.doublez.ddmall.service.user.service.ParaService;
import pro.doublez.ddmall.user.pojo.Para;

import javax.annotation.Resource;
import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/para")
public class ParaController {

    @Resource
    private ParaService paraService;

    /**
     * 列表查询
     * @param para 查询条件
     * @return Result对象
     */
    @GetMapping
    public Result<List<Para>> findList(Para para) {
        List<Para> paraList = paraService.findList(para);
        return new Result<>(true, StatusCode.OK, "查询成功", paraList);
    }

    /**
     * 分页查询
     * @param page 页码
     * @param size 每页显示条数
     * @param para 查询条件
     * @return Result对象
     */
    @GetMapping("/{page}/{size}")
    public Result findPage(@PathVariable int page,@PathVariable int size,Para para){
        PageInfo<Para> pageInfo = paraService.findPage(para, page, size);
        return new Result(true,StatusCode.OK,"查询成功",pageInfo);
    }

    /**
     * id查询
     * @param id 查询对象的id
     * @return Result对象
     */
    @GetMapping("/{id}")
    public Result<Para> findById(@PathVariable Integer id) {
        Para para = paraService.findById(id);
        return new Result<>(true, StatusCode.OK, "查询成功", para);
    }

    /**
     * 添加
     * @param para 对象
     * @return Result对象
     */
    @PostMapping
    public Result add(Para para) {
        paraService.add(para);
        return new Result(true, StatusCode.OK, "添加成功");
    }

    /**
     * 修改
     * @param id 修改对象的id
     * @param para 修改项
     * @return Result对象
     */
    @PutMapping("/{id}")
    public Result update(@PathVariable Integer id, Para para) {
        para.setId(id);
        paraService.update(para);
        return new Result(true, StatusCode.OK, "修改成功");
    }

    /**
     * 删除
     * @param id 删除对象的id
     * @return Result对象
     */
    @DeleteMapping("/{id}")
    public Result deleteById(@PathVariable Integer id){
        paraService.delete(id);
        return new Result(true, StatusCode.OK, "删除成功");
    }
}
