package pro.doublez.ddmall.service.user.controller;

import com.github.pagehelper.PageInfo;
import org.springframework.web.bind.annotation.*;
import pro.doublez.ddmall.common.pojo.Result;
import pro.doublez.ddmall.common.pojo.StatusCode;
import pro.doublez.ddmall.service.user.service.OauthClientDetailsService;
import pro.doublez.ddmall.user.pojo.OauthClientDetails;

import javax.annotation.Resource;
import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/oauthClientDetails")
public class OauthClientDetailsController {

    @Resource
    private OauthClientDetailsService oauthClientDetailsService;

    /**
     * 列表查询
     * @param oauthClientDetails 查询条件
     * @return Result对象
     */
    @GetMapping
    public Result<List<OauthClientDetails>> findList(OauthClientDetails oauthClientDetails) {
        List<OauthClientDetails> oauthClientDetailsList = oauthClientDetailsService.findList(oauthClientDetails);
        return new Result<>(true, StatusCode.OK, "查询成功", oauthClientDetailsList);
    }

    /**
     * 分页查询
     * @param page 页码
     * @param size 每页显示条数
     * @param oauthClientDetails 查询条件
     * @return Result对象
     */
    @GetMapping("/{page}/{size}")
    public Result findPage(@PathVariable int page,@PathVariable int size,OauthClientDetails oauthClientDetails){
        PageInfo<OauthClientDetails> pageInfo = oauthClientDetailsService.findPage(oauthClientDetails, page, size);
        return new Result(true,StatusCode.OK,"查询成功",pageInfo);
    }

//    /**
//     * id查询
//     * @param id 查询对象的id
//     * @return Result对象
//     */
//    @GetMapping("/{id}")
//    public Result<OauthClientDetails> findById(@PathVariable Integer id) {
//        OauthClientDetails oauthClientDetails = oauthClientDetailsService.findById(id);
//        return new Result<>(true, StatusCode.OK, "查询成功", oauthClientDetails);
//    }
//
    /**
     * 添加
     * @param oauthClientDetails 对象
     * @return Result对象
     */
    @PostMapping
    public Result add(OauthClientDetails oauthClientDetails) {
        oauthClientDetailsService.add(oauthClientDetails);
        return new Result(true, StatusCode.OK, "添加成功");
    }
//
//    /**
//     * 修改
//     * @param id 修改对象的id
//     * @param oauthClientDetails 修改项
//     * @return Result对象
//     */
//    @PutMapping("/{id}")
//    public Result update(@PathVariable Integer id, OauthClientDetails oauthClientDetails) {
//        oauthClientDetails.setId(id);
//        oauthClientDetailsService.update(oauthClientDetails);
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
//        oauthClientDetailsService.delete(id);
//        return new Result(true, StatusCode.OK, "删除成功");
//    }
}
