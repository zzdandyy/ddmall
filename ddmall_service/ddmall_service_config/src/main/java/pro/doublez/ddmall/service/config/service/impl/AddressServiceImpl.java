package pro.doublez.ddmall.service.config.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Service;
import pro.doublez.ddmall.config.pojo.Address;
import pro.doublez.ddmall.service.config.dao.AddressMapper;
import pro.doublez.ddmall.service.config.service.AddressService;

import javax.annotation.Resource;
import java.util.List;

@Service
public class AddressServiceImpl implements AddressService {

    @Resource
    private AddressMapper addressMapper;

    @Override
    public List<Address> findList(Address address) {
        return addressMapper.findList(address);
    }

    @Override
    public PageInfo<Address> findPage(Address address,int page,int size) {
        PageHelper.startPage(page, size);
        List<Address> all = addressMapper.findList(address);
        return new PageInfo<>(all);
    }

    @Override
    public Address findById(Integer id) {
        return addressMapper.findById(id);
    }

    @Override
    public void add(Address address) {
        addressMapper.add(address);
    }

    @Override
    public void update(Address address) {
        addressMapper.update(address);
    }

    @Override
    public void delete(Integer id) {
        addressMapper.delete(id);
    }
}
