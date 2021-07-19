package pro.doublez.system.service;


import pro.doublez.system.pojo.Admin;

/**
 * @author doublez
 * @version 1.0
 * @date 2021/7/11 22:28
 */
public interface AdminService {
    //登录
    Admin login(String adminname, String password);
}
