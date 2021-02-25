package pro.doublez.ddmall.service.system.controller;

import com.github.pagehelper.PageInfo;
import org.springframework.web.bind.annotation.*;
import pro.doublez.ddmall.common.pojo.Result;
import pro.doublez.ddmall.common.pojo.StatusCode;
import pro.doublez.ddmall.service.system.service.MenuService;
import pro.doublez.ddmall.system.pojo.Menu;

import javax.annotation.Resource;
import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/menu")
public class MenuController {

    @Resource
    private MenuService menuService;

    /**
     * 列表查询
     * @param menu 查询条件
     * @return Result对象
     */
    @GetMapping
    public Result<List<Menu>> findList(Menu menu) {
        List<Menu> menuList = menuService.findList(menu);
        return new Result<>(true, StatusCode.OK, "查询成功", menuList);
    }

    /**
     * 分页查询
     * @param page 页码
     * @param size 每页显示条数
     * @param menu 查询条件
     * @return Result对象
     */
    @GetMapping("/{page}/{size}")
    public Result findPage(@PathVariable int page,@PathVariable int size,Menu menu){
        PageInfo<Menu> pageInfo = menuService.findPage(menu, page, size);
        return new Result(true,StatusCode.OK,"查询成功",pageInfo);
    }

    /**
     * id查询
     * @param id 查询对象的id
     * @return Result对象
     */
    @GetMapping("/{id}")
    public Result<Menu> findById(@PathVariable Integer id) {
        Menu menu = menuService.findById(id);
        return new Result<>(true, StatusCode.OK, "查询成功", menu);
    }

    /**
     * 添加
     * @param menu 对象
     * @return Result对象
     */
    @PostMapping
    public Result add(Menu menu) {
        menuService.add(menu);
        return new Result(true, StatusCode.OK, "添加成功");
    }

    /**
     * 修改
     * @param id 修改对象的id
     * @param menu 修改项
     * @return Result对象
     */
    @PutMapping("/{id}")
    public Result update(@PathVariable String id, Menu menu) {
        menu.setId(id);
        menuService.update(menu);
        return new Result(true, StatusCode.OK, "修改成功");
    }

    /**
     * 删除
     * @param id 删除对象的id
     * @return Result对象
     */
    @DeleteMapping("/{id}")
    public Result deleteById(@PathVariable Integer id){
        menuService.delete(id);
        return new Result(true, StatusCode.OK, "删除成功");
    }
}
