package ru.pavel2107.fasten.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.pavel2107.fasten.model.User;
import ru.pavel2107.fasten.repository.UserRepository;

/**
 * Created by admin on 24.04.2016.
 */

@Service( "UserService")
@Transactional( readOnly = true)
public class UserServiceImpl implements UserService {

    @Autowired
    UserRepository repository;

    @Override
    public User get(String email) {
        return repository.findByEmail( email);
    }

    public boolean checkPassword( String email, String password){
        boolean result = false;
        User user = repository.findByEmail( email);
        result = user != null && user.getPassword().equals( password);

        return result;
    }

}
