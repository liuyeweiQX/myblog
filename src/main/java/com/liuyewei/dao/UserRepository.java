package com.liuyewei.dao;

import com.liuyewei.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created with IntelliJ IDEA.
 * User: liuyewei
 * Date: 2020/1/11
 * Time: 5:45 下午
 * Description:
 */
public interface UserRepository extends JpaRepository<User,Long> {

    User findByUsernameAndPassword(String username, String password);
}
