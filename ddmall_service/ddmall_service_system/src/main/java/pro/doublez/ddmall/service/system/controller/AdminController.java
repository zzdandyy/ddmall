package pro.doublez.ddmall.service.system.controller;

import com.github.pagehelper.PageInfo;
import org.springframework.web.bind.annotation.*;
import pro.doublez.ddmall.common.pojo.Result;
import pro.doublez.ddmall.common.pojo.StatusCode;
import pro.doublez.ddmall.service.system.service.AdminService;
import pro.doublez.ddmall.system.pojo.Admin;

import javax.annotation.Resource;
import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/admin")
public class AdminController {

    @Resource
    private AdminService adminService;

    /**
     * 列表查询
     * @param admin 查询条件
     * @return Result对象
     */
    @GetMapping
    public Result<List<Admin>> findList(Admin admin) {
        List<Admin> adminList = adminService.findList(admin);
        return new Result<>(true, StatusCode.OK, "查询成功", adminList);
    }

    /**
     * 分页查询
     * @param page 页码
     * @param size 每页显示条数
     * @param admin 查询条件
     * @return Result对象
     */
    @GetMapping("/{page}/{size}")
    public Result findPage(@PathVariable int page,@PathVariable int size,Admin admin){
        PageInfo<Admin> pageInfo = adminService.findPage(admin, page, size);
        return new Result(true,StatusCode.OK,"查询成功",pageInfo);
    }

    /**
     * id查询
     * @param id 查询对象的id
     * @return Result对象
     */
    @GetMapping("/{id}")
    public Result<Admin> findById(@PathVariable Integer id) {
        Admin admin = adminService.findById(id);
        return new Result<>(true, StatusCode.OK, "查询成功", admin);
    }

    /**
     * 添加
     * @param admin 对象
     * @return Result对象
     */
    @PostMapping
    public Result add(Admin admin) {
        adminService.add(admin);
        return new Result(true, StatusCode.OK, "添加成功");
    }

    /**
     * 修改
     * @param id 修改对象的id
     * @param admin 修改项
     * @return Result对象
     */
    @PutMapping("/{id}")
    public Result update(@PathVariable Integer id, Admin admin) {
        admin.setId(id);
        adminService.update(admin);
        return new Result(true, StatusCode.OK, "修改成功");
    }

    /**
     * 删除
     * @param id 删除对象的id
     * @return Result对象
     */
    @DeleteMapping("/{id}")
    public Result deleteById(@PathVariable Integer id){
        adminService.delete(id);
        return new Result(true, StatusCode.OK, "删除成功");
    }
}
