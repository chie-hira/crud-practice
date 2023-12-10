package com.raisetech.servicepractice.mapper;

import com.raisetech.servicepractice.entity.User;
import org.junit.jupiter.api.Test;
import org.mybatis.spring.boot.test.autoconfigure.MybatisTest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

@MybatisTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class UserMapperTest {
    @Autowired
    UserMapper userMapper;

    @Test
    @Sql(
            scripts = {"classpath:/sqlannotation/delete-users.sql","classpath:/sqlannotation/insert-users.sql"},
            executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD
    )
    @Transactional
    void すべてのユーザーが取得できること() {
        List<User> users = userMapper.findAll();
        assertThat(users)
                .hasSize(3)
                .contains(
                        new User(1,"megu", "megu@neko.com"),
                        new User(2,"deji", "deji@neko.com"),
                        new User(3,"mopu", "mopu@neko.com")
                );
    }
    @Test
    @Sql(
            scripts = {"classpath:/sqlannotation/delete-users.sql","classpath:/sqlannotation/insert-users.sql"},
            executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD
    )
    @Transactional
    void idからユーザーを取得できること() {
        int userId = 1;
        Optional<User> user = userMapper.findById(userId);
        assertThat(user)
                .isPresent()
                .hasValueSatisfying(u -> assertThat(u)
                        .isEqualTo(new User(userId, "megu", "megu@neko.com")));
    }

    @Test
    @Sql(
            scripts = {"classpath:/sqlannotation/delete-users.sql","classpath:/sqlannotation/insert-users.sql"},
            executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD
    )
    @Transactional
    void emailからユーザーを取得できること() {
        String email = "deji@neko.com";
        Optional<User> user = userMapper.findByEmail(email);
        assertThat(user)
                .isPresent()
                .hasValueSatisfying(u -> assertThat(u)
                        .isEqualTo(new User(2, "deji", email)));
    }

    @Test
    @Sql(
            scripts = {"classpath:/sqlannotation/delete-users.sql","classpath:/sqlannotation/insert-users.sql"},
            executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD
    )
    @Transactional
    void ユーザーを登録できること() {
        User user = new User("kuro", "kuro@neko.com");
        userMapper.insert(user);
        int userId = user.getId();

        List<User> allUsers = userMapper.findAll();
        assertThat(allUsers)
                .hasSize(4)
                .contains(
                        new User(1,"megu", "megu@neko.com"),
                        new User(2,"deji", "deji@neko.com"),
                        new User(3,"mopu", "mopu@neko.com"),
                        new User(userId,"kuro", "kuro@neko.com")
                );
    }
}
