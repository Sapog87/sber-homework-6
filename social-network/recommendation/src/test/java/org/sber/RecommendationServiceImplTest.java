package org.sber;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
class RecommendationServiceImplTest {

    @Mock
    UserService userService;

    @Mock
    PhotoService photoService;

    @Mock
    GiftService giftService;

    @InjectMocks
    @Spy
    RecommendationServiceImpl recommendationService;

    @Test
    void recommendGiftFor() {
        doReturn(new Gift("0", "gift")).when(giftService).findGiftById(anyString());

        User user = new User("0", "username", "password");
        Gift gift = recommendationService.recommendGiftFor(user);

        assertNotNull(gift);
        assertEquals("gift", gift.getName());
        verify(giftService).findGiftById(anyString());
    }

    @Test
    void recommendPhotoFor() {
        doReturn(new Photo("0", "description", "path")).when(photoService).findPhotoById(anyString());

        User user = new User("0", "username", "password");
        Photo photo = recommendationService.recommendPhotoFor(user);

        assertNotNull(photo);
        assertEquals("description", photo.getDescription());
        verify(photoService).findPhotoById(anyString());
    }

    @Test
    void recommendFriendFor() {
        doReturn(new User("0", "username", "password")).when(userService).getUserById(anyString());

        User user = new User("1", "username1", "password1");
        User recommendedUser = recommendationService.recommendFriendFor(user);

        assertNotNull(recommendedUser);
        assertEquals("username", recommendedUser.getUsername());
        verify(userService).getUserById(anyString());
    }
}