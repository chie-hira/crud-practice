package com.raisetech.servicepractice.service;

import com.raisetech.servicepractice.entity.User;
import com.raisetech.servicepractice.mapper.UserMapper;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDate;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
public class UserServiceTest {
    @InjectMocks
    UserService userService;

    @Mock
    UserMapper userMapper;

    @Test
    public void 存在するユーザーのIDを指定したときに正常にユーザーが返されること() throws Exception {
        doReturn(Optional.of(new User(1, "megu", "megu@neko.com"))).when(userMapper).findById(1);
        User actual = userService.findUser(1);
        assertThat(actual).isEqualTo(new User(1, "megu", "megu@neko.com"));
        verify(userMapper, times(1)).findById(1);
    }


}
