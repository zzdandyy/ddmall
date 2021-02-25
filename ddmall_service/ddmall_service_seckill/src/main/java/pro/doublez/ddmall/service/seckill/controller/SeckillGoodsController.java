package pro.doublez.ddmall.service.seckill.controller;

import com.github.pagehelper.PageInfo;
import org.springframework.web.bind.annotation.*;
import pro.doublez.ddmall.common.pojo.Result;
import pro.doublez.ddmall.common.pojo.StatusCode;
import pro.doublez.ddmall.seckill.pojo.SeckillGoods;
import pro.doublez.ddmall.service.seckill.service.SeckillGoodsService;

import javax.annotation.Resource;
import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/seckillGoods")
public class SeckillGoodsController {

    @Resource
    private SeckillGoodsService seckillGoodsService;

    /**
     * 列表查询
     * @param seckillGoods 查询条件
     * @return Result对象
     */
    @GetMapping
    public Result<List<SeckillGoods>> findList(SeckillGoods seckillGoods) {
        List<SeckillGoods> seckillGoodsList = seckillGoodsService.findList(seckillGoods);
        return new Result<>(true, StatusCode.OK, "查询成功", seckillGoodsList);
    }

    /**
     * 分页查询
     * @param page 页码
     * @param size 每页显示条数
     * @param seckillGoods 查询条件
     * @return Result对象
     */
    @GetMapping("/{page}/{size}")
    public Result findPage(@PathVariable int page,@PathVariable int size,SeckillGoods seckillGoods){
        PageInfo<SeckillGoods> pageInfo = seckillGoodsService.findPage(seckillGoods, page, size);
        return new Result(true,StatusCode.OK,"查询成功",pageInfo);
    }

    /**
     * id查询
     * @param id 查询对象的id
     * @return Result对象
     */
    @GetMapping("/{id}")
    public Result<SeckillGoods> findById(@PathVariable Integer id) {
        SeckillGoods seckillGoods = seckillGoodsService.findById(id);
        return new Result<>(true, StatusCode.OK, "查询成功", seckillGoods);
    }

    /**
     * 添加
     * @param seckillGoods 对象
     * @return Result对象
     */
    @PostMapping
    public Result add(SeckillGoods seckillGoods) {
        seckillGoodsService.add(seckillGoods);
        return new Result(true, StatusCode.OK, "添加成功");
    }

    /**
     * 修改
     * @param id 修改对象的id
     * @param seckillGoods 修改项
     * @return Result对象
     */
    @PutMapping("/{id}")
    public Result update(@PathVariable Long id, SeckillGoods seckillGoods) {
        seckillGoods.setId(id);
        seckillGoodsService.update(seckillGoods);
        return new Result(true, StatusCode.OK, "修改成功");
    }

    /**
     * 删除
     * @param id 删除对象的id
     * @return Result对象
     */
    @DeleteMapping("/{id}")
    public Result deleteById(@PathVariable Integer id){
        seckillGoodsService.delete(id);
        return new Result(true, StatusCode.OK, "删除成功");
    }
}
