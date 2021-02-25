package pro.doublez.ddmall.service.system.controller;

import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pro.doublez.ddmall.common.pojo.Result;
import pro.doublez.ddmall.common.pojo.StatusCode;
import pro.doublez.ddmall.service.system.service.ResourceService;
import pro.doublez.ddmall.system.pojo.Resource;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/resource")
public class ResourceController {

    @Autowired
    private ResourceService resourceService;

    /**
     * 列表查询
     * @param resource 查询条件
     * @return Result对象
     */
    @GetMapping
    public Result<List<Resource>> findList(Resource resource) {
        List<Resource> resourceList = resourceService.findList(resource);
        return new Result<>(true, StatusCode.OK, "查询成功", resourceList);
    }

    /**
     * 分页查询
     * @param page 页码
     * @param size 每页显示条数
     * @param resource 查询条件
     * @return Result对象
     */
    @GetMapping("/{page}/{size}")
    public Result findPage(@PathVariable int page, @PathVariable int size, Resource resource){
        PageInfo<Resource> pageInfo = resourceService.findPage(resource, page, size);
        return new Result(true,StatusCode.OK,"查询成功",pageInfo);
    }

    /**
     * id查询
     * @param id 查询对象的id
     * @return Result对象
     */
    @GetMapping("/{id}")
    public Result<Resource> findById(@PathVariable Integer id) {
        Resource resource = resourceService.findById(id);
        return new Result<>(true, StatusCode.OK, "查询成功", resource);
    }

    /**
     * 添加
     * @param resource 对象
     * @return Result对象
     */
    @PostMapping
    public Result add(Resource resource) {
        resourceService.add(resource);
        return new Result(true, StatusCode.OK, "添加成功");
    }

    /**
     * 修改
     * @param id 修改对象的id
     * @param resource 修改项
     * @return Result对象
     */
    @PutMapping("/{id}")
    public Result update(@PathVariable Integer id, Resource resource) {
        resource.setId(id);
        resourceService.update(resource);
        return new Result(true, StatusCode.OK, "修改成功");
    }

    /**
     * 删除
     * @param id 删除对象的id
     * @return Result对象
     */
    @DeleteMapping("/{id}")
    public Result deleteById(@PathVariable Integer id){
        resourceService.delete(id);
        return new Result(true, StatusCode.OK, "删除成功");
    }
}
