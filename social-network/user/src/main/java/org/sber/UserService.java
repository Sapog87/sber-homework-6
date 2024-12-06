package org.sber;

public interface UserService {
    boolean login(String username, String password);

    User getUserById(String id);

    User getUserByUsername(String username);
}
