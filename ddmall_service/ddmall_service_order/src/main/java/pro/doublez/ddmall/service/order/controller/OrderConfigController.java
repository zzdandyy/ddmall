package pro.doublez.ddmall.service.order.controller;

import pro.doublez.ddmall.order.pojo.OrderConfig;
import com.github.pagehelper.PageInfo;
import org.springframework.web.bind.annotation.*;
import pro.doublez.ddmall.common.pojo.Result;
import pro.doublez.ddmall.common.pojo.StatusCode;
import pro.doublez.ddmall.service.order.service.OrderConfigService;

import javax.annotation.Resource;
import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/orderConfig")
public class OrderConfigController {

    @Resource
    private OrderConfigService orderConfigService;

    /**
     * 列表查询
     * @param orderConfig 查询条件
     * @return Result对象
     */
    @GetMapping
    public Result<List<OrderConfig>> findList(OrderConfig orderConfig) {
        List<OrderConfig> orderConfigList = orderConfigService.findList(orderConfig);
        return new Result<>(true, StatusCode.OK, "查询成功", orderConfigList);
    }

    /**
     * 分页查询
     * @param page 页码
     * @param size 每页显示条数
     * @param orderConfig 查询条件
     * @return Result对象
     */
    @GetMapping("/{page}/{size}")
    public Result findPage(@PathVariable int page,@PathVariable int size,OrderConfig orderConfig){
        PageInfo<OrderConfig> pageInfo = orderConfigService.findPage(orderConfig, page, size);
        return new Result(true,StatusCode.OK,"查询成功",pageInfo);
    }

    /**
     * id查询
     * @param id 查询对象的id
     * @return Result对象
     */
    @GetMapping("/{id}")
    public Result<OrderConfig> findById(@PathVariable Integer id) {
        OrderConfig orderConfig = orderConfigService.findById(id);
        return new Result<>(true, StatusCode.OK, "查询成功", orderConfig);
    }

    /**
     * 添加
     * @param orderConfig 对象
     * @return Result对象
     */
    @PostMapping
    public Result add(OrderConfig orderConfig) {
        orderConfigService.add(orderConfig);
        return new Result(true, StatusCode.OK, "添加成功");
    }

    /**
     * 修改
     * @param id 修改对象的id
     * @param orderConfig 修改项
     * @return Result对象
     */
    @PutMapping("/{id}")
    public Result update(@PathVariable Integer id, OrderConfig orderConfig) {
        orderConfig.setId(id);
        orderConfigService.update(orderConfig);
        return new Result(true, StatusCode.OK, "修改成功");
    }

    /**
     * 删除
     * @param id 删除对象的id
     * @return Result对象
     */
    @DeleteMapping("/{id}")
    public Result deleteById(@PathVariable Integer id){
        orderConfigService.delete(id);
        return new Result(true, StatusCode.OK, "删除成功");
    }
}
