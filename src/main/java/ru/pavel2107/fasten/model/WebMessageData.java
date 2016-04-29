package ru.pavel2107.fasten.model;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Table;

/**
 * Created by admin on 24.04.2016.
 */
@Table( name ="messages_data")
@Embeddable
public class WebMessageData {

    @Column(name ="fieldname")
    String fieldName;

    @Column( name = "fieldvalue")
    String fieldValue;

    public WebMessageData() {}

    public WebMessageData(String fieldName, String fieldValue) {
        this.fieldName = fieldName;
        this.fieldValue = fieldValue;
    }

    public String getFieldName() {
        return fieldName;
    }

    public void setFieldName(String fieldName) {
        this.fieldName = fieldName;
    }

    public String getFieldValue() {
        return fieldValue;
    }

    public void setFieldValue(String fieldValue) {
        this.fieldValue = fieldValue;
    }
}
