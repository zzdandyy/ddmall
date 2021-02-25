package pro.doublez.ddmall.service.user.controller;

import com.github.pagehelper.PageInfo;
import org.springframework.web.bind.annotation.*;
import pro.doublez.ddmall.common.pojo.Result;
import pro.doublez.ddmall.common.pojo.StatusCode;
import pro.doublez.ddmall.service.user.service.OauthCodeService;
import pro.doublez.ddmall.user.pojo.OauthCode;

import javax.annotation.Resource;
import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/oauthCode")
public class OauthCodeController {

    @Resource
    private OauthCodeService oauthCodeService;

    /**
     * 列表查询
     * @param oauthCode 查询条件
     * @return Result对象
     */
    @GetMapping
    public Result<List<OauthCode>> findList(OauthCode oauthCode) {
        List<OauthCode> oauthCodeList = oauthCodeService.findList(oauthCode);
        return new Result<>(true, StatusCode.OK, "查询成功", oauthCodeList);
    }

    /**
     * 分页查询
     * @param page 页码
     * @param size 每页显示条数
     * @param oauthCode 查询条件
     * @return Result对象
     */
    @GetMapping("/{page}/{size}")
    public Result findPage(@PathVariable int page,@PathVariable int size,OauthCode oauthCode){
        PageInfo<OauthCode> pageInfo = oauthCodeService.findPage(oauthCode, page, size);
        return new Result(true,StatusCode.OK,"查询成功",pageInfo);
    }

//    /**
//     * id查询
//     * @param id 查询对象的id
//     * @return Result对象
//     */
//    @GetMapping("/{id}")
//    public Result<OauthCode> findById(@PathVariable Integer id) {
//        OauthCode oauthCode = oauthCodeService.findById(id);
//        return new Result<>(true, StatusCode.OK, "查询成功", oauthCode);
//    }
//
    /**
     * 添加
     * @param oauthCode 对象
     * @return Result对象
     */
    @PostMapping
    public Result add(OauthCode oauthCode) {
        oauthCodeService.add(oauthCode);
        return new Result(true, StatusCode.OK, "添加成功");
    }
//
//    /**
//     * 修改
//     * @param id 修改对象的id
//     * @param oauthCode 修改项
//     * @return Result对象
//     */
//    @PutMapping("/{id}")
//    public Result update(@PathVariable Integer id, OauthCode oauthCode) {
//        oauthCode.setId(id);
//        oauthCodeService.update(oauthCode);
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
//        oauthCodeService.delete(id);
//        return new Result(true, StatusCode.OK, "删除成功");
//    }
}
