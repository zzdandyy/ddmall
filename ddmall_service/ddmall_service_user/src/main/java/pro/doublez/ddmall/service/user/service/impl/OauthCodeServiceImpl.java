package pro.doublez.ddmall.service.user.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Service;
import pro.doublez.ddmall.service.user.dao.OauthCodeMapper;
import pro.doublez.ddmall.service.user.service.OauthCodeService;
import pro.doublez.ddmall.user.pojo.OauthCode;

import javax.annotation.Resource;
import java.util.List;

@Service
public class OauthCodeServiceImpl implements OauthCodeService {

    @Resource
    private OauthCodeMapper oauthCodeMapper;

    @Override
    public List<OauthCode> findList(OauthCode oauthCode) {
        return oauthCodeMapper.findList(oauthCode);
    }

    @Override
    public PageInfo<OauthCode> findPage(OauthCode oauthCode,int page,int size) {
        PageHelper.startPage(page, size);
        List<OauthCode> all = oauthCodeMapper.findList(oauthCode);
        return new PageInfo<>(all);
    }

    @Override
    public OauthCode findById(Integer id) {
        return oauthCodeMapper.findById(id);
    }

    @Override
    public void add(OauthCode oauthCode) {
        oauthCodeMapper.add(oauthCode);
    }

    @Override
    public void update(OauthCode oauthCode) {
        oauthCodeMapper.update(oauthCode);
    }

    @Override
    public void delete(Integer id) {
        oauthCodeMapper.delete(id);
    }
}
