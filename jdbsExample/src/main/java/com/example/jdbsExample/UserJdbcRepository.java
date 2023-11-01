package com.example.jdbsExample;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class UserJdbcRepository {
    @Autowired
    private JdbcTemplate jdbc;

    private static String INSERT_USER =
            """
                INSERT INTO users (id, name, address) values (1, '홍길동', '서울시 마포구');
            """;

    public void insert() {
        jdbc.update(INSERT_USER);
    }
}
