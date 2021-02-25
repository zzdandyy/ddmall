package pro.doublez.ddmall.service.system.controller;

import com.github.pagehelper.PageInfo;
import org.springframework.web.bind.annotation.*;
import pro.doublez.ddmall.common.pojo.Result;
import pro.doublez.ddmall.common.pojo.StatusCode;
import pro.doublez.ddmall.service.system.service.RoleService;
import pro.doublez.ddmall.system.pojo.Role;

import javax.annotation.Resource;
import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/role")
public class RoleController {

    @Resource
    private RoleService roleService;

    /**
     * 列表查询
     * @param role 查询条件
     * @return Result对象
     */
    @GetMapping
    public Result<List<Role>> findList(Role role) {
        List<Role> roleList = roleService.findList(role);
        return new Result<>(true, StatusCode.OK, "查询成功", roleList);
    }

    /**
     * 分页查询
     * @param page 页码
     * @param size 每页显示条数
     * @param role 查询条件
     * @return Result对象
     */
    @GetMapping("/{page}/{size}")
    public Result findPage(@PathVariable int page,@PathVariable int size,Role role){
        PageInfo<Role> pageInfo = roleService.findPage(role, page, size);
        return new Result(true,StatusCode.OK,"查询成功",pageInfo);
    }

    /**
     * id查询
     * @param id 查询对象的id
     * @return Result对象
     */
    @GetMapping("/{id}")
    public Result<Role> findById(@PathVariable Integer id) {
        Role role = roleService.findById(id);
        return new Result<>(true, StatusCode.OK, "查询成功", role);
    }

    /**
     * 添加
     * @param role 对象
     * @return Result对象
     */
    @PostMapping
    public Result add(Role role) {
        roleService.add(role);
        return new Result(true, StatusCode.OK, "添加成功");
    }

    /**
     * 修改
     * @param id 修改对象的id
     * @param role 修改项
     * @return Result对象
     */
    @PutMapping("/{id}")
    public Result update(@PathVariable Integer id, Role role) {
        role.setId(id);
        roleService.update(role);
        return new Result(true, StatusCode.OK, "修改成功");
    }

    /**
     * 删除
     * @param id 删除对象的id
     * @return Result对象
     */
    @DeleteMapping("/{id}")
    public Result deleteById(@PathVariable Integer id){
        roleService.delete(id);
        return new Result(true, StatusCode.OK, "删除成功");
    }
}
