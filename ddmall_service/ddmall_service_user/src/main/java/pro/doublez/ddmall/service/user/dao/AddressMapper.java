package pro.doublez.ddmall.service.user.dao;

import org.apache.ibatis.annotations.Mapper;
import pro.doublez.ddmall.user.pojo.Address;

import java.util.List;


@Mapper
public interface AddressMapper {

    List<Address> findList(Address address);

    Address findById(Integer id);

    void add(Address address);

    void update(Address address);

    void delete(Integer id);

}

