package ru.pavel2107.fasten.web;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import ru.pavel2107.fasten.model.WebMessage;
import ru.pavel2107.fasten.service.MessageService;
import ru.pavel2107.fasten.service.UserService;
import sun.misc.Contended;

import javax.inject.Inject;
import javax.websocket.OnMessage;
import javax.websocket.Session;
import javax.websocket.server.ServerEndpoint;
import java.io.IOException;

/**
 * Created by admin on 30.03.2016.
 */

@Controller
public class RootController {


    @Inject
    MessageService messageService;

    @Inject
    UserService userService;

    @Inject
    private ApplicationContext appContext;

    @RequestMapping(value = "/index", method = RequestMethod.GET)
    public String index() {
        return "index";
    }

    @RequestMapping( value="/", method = RequestMethod.GET)
    public String root(){
        return "redirect:/index.html";
    }



}
