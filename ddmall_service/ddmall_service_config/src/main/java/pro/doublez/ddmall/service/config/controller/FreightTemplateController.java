package pro.doublez.ddmall.service.config.controller;

import com.github.pagehelper.PageInfo;
import org.springframework.web.bind.annotation.*;
import pro.doublez.ddmall.common.pojo.Result;
import pro.doublez.ddmall.common.pojo.StatusCode;
import pro.doublez.ddmall.config.pojo.FreightTemplate;
import pro.doublez.ddmall.service.config.service.FreightTemplateService;

import javax.annotation.Resource;
import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/freightTemplate")
public class FreightTemplateController {

    @Resource
    private FreightTemplateService freightTemplateService;

    /**
     * 列表查询
     * @param freightTemplate 查询条件
     * @return Result对象
     */
    @GetMapping
    public Result<List<FreightTemplate>> findList(FreightTemplate freightTemplate) {
        List<FreightTemplate> freightTemplateList = freightTemplateService.findList(freightTemplate);
        return new Result<>(true, StatusCode.OK, "查询成功", freightTemplateList);
    }

    /**
     * 分页查询
     * @param page 页码
     * @param size 每页显示条数
     * @param freightTemplate 查询条件
     * @return Result对象
     */
    @GetMapping("/{page}/{size}")
    public Result findPage(@PathVariable int page,@PathVariable int size,FreightTemplate freightTemplate){
        PageInfo<FreightTemplate> pageInfo = freightTemplateService.findPage(freightTemplate, page, size);
        return new Result(true,StatusCode.OK,"查询成功",pageInfo);
    }

    /**
     * id查询
     * @param id 查询对象的id
     * @return Result对象
     */
    @GetMapping("/{id}")
    public Result<FreightTemplate> findById(@PathVariable Integer id) {
        FreightTemplate freightTemplate = freightTemplateService.findById(id);
        return new Result<>(true, StatusCode.OK, "查询成功", freightTemplate);
    }

    /**
     * 添加
     * @param freightTemplate 对象
     * @return Result对象
     */
    @PostMapping
    public Result add(FreightTemplate freightTemplate) {
        freightTemplateService.add(freightTemplate);
        return new Result(true, StatusCode.OK, "添加成功");
    }

    /**
     * 修改
     * @param id 修改对象的id
     * @param freightTemplate 修改项
     * @return Result对象
     */
    @PutMapping("/{id}")
    public Result update(@PathVariable Integer id, FreightTemplate freightTemplate) {
        freightTemplate.setId(id);
        freightTemplateService.update(freightTemplate);
        return new Result(true, StatusCode.OK, "修改成功");
    }

    /**
     * 删除
     * @param id 删除对象的id
     * @return Result对象
     */
    @DeleteMapping("/{id}")
    public Result deleteById(@PathVariable Integer id){
        freightTemplateService.delete(id);
        return new Result(true, StatusCode.OK, "删除成功");
    }
}
