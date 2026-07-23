package com.bigdata.dao;

import com.bigdata.entity.Emp;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface EmpDao {

    Emp selectById(int id) throws Exception;

    Emp selectJoinById(int id) throws Exception;

    Emp selectByName(String username) throws Exception;

    List<Emp> selectList() throws Exception;

    List<Emp> selectListByKey(String key) throws Exception;

    int selectCount() throws Exception;

    int selectMaxId() throws Exception;

    int selectMinId() throws Exception;

    // 当有一个参数，需要对参数进行重命名时，需要加@Param。一般传入多个参数必须使用@Param注解，否则会报错
    List<Emp> selectByDepidAndSalary(@Param("depid") int depid, @Param("salary") Double salary, @Param("operator") String operator) throws Exception;

    int insertOne(Emp emp) throws Exception;

    int deleteById(int id) throws Exception;

    int deleteInIds(List<Integer> id) throws Exception;

    int updateOne(Emp emp) throws Exception;

    List<Emp> selectListByCondition(@Param("id") Integer id, @Param("username") String username, @Param("salary") Double salary, @Param("age") int age, @Param("depid") int depid) throws Exception;

    int updateByCondition(@Param("id") Integer id, @Param("username") String username, @Param("salary") Double salary, @Param("age") Integer age, @Param("depid") Integer depid) throws Exception;
}
