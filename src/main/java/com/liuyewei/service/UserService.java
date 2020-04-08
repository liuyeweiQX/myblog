package com.liuyewei.service;

import com.liuyewei.entity.User;

/**
 * Created with IntelliJ IDEA.
 * User: liuyewei
 * Date: 2020/1/11
 * Time: 5:41 下午
 * Description:
 */
public interface UserService {

    User checkUser(String username, String password);
}
