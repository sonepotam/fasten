package ru.pavel2107.fasten.model;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonNode;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/**
 * Created by pavel2107 on 25.04.16.
 */
class WebMessageDeserializer extends JsonDeserializer<WebMessage> {

    @Override
    public WebMessage deserialize(JsonParser parser, DeserializationContext context)
            throws IOException, JsonProcessingException {

        JsonNode node = parser.getCodec().readTree( parser);
        WebMessage message = new WebMessage();
        message.setSequence_id( node.get( "sequence_id").asText());
        message.setType(WEB_MESSAGE_TYPE.valueOf(node.get("type").asText()));

        List<WebMessageData> list = new ArrayList<>();
        Iterator<Map.Entry<String, JsonNode>> iterator=  node.get("data").fields();
        while( iterator.hasNext()){
            Map.Entry<String, JsonNode> pair = iterator.next();
            String fieldName = pair.getKey();
            list.add( new WebMessageData( fieldName, pair.getValue().asText()));

        }
        message.setData( list);

        return message;
    }
}