package pro.doublez.ddmall.service.system.controller;

import com.github.pagehelper.PageInfo;
import org.springframework.web.bind.annotation.*;
import pro.doublez.ddmall.common.pojo.Result;
import pro.doublez.ddmall.common.pojo.StatusCode;
import pro.doublez.ddmall.service.system.service.ResourceMenuService;
import pro.doublez.ddmall.system.pojo.ResourceMenu;

import javax.annotation.Resource;
import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/resourceMenu")
public class ResourceMenuController {

    @Resource
    private ResourceMenuService resourceMenuService;

    /**
     * 列表查询
     * @param resourceMenu 查询条件
     * @return Result对象
     */
    @GetMapping
    public Result<List<ResourceMenu>> findList(ResourceMenu resourceMenu) {
        List<ResourceMenu> resourceMenuList = resourceMenuService.findList(resourceMenu);
        return new Result<>(true, StatusCode.OK, "查询成功", resourceMenuList);
    }

    /**
     * 分页查询
     * @param page 页码
     * @param size 每页显示条数
     * @param resourceMenu 查询条件
     * @return Result对象
     */
    @GetMapping("/{page}/{size}")
    public Result findPage(@PathVariable int page,@PathVariable int size,ResourceMenu resourceMenu){
        PageInfo<ResourceMenu> pageInfo = resourceMenuService.findPage(resourceMenu, page, size);
        return new Result(true,StatusCode.OK,"查询成功",pageInfo);
    }

//    /**
//     * id查询
//     * @param id 查询对象的id
//     * @return Result对象
//     */
//    @GetMapping("/{id}")
//    public Result<ResourceMenu> findById(@PathVariable Integer id) {
//        ResourceMenu resourceMenu = resourceMenuService.findById(id);
//        return new Result<>(true, StatusCode.OK, "查询成功", resourceMenu);
//    }
//
    /**
     * 添加
     * @param resourceMenu 对象
     * @return Result对象
     */
    @PostMapping
    public Result add(ResourceMenu resourceMenu) {
        resourceMenuService.add(resourceMenu);
        return new Result(true, StatusCode.OK, "添加成功");
    }
//
//    /**
//     * 修改
//     * @param id 修改对象的id
//     * @param resourceMenu 修改项
//     * @return Result对象
//     */
//    @PutMapping("/{id}")
//    public Result update(@PathVariable Integer id, ResourceMenu resourceMenu) {
//        resourceMenu.setId(id);
//        resourceMenuService.update(resourceMenu);
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
//        resourceMenuService.delete(id);
//        return new Result(true, StatusCode.OK, "删除成功");
//    }
}
