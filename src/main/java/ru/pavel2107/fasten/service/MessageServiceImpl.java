package ru.pavel2107.fasten.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.pavel2107.fasten.model.WebMessage;
import ru.pavel2107.fasten.repository.MessageRepository;

import java.util.List;

/**
 * Created by admin on 24.04.2016.
 */
@Service( "MessageService")
@Transactional( readOnly = true)
public class MessageServiceImpl implements MessageService{

    @Autowired
    MessageRepository repository;

    @Transactional( readOnly =false)
    public WebMessage save( WebMessage webMessage){
        return repository.save( webMessage);
    }
}
