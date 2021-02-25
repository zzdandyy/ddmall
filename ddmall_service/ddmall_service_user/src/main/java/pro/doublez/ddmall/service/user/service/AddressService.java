package pro.doublez.ddmall.service.user.service;

import com.github.pagehelper.PageInfo;
import pro.doublez.ddmall.user.pojo.Address;

import java.util.List;

public interface AddressService {

    // 条件查询
    List<Address> findList(Address address);

    // 分页条件查询
    PageInfo<Address> findPage(Address address, int page, int size);

    Address findById(Integer id);

    void add(Address address);

    void update(Address address);

    void delete(Integer id);

}
