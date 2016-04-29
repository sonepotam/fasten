package ru.pavel2107.fasten.web;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.module.SimpleModule;
import com.fasterxml.jackson.databind.node.IntNode;
import org.junit.Test;
import ru.pavel2107.fasten.model.User;
import ru.pavel2107.fasten.model.WEB_MESSAGE_TYPE;
import ru.pavel2107.fasten.model.WebMessage;
import ru.pavel2107.fasten.model.WebMessageData;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import static org.junit.Assert.*;

/**
 * Created by pavel2107 on 25.04.16.
 */
public class EchoServerTest {

    @Test
    public void testOnOpen() throws Exception {

    }

    @Test
    public void testOnMessage() throws Exception {
        String message = "{" +
                "  \"type\":\"LOGIN_CUSTOMER\"," +
                "  \"sequence_id\":\"a29e4fd0-581d-e06b-c837-4f5f4be7dd18\"," +
                "  \"data\":{" +
                "    \"email\":\"fpi@bk.ru\"," +
                "    \"password\":\"123123\"" +
                "  }" +
                "}";
        System.out.println( message);

        ObjectMapper mapper = new ObjectMapper();
        WebMessage webMessage = mapper.readValue( message, WebMessage.class);
        System.out.println( mapper.writeValueAsString( webMessage));

    }

    @Test
    public void testOnError() throws Exception {

    }

    @Test
    public void testOnClose() throws Exception {

    }
}


