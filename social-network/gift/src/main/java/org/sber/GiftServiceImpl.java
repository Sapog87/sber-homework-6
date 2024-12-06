package org.sber;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class GiftServiceImpl implements GiftService {
    private final UserService userService;

    @Override
    public Gift findGiftById(String id) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public boolean giveGiftTo(String userId, Gift gift) {
        User user = userService.getUserById(userId);
        // будто вручили подарок
        return true;
    }
}
