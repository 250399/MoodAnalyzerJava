package com.bl.demo;

import com.bl.demo.Exception.ExceptionTypeClass;
import com.bl.demo.Exception.MoodAnalyzerException;

public class MoodAnalyzer {
    String message;

    MoodAnalyzer(){}

    MoodAnalyzer(String message){
        this.message=message;
    }

    String analyseMood(String message){
        this.message=message;
        return analyseMood();
    }

    String analyseMood(){
        try {
            if(message.toLowerCase().contains("sad"))
                return "Sad";
            else
                return "Happy";
        }catch (NullPointerException e){
            throw new MoodAnalyzerException(ExceptionTypeClass.NULLEXCEPTION);
        }
    }
}
