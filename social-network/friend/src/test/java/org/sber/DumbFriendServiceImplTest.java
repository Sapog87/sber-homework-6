package org.sber;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.lenient;

@ExtendWith(MockitoExtension.class)
class DumbFriendServiceImplTest {

    @Mock
    UserService userService;

    FriendService friendService;

    @BeforeEach
    void setUp() {
        //give
        friendService = new DumbFriendServiceImpl(userService);

        lenient().doReturn(new User("0", "username0", "password0")).when(userService).getUserById("0");
        lenient().doReturn(new User("1", "username1", "password1")).when(userService).getUserById("1");
        lenient().doReturn(new User("2", "username2", "password2")).when(userService).getUserById("2");
    }

    @Test
    void addFriend() {
        //when
        boolean firstTry = friendService.addFriend("0", "1");
        boolean secondTry = friendService.addFriend("1", "0");

        //then
        assertTrue(firstTry);
        assertFalse(secondTry);
    }

    @Test
    void removeFriend() {
        //given
        friendService.addFriend("0", "1");
        friendService.addFriend("0", "2");

        //when
        boolean firstTry = friendService.removeFriend("0", "1");
        boolean secondTry = friendService.removeFriend("0", "1");

        //then
        assertTrue(firstTry);
        assertFalse(secondTry);
    }

    @Test
    void getFriends() {
        //given
        friendService.addFriend("0", "1");
        friendService.addFriend("0", "2");

        //when
        List<User> friendsUser0 = friendService.getFriends("0");
        List<User> friendsUser1 = friendService.getFriends("1");
        List<User> friendsUser2 = friendService.getFriends("2");

        //then
        assertEquals(2, friendsUser0.size());
        assertTrue(List.of(
                        new User("1", "username1", "password1"),
                        new User("2", "username2", "password2")
                ).containsAll(friendsUser0)
        );
        assertEquals(1, friendsUser1.size());
        assertEquals(1, friendsUser2.size());
    }

    @Test
    void getNoFriends() {
        //when
        List<User> friends = friendService.getFriends("0");

        //then
        assertEquals(0, friends.size());
    }
}