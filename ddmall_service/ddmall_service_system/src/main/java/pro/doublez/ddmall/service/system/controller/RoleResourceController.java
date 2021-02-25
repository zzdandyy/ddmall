package pro.doublez.ddmall.service.system.controller;

import com.github.pagehelper.PageInfo;
import org.springframework.web.bind.annotation.*;
import pro.doublez.ddmall.common.pojo.Result;
import pro.doublez.ddmall.common.pojo.StatusCode;
import pro.doublez.ddmall.service.system.service.RoleResourceService;
import pro.doublez.ddmall.system.pojo.RoleResource;

import javax.annotation.Resource;
import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/roleResource")
public class RoleResourceController {

    @Resource
    private RoleResourceService roleResourceService;

    /**
     * 列表查询
     * @param roleResource 查询条件
     * @return Result对象
     */
    @GetMapping
    public Result<List<RoleResource>> findList(RoleResource roleResource) {
        List<RoleResource> roleResourceList = roleResourceService.findList(roleResource);
        return new Result<>(true, StatusCode.OK, "查询成功", roleResourceList);
    }

    /**
     * 分页查询
     * @param page 页码
     * @param size 每页显示条数
     * @param roleResource 查询条件
     * @return Result对象
     */
    @GetMapping("/{page}/{size}")
    public Result findPage(@PathVariable int page,@PathVariable int size,RoleResource roleResource){
        PageInfo<RoleResource> pageInfo = roleResourceService.findPage(roleResource, page, size);
        return new Result(true,StatusCode.OK,"查询成功",pageInfo);
    }

//    /**
//     * id查询
//     * @param id 查询对象的id
//     * @return Result对象
//     */
//    @GetMapping("/{id}")
//    public Result<RoleResource> findById(@PathVariable Integer id) {
//        RoleResource roleResource = roleResourceService.findById(id);
//        return new Result<>(true, StatusCode.OK, "查询成功", roleResource);
//    }
//
    /**
     * 添加
     * @param roleResource 对象
     * @return Result对象
     */
    @PostMapping
    public Result add(RoleResource roleResource) {
        roleResourceService.add(roleResource);
        return new Result(true, StatusCode.OK, "添加成功");
    }
//
//    /**
//     * 修改
//     * @param id 修改对象的id
//     * @param roleResource 修改项
//     * @return Result对象
//     */
//    @PutMapping("/{id}")
//    public Result update(@PathVariable Integer id, RoleResource roleResource) {
//        roleResource.setId(id);
//        roleResourceService.update(roleResource);
//        return new Result(true, StatusCode.OK, "修改成功");
//    }
//
//    /**
//     * 删除
//     * @param id 删除对象的id
//     * @return Result对象
//     */
//    @DeleteMapping("/{id}")
//    public Result deleteById(@PathVariable Integer id){
//        roleResourceService.delete(id);
//        return new Result(true, StatusCode.OK, "删除成功");
//    }
}
