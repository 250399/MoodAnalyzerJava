package com.bl.demo.Exception;

public enum ExceptionTypeClass {
    NULLEXCEPTION("Mood cannot be null"),
    EMPTYEXCEPTION("Mood cannot be empty"),
    NOSUCHCLASSEXCEPTION("No such class found"),
    NOSUCHMETHODEXCEPTION("No such method found"),
    NOSUCHFIELDEXCEPTION("No such field available");

    private String notice;

    ExceptionTypeClass(String notice){
        this.notice=notice;
    }

    public String getNotice(){
        return this.notice;
    }

}
