package pro.doublez.system.service.impl;

import org.springframework.stereotype.Service;
import pro.doublez.system.dao.AdminDao;
import pro.doublez.system.pojo.Admin;
import pro.doublez.system.service.AdminService;


/**
 * @author doublez
 * @version 1.0
 * @date 2021/7/11 22:30
 */
@Service
public class AdminServiceImpl implements AdminService {

    private final AdminDao adminDao;
    public AdminServiceImpl(AdminDao adminDao) {
        this.adminDao = adminDao;
    }


    @Override
    public Admin login(String adminname, String password) {
        Admin realAdmin = adminDao.findAdmin(adminname);
        if (realAdmin != null) {
            String realPassword = realAdmin.getPassword();
            if (password.equals(realPassword)) {
                return realAdmin;
            }
        }
        return null;
    }
}
