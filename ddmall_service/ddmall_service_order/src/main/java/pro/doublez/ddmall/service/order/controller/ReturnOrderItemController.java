package pro.doublez.ddmall.service.order.controller;

import pro.doublez.ddmall.order.pojo.ReturnOrderItem;
import com.github.pagehelper.PageInfo;
import org.springframework.web.bind.annotation.*;
import pro.doublez.ddmall.common.pojo.Result;
import pro.doublez.ddmall.common.pojo.StatusCode;
import pro.doublez.ddmall.service.order.service.ReturnOrderItemService;

import javax.annotation.Resource;
import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/returnOrderItem")
public class ReturnOrderItemController {

    @Resource
    private ReturnOrderItemService returnOrderItemService;

    /**
     * 列表查询
     * @param returnOrderItem 查询条件
     * @return Result对象
     */
    @GetMapping
    public Result<List<ReturnOrderItem>> findList(ReturnOrderItem returnOrderItem) {
        List<ReturnOrderItem> returnOrderItemList = returnOrderItemService.findList(returnOrderItem);
        return new Result<>(true, StatusCode.OK, "查询成功", returnOrderItemList);
    }

    /**
     * 分页查询
     * @param page 页码
     * @param size 每页显示条数
     * @param returnOrderItem 查询条件
     * @return Result对象
     */
    @GetMapping("/{page}/{size}")
    public Result findPage(@PathVariable int page,@PathVariable int size,ReturnOrderItem returnOrderItem){
        PageInfo<ReturnOrderItem> pageInfo = returnOrderItemService.findPage(returnOrderItem, page, size);
        return new Result(true,StatusCode.OK,"查询成功",pageInfo);
    }

    /**
     * id查询
     * @param id 查询对象的id
     * @return Result对象
     */
    @GetMapping("/{id}")
    public Result<ReturnOrderItem> findById(@PathVariable Integer id) {
        ReturnOrderItem returnOrderItem = returnOrderItemService.findById(id);
        return new Result<>(true, StatusCode.OK, "查询成功", returnOrderItem);
    }

    /**
     * 添加
     * @param returnOrderItem 对象
     * @return Result对象
     */
    @PostMapping
    public Result add(ReturnOrderItem returnOrderItem) {
        returnOrderItemService.add(returnOrderItem);
        return new Result(true, StatusCode.OK, "添加成功");
    }

    /**
     * 修改
     * @param id 修改对象的id
     * @param returnOrderItem 修改项
     * @return Result对象
     */
    @PutMapping("/{id}")
    public Result update(@PathVariable String id, ReturnOrderItem returnOrderItem) {
        returnOrderItem.setId(id);
        returnOrderItemService.update(returnOrderItem);
        return new Result(true, StatusCode.OK, "修改成功");
    }

    /**
     * 删除
     * @param id 删除对象的id
     * @return Result对象
     */
    @DeleteMapping("/{id}")
    public Result deleteById(@PathVariable Integer id){
        returnOrderItemService.delete(id);
        return new Result(true, StatusCode.OK, "删除成功");
    }
}
