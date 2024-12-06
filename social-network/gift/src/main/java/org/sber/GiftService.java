package org.sber;

public interface GiftService {
    Gift findGiftById(String id);

    boolean giveGiftTo(String userId, Gift gift);
}
