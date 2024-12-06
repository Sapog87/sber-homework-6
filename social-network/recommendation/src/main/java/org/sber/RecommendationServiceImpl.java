package org.sber;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class RecommendationServiceImpl implements RecommendationService {
    private final GiftService giftService;
    private final UserService userService;
    private final PhotoService photoService;

    @Override
    public Gift recommendGiftFor(User user) {
        //логика по определению того, какой подарок рекомендовать
        return giftService.findGiftById("id");
    }

    @Override
    public Photo recommendPhotoFor(User user) {
        //логика по определению того, какое фото рекомендовать
        return photoService.findPhotoById("id");
    }

    @Override
    public User recommendFriendFor(User user) {
        //логика по определению того, какого пользователя рекомендовать
        return userService.getUserById("id");
    }
}
