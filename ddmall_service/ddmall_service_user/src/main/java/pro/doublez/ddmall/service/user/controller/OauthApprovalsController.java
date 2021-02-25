package pro.doublez.ddmall.service.user.controller;

import com.github.pagehelper.PageInfo;
import org.springframework.web.bind.annotation.*;
import pro.doublez.ddmall.common.pojo.Result;
import pro.doublez.ddmall.common.pojo.StatusCode;
import pro.doublez.ddmall.service.user.service.OauthApprovalsService;
import pro.doublez.ddmall.user.pojo.OauthApprovals;

import javax.annotation.Resource;
import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/oauthApprovals")
public class OauthApprovalsController {

    @Resource
    private OauthApprovalsService oauthApprovalsService;

    /**
     * 列表查询
     * @param oauthApprovals 查询条件
     * @return Result对象
     */
    @GetMapping
    public Result<List<OauthApprovals>> findList(OauthApprovals oauthApprovals) {
        List<OauthApprovals> oauthApprovalsList = oauthApprovalsService.findList(oauthApprovals);
        return new Result<>(true, StatusCode.OK, "查询成功", oauthApprovalsList);
    }

    /**
     * 分页查询
     * @param page 页码
     * @param size 每页显示条数
     * @param oauthApprovals 查询条件
     * @return Result对象
     */
    @GetMapping("/{page}/{size}")
    public Result findPage(@PathVariable int page,@PathVariable int size,OauthApprovals oauthApprovals){
        PageInfo<OauthApprovals> pageInfo = oauthApprovalsService.findPage(oauthApprovals, page, size);
        return new Result(true,StatusCode.OK,"查询成功",pageInfo);
    }

//    /**
//     * id查询
//     * @param id 查询对象的id
//     * @return Result对象
//     */
//    @GetMapping("/{id}")
//    public Result<OauthApprovals> findById(@PathVariable Integer id) {
//        OauthApprovals oauthApprovals = oauthApprovalsService.findById(id);
//        return new Result<>(true, StatusCode.OK, "查询成功", oauthApprovals);
//    }
//
    /**
     * 添加
     * @param oauthApprovals 对象
     * @return Result对象
     */
    @PostMapping
    public Result add(OauthApprovals oauthApprovals) {
        oauthApprovalsService.add(oauthApprovals);
        return new Result(true, StatusCode.OK, "添加成功");
    }
//
//    /**
//     * 修改
//     * @param id 修改对象的id
//     * @param oauthApprovals 修改项
//     * @return Result对象
//     */
//    @PutMapping("/{id}")
//    public Result update(@PathVariable Integer id, OauthApprovals oauthApprovals) {
//        oauthApprovals.setId(id);
//        oauthApprovalsService.update(oauthApprovals);
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
//        oauthApprovalsService.delete(id);
//        return new Result(true, StatusCode.OK, "删除成功");
//    }
}
