package pro.doublez.ddmall.service.config.controller;

import com.github.pagehelper.PageInfo;
import org.springframework.web.bind.annotation.*;
import pro.doublez.ddmall.common.pojo.Result;
import pro.doublez.ddmall.common.pojo.StatusCode;
import pro.doublez.ddmall.config.pojo.OauthAccessToken;
import pro.doublez.ddmall.service.config.service.OauthAccessTokenService;

import javax.annotation.Resource;
import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/oauthAccessToken")
public class OauthAccessTokenController {

    @Resource
    private OauthAccessTokenService oauthAccessTokenService;

    /**
     * 列表查询
     * @param oauthAccessToken 查询条件
     * @return Result对象
     */
    @GetMapping
    public Result<List<OauthAccessToken>> findList(OauthAccessToken oauthAccessToken) {
        List<OauthAccessToken> oauthAccessTokenList = oauthAccessTokenService.findList(oauthAccessToken);
        return new Result<>(true, StatusCode.OK, "查询成功", oauthAccessTokenList);
    }

    /**
     * 分页查询
     * @param page 页码
     * @param size 每页显示条数
     * @param oauthAccessToken 查询条件
     * @return Result对象
     */
    @GetMapping("/{page}/{size}")
    public Result findPage(@PathVariable int page,@PathVariable int size,OauthAccessToken oauthAccessToken){
        PageInfo<OauthAccessToken> pageInfo = oauthAccessTokenService.findPage(oauthAccessToken, page, size);
        return new Result(true,StatusCode.OK,"查询成功",pageInfo);
    }

//    /**
//     * id查询
//     * @param id 查询对象的id
//     * @return Result对象
//     */
//    @GetMapping("/{id}")
//    public Result<OauthAccessToken> findById(@PathVariable Integer id) {
//        OauthAccessToken oauthAccessToken = oauthAccessTokenService.findById(id);
//        return new Result<>(true, StatusCode.OK, "查询成功", oauthAccessToken);
//    }
//
    /**
     * 添加
     * @param oauthAccessToken 对象
     * @return Result对象
     */
    @PostMapping
    public Result add(OauthAccessToken oauthAccessToken) {
        oauthAccessTokenService.add(oauthAccessToken);
        return new Result(true, StatusCode.OK, "添加成功");
    }
//
//    /**
//     * 修改
//     * @param id 修改对象的id
//     * @param oauthAccessToken 修改项
//     * @return Result对象
//     */
//    @PutMapping("/{id}")
//    public Result update(@PathVariable Integer id, OauthAccessToken oauthAccessToken) {
//        oauthAccessToken.setId(id);
//        oauthAccessTokenService.update(oauthAccessToken);
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
//        oauthAccessTokenService.delete(id);
//        return new Result(true, StatusCode.OK, "删除成功");
//    }
}
