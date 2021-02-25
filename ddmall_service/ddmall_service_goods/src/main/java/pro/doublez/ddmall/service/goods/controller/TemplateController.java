package pro.doublez.ddmall.service.goods.controller;

import pro.doublez.ddmall.goods.pojo.Template;
import com.github.pagehelper.PageInfo;
import org.springframework.web.bind.annotation.*;
import pro.doublez.ddmall.common.pojo.Result;
import pro.doublez.ddmall.common.pojo.StatusCode;
import pro.doublez.ddmall.service.goods.service.TemplateService;

import javax.annotation.Resource;
import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/template")
public class TemplateController {

    @Resource
    private TemplateService templateService;

    /**
     * 列表查询
     * @param template 查询条件
     * @return Result对象
     */
    @GetMapping
    public Result<List<Template>> findList(Template template) {
        List<Template> templateList = templateService.findList(template);
        return new Result<>(true, StatusCode.OK, "查询成功", templateList);
    }

    /**
     * 分页查询
     * @param page 页码
     * @param size 每页显示条数
     * @param template 查询条件
     * @return Result对象
     */
    @GetMapping("/{page}/{size}")
    public Result findPage(@PathVariable int page,@PathVariable int size,Template template){
        PageInfo<Template> pageInfo = templateService.findPage(template, page, size);
        return new Result(true,StatusCode.OK,"查询成功",pageInfo);
    }

    /**
     * id查询
     * @param id 查询对象的id
     * @return Result对象
     */
    @GetMapping("/{id}")
    public Result<Template> findById(@PathVariable Integer id) {
        Template template = templateService.findById(id);
        return new Result<>(true, StatusCode.OK, "查询成功", template);
    }

    /**
     * 添加
     * @param template 对象
     * @return Result对象
     */
    @PostMapping
    public Result add(Template template) {
        templateService.add(template);
        return new Result(true, StatusCode.OK, "添加成功");
    }

    /**
     * 修改
     * @param id 修改对象的id
     * @param template 修改项
     * @return Result对象
     */
    @PutMapping("/{id}")
    public Result update(@PathVariable Integer id, Template template) {
        template.setId(id);
        templateService.update(template);
        return new Result(true, StatusCode.OK, "修改成功");
    }

    /**
     * 删除
     * @param id 删除对象的id
     * @return Result对象
     */
    @DeleteMapping("/{id}")
    public Result deleteById(@PathVariable Integer id){
        templateService.delete(id);
        return new Result(true, StatusCode.OK, "删除成功");
    }
}
