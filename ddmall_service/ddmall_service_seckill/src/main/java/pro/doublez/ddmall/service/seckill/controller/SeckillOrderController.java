package pro.doublez.ddmall.service.seckill.controller;

import com.github.pagehelper.PageInfo;
import org.springframework.web.bind.annotation.*;
import pro.doublez.ddmall.common.pojo.Result;
import pro.doublez.ddmall.common.pojo.StatusCode;
import pro.doublez.ddmall.seckill.pojo.SeckillOrder;
import pro.doublez.ddmall.service.seckill.service.SeckillOrderService;

import javax.annotation.Resource;
import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/seckillOrder")
public class SeckillOrderController {

    @Resource
    private SeckillOrderService seckillOrderService;

    /**
     * 列表查询
     * @param seckillOrder 查询条件
     * @return Result对象
     */
    @GetMapping
    public Result<List<SeckillOrder>> findList(SeckillOrder seckillOrder) {
        List<SeckillOrder> seckillOrderList = seckillOrderService.findList(seckillOrder);
        return new Result<>(true, StatusCode.OK, "查询成功", seckillOrderList);
    }

    /**
     * 分页查询
     * @param page 页码
     * @param size 每页显示条数
     * @param seckillOrder 查询条件
     * @return Result对象
     */
    @GetMapping("/{page}/{size}")
    public Result findPage(@PathVariable int page,@PathVariable int size,SeckillOrder seckillOrder){
        PageInfo<SeckillOrder> pageInfo = seckillOrderService.findPage(seckillOrder, page, size);
        return new Result(true,StatusCode.OK,"查询成功",pageInfo);
    }

    /**
     * id查询
     * @param id 查询对象的id
     * @return Result对象
     */
    @GetMapping("/{id}")
    public Result<SeckillOrder> findById(@PathVariable Integer id) {
        SeckillOrder seckillOrder = seckillOrderService.findById(id);
        return new Result<>(true, StatusCode.OK, "查询成功", seckillOrder);
    }

    /**
     * 添加
     * @param seckillOrder 对象
     * @return Result对象
     */
    @PostMapping
    public Result add(SeckillOrder seckillOrder) {
        seckillOrderService.add(seckillOrder);
        return new Result(true, StatusCode.OK, "添加成功");
    }

    /**
     * 修改
     * @param id 修改对象的id
     * @param seckillOrder 修改项
     * @return Result对象
     */
    @PutMapping("/{id}")
    public Result update(@PathVariable Long id, SeckillOrder seckillOrder) {
        seckillOrder.setId(id);
        seckillOrderService.update(seckillOrder);
        return new Result(true, StatusCode.OK, "修改成功");
    }

    /**
     * 删除
     * @param id 删除对象的id
     * @return Result对象
     */
    @DeleteMapping("/{id}")
    public Result deleteById(@PathVariable Integer id){
        seckillOrderService.delete(id);
        return new Result(true, StatusCode.OK, "删除成功");
    }
}
