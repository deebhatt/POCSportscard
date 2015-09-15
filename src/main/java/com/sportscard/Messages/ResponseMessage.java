package com.sportscard.Messages;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.sportscard.entity.BaseEntity;

public class ResponseMessage {

    public enum Type {
        success, warn, error, info, danger;
    }

    private final Type type;
    private final String text;
    private String id;
    private List<? extends BaseEntity> list;

    public ResponseMessage(Type type, String text) {
        this.type = type;
        this.text = text;
    }
    
    public ResponseMessage(Type type, String text, String id) {
        this.type = type;
        this.text = text;
        this.id = id;
    }
    
    public ResponseMessage(Type type, String text, List<? extends BaseEntity> list)
    {
    	this.type = type;
        this.text = text;
        this.list = list;
    }

    public String getId() {
        return id;
    }
    
    public String getText() {
        return text;
    }

    public Type getType() {
        return type;
    }

}
