package org.sber;

import java.util.List;

public interface FriendService {
    boolean addFriend(String firstUserid, String secondUserId);

    boolean removeFriend(String firstUserid, String secondUserId);

    List<User> getFriends(String userId);
}
