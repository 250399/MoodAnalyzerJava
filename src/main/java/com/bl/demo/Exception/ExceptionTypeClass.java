package com.bl.demo.Exception;

public enum ExceptionTypeClass {
    NULLEXCEPTION("Mood cannot be null"),
    EMPTYEXCEPTION("Mood cannot be empty"),
    NOSUCHCLASSEXCEPTION("No such class found");

    private String notice;

    ExceptionTypeClass(String notice){
        this.notice=notice;
    }

    public String getNotice(){
        return this.notice;
    }

}
