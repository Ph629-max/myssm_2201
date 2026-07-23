package com.bigdata.service.impl;

import com.bigdata.dao.UserDao;
import com.bigdata.entity.User;
import com.bigdata.service.UserService;
import com.bigdata.utils.HashUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserDao userDao;

    @Transactional(propagation = Propagation.SUPPORTS)
    public List<User> queryUsers() throws Exception {
        List<User> users = userDao.selectList();
        return users;
    }

    @Transactional(propagation = Propagation.SUPPORTS)
    public User queryUserByUsername(String username) throws Exception {
        User user = userDao.selectByUsername(username);
        return user;
    }

    @Override
    // 返回值：0：注册失败；1：用户名已经被注册； 2：注册成功！
    @Transactional(propagation = Propagation.SUPPORTS)
    public int regist(String username, String pwd, int gender) {
        User user = null;
        try {
            user = queryUserByUsername(username);
            if (user != null && user.getId() > 0) {
                return 1;
            } else {
                Date date = new Date(System.currentTimeMillis());
                DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
                String format = dateFormat.format(date);
                user = new User(username, HashUtil.md5(pwd), gender, format);
                int i = userDao.insertOne(user);
                if (i > 0) return 2;
                else return 0;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }

    @Override
    // 返回值：0：登录失败；1：登录成功！
    @Transactional(propagation = Propagation.SUPPORTS)
    public int login(String username, String pwd) {
        User user = null;
        try {
            user = userDao.selectByUsernameAndPwd(username, HashUtil.md5(pwd));
            if (user != null && user.getId() > 0) {
                return 1;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }

}