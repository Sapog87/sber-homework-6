package org.sber;

public interface RecommendationService {
    Gift recommendGiftFor(User user);

    Photo recommendPhotoFor(User user);

    User recommendFriendFor(User user);
}
