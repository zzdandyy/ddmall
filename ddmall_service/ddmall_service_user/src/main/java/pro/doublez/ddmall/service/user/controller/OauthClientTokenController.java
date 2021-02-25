package pro.doublez.ddmall.service.user.controller;

import com.github.pagehelper.PageInfo;
import org.springframework.web.bind.annotation.*;
import pro.doublez.ddmall.common.pojo.Result;
import pro.doublez.ddmall.common.pojo.StatusCode;
import pro.doublez.ddmall.service.user.service.OauthClientTokenService;
import pro.doublez.ddmall.user.pojo.OauthClientToken;

import javax.annotation.Resource;
import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/oauthClientToken")
public class OauthClientTokenController {

    @Resource
    private OauthClientTokenService oauthClientTokenService;

    /**
     * 列表查询
     * @param oauthClientToken 查询条件
     * @return Result对象
     */
    @GetMapping
    public Result<List<OauthClientToken>> findList(OauthClientToken oauthClientToken) {
        List<OauthClientToken> oauthClientTokenList = oauthClientTokenService.findList(oauthClientToken);
        return new Result<>(true, StatusCode.OK, "查询成功", oauthClientTokenList);
    }

    /**
     * 分页查询
     * @param page 页码
     * @param size 每页显示条数
     * @param oauthClientToken 查询条件
     * @return Result对象
     */
    @GetMapping("/{page}/{size}")
    public Result findPage(@PathVariable int page,@PathVariable int size,OauthClientToken oauthClientToken){
        PageInfo<OauthClientToken> pageInfo = oauthClientTokenService.findPage(oauthClientToken, page, size);
        return new Result(true,StatusCode.OK,"查询成功",pageInfo);
    }

//    /**
//     * id查询
//     * @param id 查询对象的id
//     * @return Result对象
//     */
//    @GetMapping("/{id}")
//    public Result<OauthClientToken> findById(@PathVariable Integer id) {
//        OauthClientToken oauthClientToken = oauthClientTokenService.findById(id);
//        return new Result<>(true, StatusCode.OK, "查询成功", oauthClientToken);
//    }
//
    /**
     * 添加
     * @param oauthClientToken 对象
     * @return Result对象
     */
    @PostMapping
    public Result add(OauthClientToken oauthClientToken) {
        oauthClientTokenService.add(oauthClientToken);
        return new Result(true, StatusCode.OK, "添加成功");
    }
//
//    /**
//     * 修改
//     * @param id 修改对象的id
//     * @param oauthClientToken 修改项
//     * @return Result对象
//     */
//    @PutMapping("/{id}")
//    public Result update(@PathVariable Integer id, OauthClientToken oauthClientToken) {
//        oauthClientToken.setId(id);
//        oauthClientTokenService.update(oauthClientToken);
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
//        oauthClientTokenService.delete(id);
//        return new Result(true, StatusCode.OK, "删除成功");
//    }
}
