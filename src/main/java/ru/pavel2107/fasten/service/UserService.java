package ru.pavel2107.fasten.service;

import ru.pavel2107.fasten.model.User;

/**
 * Created by admin on 24.04.2016.
 */
public interface UserService {
    User get(String email);
    boolean checkPassword( String email, String password);
}
