package pro.doublez.ddmall.service.config.controller;

import com.github.pagehelper.PageInfo;
import org.springframework.web.bind.annotation.*;
import pro.doublez.ddmall.common.pojo.Result;
import pro.doublez.ddmall.common.pojo.StatusCode;
import pro.doublez.ddmall.config.pojo.Address;
import pro.doublez.ddmall.service.config.service.AddressService;

import javax.annotation.Resource;
import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/address")
public class AddressController {

    @Resource
    private AddressService addressService;

    /**
     * 列表查询
     * @param address 查询条件
     * @return Result对象
     */
    @GetMapping
    public Result<List<Address>> findList(Address address) {
        List<Address> addressList = addressService.findList(address);
        return new Result<>(true, StatusCode.OK, "查询成功", addressList);
    }

    /**
     * 分页查询
     * @param page 页码
     * @param size 每页显示条数
     * @param address 查询条件
     * @return Result对象
     */
    @GetMapping("/{page}/{size}")
    public Result findPage(@PathVariable int page,@PathVariable int size,Address address){
        PageInfo<Address> pageInfo = addressService.findPage(address, page, size);
        return new Result(true,StatusCode.OK,"查询成功",pageInfo);
    }

    /**
     * id查询
     * @param id 查询对象的id
     * @return Result对象
     */
    @GetMapping("/{id}")
    public Result<Address> findById(@PathVariable Integer id) {
        Address address = addressService.findById(id);
        return new Result<>(true, StatusCode.OK, "查询成功", address);
    }

    /**
     * 添加
     * @param address 对象
     * @return Result对象
     */
    @PostMapping
    public Result add(Address address) {
        addressService.add(address);
        return new Result(true, StatusCode.OK, "添加成功");
    }

    /**
     * 修改
     * @param id 修改对象的id
     * @param address 修改项
     * @return Result对象
     */
    @PutMapping("/{id}")
    public Result update(@PathVariable Integer id, Address address) {
        address.setId(id);
        addressService.update(address);
        return new Result(true, StatusCode.OK, "修改成功");
    }

    /**
     * 删除
     * @param id 删除对象的id
     * @return Result对象
     */
    @DeleteMapping("/{id}")
    public Result deleteById(@PathVariable Integer id){
        addressService.delete(id);
        return new Result(true, StatusCode.OK, "删除成功");
    }
}
