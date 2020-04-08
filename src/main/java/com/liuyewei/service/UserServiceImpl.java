package com.liuyewei.service;

import com.liuyewei.dao.UserRepository;
import com.liuyewei.entity.User;
import com.liuyewei.util.MD5Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created with IntelliJ IDEA.
 * User: liuyewei
 * Date: 2020/1/11
 * Time: 5:42 下午
 * Description:
 */
@Service
public class UserServiceImpl implements UserService{

    @Autowired
    private UserRepository userRepository;

    @Override
    public User checkUser(String username, String password) {
        User user = userRepository.findByUsernameAndPassword(username, MD5Utils.code(password));
        return user;
    }
}
