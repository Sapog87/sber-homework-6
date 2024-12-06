package org.sber;

import lombok.AllArgsConstructor;

import java.util.*;

@AllArgsConstructor
public class DumbFriendServiceImpl implements FriendService {
    private final Map<String, Set<User>> friends = new HashMap<>();
    private final UserService userService;

    @Override
    public boolean addFriend(String firstUserid, String secondUserId) {
        User firstUser = userService.getUserById(firstUserid);
        User secondUser = userService.getUserById(secondUserId);

        // вместо сохранения в бд
        boolean added = friends.computeIfAbsent(firstUserid, k -> new HashSet<>()).add(secondUser);
        if (added) {
            added = friends.computeIfAbsent(secondUserId, k -> new HashSet<>()).add(firstUser);
            // что-то вроде rollback
            if (!added) {
                friends.get(firstUserid).remove(secondUser);
            }
        }

        return added;
    }

    @Override
    public boolean removeFriend(String firstUserid, String secondUserId) {
        User firstUser = userService.getUserById(firstUserid);
        User secondUser = userService.getUserById(secondUserId);

        // вместо сохранения в бд
        boolean removed = friends.getOrDefault(firstUserid, Collections.emptySet()).remove(secondUser);
        if (removed) {
            removed = friends.getOrDefault(secondUserId, Collections.emptySet()).remove(firstUser);
            // что-то вроде rollback
            if (!removed) {
                friends.get(firstUserid).add(secondUser);
            }
        }

        return removed;
    }

    @Override
    public List<User> getFriends(String userId) {
        return List.copyOf(friends.getOrDefault(userId, Collections.emptySet()));
    }
}
