package ru.pavel2107.fasten.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.pavel2107.fasten.model.User;

/**
 * Created by admin on 24.04.2016.
 */
public interface UserRepository extends JpaRepository<User, Integer> {
    User findByEmail( String email);
}
