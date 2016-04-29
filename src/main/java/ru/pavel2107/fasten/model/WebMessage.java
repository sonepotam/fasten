package ru.pavel2107.fasten.model;



import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;

/**
 * Created by admin on 24.04.2016.
 */

@Entity
@Table( name="messages")
@JsonDeserialize(using = WebMessageDeserializer.class)
@JsonSerialize(  using = WebMessageSerializer.class)
public class WebMessage {

    @Id
    @SequenceGenerator( name="messages_generator", sequenceName = "messages_seq", allocationSize = 10)
    @GeneratedValue( strategy = GenerationType.SEQUENCE, generator = "messages_generator")
    @JsonIgnore
    private Integer ID;

    @Column( name="sequence_id")
    String sequence_id;

    @Column( name = "message_type")
    WEB_MESSAGE_TYPE type;



    public WebMessage() {}

    @ElementCollection( fetch = FetchType.LAZY)
    @JoinTable(
            name = "messages_data",
            joinColumns = @JoinColumn( name = "message_id")
    )
    @JsonProperty( "data")
    private Collection<WebMessageData> data = new ArrayList<>();

    public Collection<WebMessageData> getData() {
        return data;
    }

    public void setData(Collection<WebMessageData> data) {
        this.data = data;
    }



    public Integer getID() {
        return ID;
    }

    public void setID(Integer ID) {
        this.ID = ID;
    }

    public String getSequence_id() {
        return sequence_id;
    }

    public void setSequence_id(String sequenceID) {
        this.sequence_id = sequenceID;
    }

    public WEB_MESSAGE_TYPE getType() {
        return type;
    }

    public void setType(WEB_MESSAGE_TYPE messageType) {
        this.type = messageType;
    }
}
