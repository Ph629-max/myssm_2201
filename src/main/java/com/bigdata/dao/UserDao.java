package com.bigdata.dao;

import com.bigdata.entity.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UserDao {
    User selectById(Integer id) throws Exception;

    User selectByUsername(String username) throws Exception;

    User selectByUsernameAndPwd(@Param("username") String username, @Param("pwd") String pwd) throws Exception;

    List<User> selectList() throws Exception;

    int insertOne(User user) throws Exception;

    int updateOne(User user) throws Exception;

    int deleteById(int id) throws Exception;

    List<User> selectListByCondition(@Param("id") Integer id, @Param("username") String username, @Param("gender") Integer gender, @Param("regTime") String regTime, @Param("operator") String operator) throws Exception;

}
