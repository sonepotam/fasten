package ru.pavel2107.fasten.model;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

import java.io.IOException;

/**
 * Created by pavel2107 on 26.04.16.
 */
public class WebMessageSerializer extends JsonSerializer<WebMessage>{
    @Override
    public void serialize(WebMessage webMessage, JsonGenerator jsonGenerator, SerializerProvider provider)
            throws IOException, JsonProcessingException {
        jsonGenerator.writeStartObject();
        jsonGenerator.writeStringField( "type", webMessage.getType().toString());
        jsonGenerator.writeStringField( "sequence_id", webMessage.getSequence_id());
        jsonGenerator.writeFieldName( "data");
        jsonGenerator.writeStartObject();

        for( WebMessageData messageData: webMessage.getData()){
           jsonGenerator.writeStringField( messageData.getFieldName(), messageData.getFieldValue());
        }
        jsonGenerator.writeEndObject();


        jsonGenerator.writeEndObject();
    }

}

