package com.bl.demo.Exception;

import com.bl.demo.MoodAnalyzer;

public class MoodAnalyzerException extends RuntimeException{
    String notice;

    public MoodAnalyzerException(ExceptionTypeClass e){
        this.notice=e.getNotice();
    }

    public String getNotice(){
        return this.notice;
    }
}
