package com.mybatis.kdt9.mapper;

import com.mybatis.kdt9.domain.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface UserMapper {
    // xml 파일을 참고해라.
    List<User> retrieveAll();

    // xml 파일을 참고하지 않고 sql을 직접 ( interface 에서 )
    @Insert("insert into user(name, nickname) values(#{name}, #{nickname})")
    void insertUser(User user);
}
