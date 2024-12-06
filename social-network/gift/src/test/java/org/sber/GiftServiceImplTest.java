package org.sber;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
class GiftServiceImplTest {

    @Mock
    UserService userService;

    @InjectMocks
    GiftServiceImpl giftService;

    @Test
    void giveGiftTo() {
        //given
        doReturn(new User("0", "username", "password")).when(userService).getUserById(anyString());

        //when
        boolean result = giftService.giveGiftTo("1", new Gift("0", "gift"));

        //then
        verify(userService).getUserById(anyString());
        assertTrue(result);
    }
}