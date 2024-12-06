package org.sber;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.doReturn;

@ExtendWith(MockitoExtension.class)
class UserServiceTest {

    @Mock
    UserService userService;

    @Test
    void login() {
        //given
        doReturn(true).when(userService).login(anyString(), anyString());

        //when
        boolean result = userService.login("username", "password");

        //then
        assertTrue(result);
    }

    @Test
    void getUserById() {
        //given
        doReturn(new User("0", "username", "password")).when(userService).getUserById("0");

        //when
        User result = userService.getUserById("0");

        //then
        assertNotNull(result);
        assertEquals("username", result.getUsername());
    }

    @Test
    void getUserByUsername() {
        //given
        doReturn(new User("0", "username", "password")).when(userService).getUserByUsername("username");

        //when
        User result = userService.getUserByUsername("username");

        //then
        assertNotNull(result);
        assertEquals("username", result.getUsername());
    }
}