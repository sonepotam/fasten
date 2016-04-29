package ru.pavel2107.fasten.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.pavel2107.fasten.model.WebMessage;

import java.util.List;

/**
 * Created by admin on 24.04.2016.
 */
public interface MessageRepository extends JpaRepository<WebMessage, Integer> {

}
