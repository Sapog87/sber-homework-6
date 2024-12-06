package org.sber;

import lombok.Data;

@Data
public class User {
    private final String id;
    private final String username;
    private final String password;
}
