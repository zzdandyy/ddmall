package pro.doublez.ddmall.service.system.controller;

import com.github.pagehelper.PageInfo;
import org.springframework.web.bind.annotation.*;
import pro.doublez.ddmall.common.pojo.Result;
import pro.doublez.ddmall.common.pojo.StatusCode;
import pro.doublez.ddmall.service.system.service.AdminRoleService;
import pro.doublez.ddmall.system.pojo.AdminRole;

import javax.annotation.Resource;
import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/adminRole")
public class AdminRoleController {

    @Resource
    private AdminRoleService adminRoleService;

    /**
     * 列表查询
     * @param adminRole 查询条件
     * @return Result对象
     */
    @GetMapping
    public Result<List<AdminRole>> findList(AdminRole adminRole) {
        List<AdminRole> adminRoleList = adminRoleService.findList(adminRole);
        return new Result<>(true, StatusCode.OK, "查询成功", adminRoleList);
    }

    /**
     * 分页查询
     * @param page 页码
     * @param size 每页显示条数
     * @param adminRole 查询条件
     * @return Result对象
     */
    @GetMapping("/{page}/{size}")
    public Result findPage(@PathVariable int page,@PathVariable int size,AdminRole adminRole){
        PageInfo<AdminRole> pageInfo = adminRoleService.findPage(adminRole, page, size);
        return new Result(true,StatusCode.OK,"查询成功",pageInfo);
    }

//    /**
//     * id查询
//     * @param id 查询对象的id
//     * @return Result对象
//     */
//    @GetMapping("/{id}")
//    public Result<AdminRole> findById(@PathVariable Integer id) {
//        AdminRole adminRole = adminRoleService.findById(id);
//        return new Result<>(true, StatusCode.OK, "查询成功", adminRole);
//    }
//
    /**
     * 添加
     * @param adminRole 对象
     * @return Result对象
     */
    @PostMapping
    public Result add(AdminRole adminRole) {
        adminRoleService.add(adminRole);
        return new Result(true, StatusCode.OK, "添加成功");
    }
//
//    /**
//     * 修改
//     * @param id 修改对象的id
//     * @param adminRole 修改项
//     * @return Result对象
//     */
//    @PutMapping("/{id}")
//    public Result update(@PathVariable Integer id, AdminRole adminRole) {
//        adminRole.setId(id);
//        adminRoleService.update(adminRole);
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
//        adminRoleService.delete(id);
//        return new Result(true, StatusCode.OK, "删除成功");
//    }
}
