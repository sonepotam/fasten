package ru.pavel2107.fasten.web;

/**
 * Created by admin on 24.04.2016.
 */
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.context.ContextLoader;
import org.springframework.web.context.support.SpringBeanAutowiringSupport;
import ru.pavel2107.fasten.model.WEB_MESSAGE_TYPE;
import ru.pavel2107.fasten.model.WebMessage;
import ru.pavel2107.fasten.model.WebMessageData;
import ru.pavel2107.fasten.service.MessageService;
import ru.pavel2107.fasten.service.UserService;

import java.io.IOException;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

import javax.annotation.PostConstruct;
import javax.inject.Inject;
import javax.websocket.*;
import javax.websocket.server.ServerEndpoint;
import javax.websocket.server.ServerEndpointConfig.Configurator;


@ServerEndpoint(value = "/echo")
@Controller
public class EchoServer {


    public EchoServer(){
        System.out.println( "EchoServer created");
    }


    @OnOpen
    public void onOpen(Session session){
        try {
            session.getBasicRemote().sendText("Connection Established");
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }


    @OnMessage
    public void onMessage(String message, Session session){

        //
        // получаем контекст, т.к. при каждом новом полученном сообщении мы работаем с новым экземпляром класса
        //
        ApplicationContext context = ContextLoader.getCurrentWebApplicationContext();
        //
        // получаем сервисы из контекста спринга

        MessageService messageService = context.getBean( MessageService.class);
        UserService userService       = context.getBean( UserService.class);


        WebMessage outputMessage = new WebMessage();
        List<WebMessageData> list  = new ArrayList<>();

        ObjectMapper mapper = new ObjectMapper();
        try {
            WebMessage inputMessage    = mapper.readValue( message, WebMessage.class);

            String email = inputMessage.getData()
                    .stream()
                    .filter( p -> p.getFieldName().equals( "email"))
                    .findFirst()
                    .get()
                    .getFieldValue();

            String password = inputMessage.getData()
                    .stream()
                    .filter( p -> p.getFieldName().equals( "password"))
                    .findFirst()
                    .get()
                    .getFieldValue();

            //
            // проверяем пароль
            //
            boolean result = userService.checkPassword( email, password);
            //
            // убираем пароль
            //
            inputMessage.setData(
                    inputMessage.getData()
                            .stream()
                            .filter(p -> !p.getFieldName().equals("password"))
                            .collect(Collectors.toList())
            );
            //
            // сохраняем входящее сообщение
            //
            messageService.save( inputMessage);
            //
            // создаем ответное сообщение
            //
            outputMessage.setSequence_id( inputMessage.getSequence_id());
            if( result){
                //
                // проверяем тип сообщения
                //
                if( inputMessage.getType() == WEB_MESSAGE_TYPE.LOGIN_CUSTOMER) {
                    outputMessage.setType(WEB_MESSAGE_TYPE.CUSTOMER_API_TOKEN);
                    list.add(new WebMessageData("api_token", UUID.randomUUID().toString()));

                    ZonedDateTime expDate = ZonedDateTime.now().plusHours(1);
                    String strDate = expDate.format(DateTimeFormatter.ofPattern("yyyy-MM-dd")) + "T" +
                            expDate.format(DateTimeFormatter.ofPattern("HH:mm:ss")) + "Z";
                    list.add(new WebMessageData("api_token_expiration_date", strDate));
                } else {
                    outputMessage.setType( WEB_MESSAGE_TYPE.CUSTOMER_ERROR);
                    list.add( new WebMessageData( "error_description", "Message type unknown"));
                    list.add( new WebMessageData( "error_code"       , "message.unknown" ));
                }
            } else {
                outputMessage.setType( WEB_MESSAGE_TYPE.CUSTOMER_ERROR);
                list.add( new WebMessageData( "error_description", "Customer not found"));
                list.add( new WebMessageData( "error_code"       , "customer.notFound" ));
            }
            outputMessage.setData( list);
            //
            // отправляем сообщение об ошибке
            //
            session.getBasicRemote().sendText( mapper.writeValueAsString( outputMessage));
            //
            //
            // сохраняем информацию
            messageService.save( outputMessage);

        } catch ( Exception ex) {
            outputMessage.setType( WEB_MESSAGE_TYPE.CUSTOMER_ERROR);
            list.add( new WebMessageData( "error_description", ex.toString()));
            list.add( new WebMessageData( "error_code"       , "exception.deserializer" ));
            outputMessage.setData( list);
            try {
                session.getBasicRemote().sendText(mapper.writeValueAsString(outputMessage));
            }
            catch ( Exception e){ e.printStackTrace();}
            //
            //
            // сохраняем информацию
            messageService.save( outputMessage);
        }
    }


    @OnError
    public void onError(Session session, Throwable t) {
        t.printStackTrace();
    }


    @OnClose
    public void onClose(Session session){
        // TODO ???
    }
}