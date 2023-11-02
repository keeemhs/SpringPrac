package com.example.mybatis.mybtistest.mapper;

import com.example.mybatis.mybtistest.domain.Users;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface MainMapper {

    //mapper 참고하기
    List<Users> findAll();

    //mapper xml 참고 안하기
    @Insert("INSERT INTO users (name, address) VALUES (#{name}, #{address})")
    void insertUser(Users user);
}
