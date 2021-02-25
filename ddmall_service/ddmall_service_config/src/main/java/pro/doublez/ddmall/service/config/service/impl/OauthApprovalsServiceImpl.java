package pro.doublez.ddmall.service.config.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Service;
import pro.doublez.ddmall.config.pojo.OauthApprovals;
import pro.doublez.ddmall.service.config.dao.OauthApprovalsMapper;
import pro.doublez.ddmall.service.config.service.OauthApprovalsService;

import javax.annotation.Resource;
import java.util.List;

@Service
public class OauthApprovalsServiceImpl implements OauthApprovalsService {

    @Resource
    private OauthApprovalsMapper oauthApprovalsMapper;

    @Override
    public List<OauthApprovals> findList(OauthApprovals oauthApprovals) {
        return oauthApprovalsMapper.findList(oauthApprovals);
    }

    @Override
    public PageInfo<OauthApprovals> findPage(OauthApprovals oauthApprovals,int page,int size) {
        PageHelper.startPage(page, size);
        List<OauthApprovals> all = oauthApprovalsMapper.findList(oauthApprovals);
        return new PageInfo<>(all);
    }

    @Override
    public OauthApprovals findById(Integer id) {
        return oauthApprovalsMapper.findById(id);
    }

    @Override
    public void add(OauthApprovals oauthApprovals) {
        oauthApprovalsMapper.add(oauthApprovals);
    }

    @Override
    public void update(OauthApprovals oauthApprovals) {
        oauthApprovalsMapper.update(oauthApprovals);
    }

    @Override
    public void delete(Integer id) {
        oauthApprovalsMapper.delete(id);
    }
}
