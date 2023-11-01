package com.example.mybatis.mybtistest.mapper;

import com.example.mybatis.mybtistest.domain.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface MainMapper {

    List<User> retrieveAll();

    @Insert("INSERT INTO user (name, address) VALUES (#{name}, #{address})")
    void insertUser(User user);
}