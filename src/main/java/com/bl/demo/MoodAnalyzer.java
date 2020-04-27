package com.bl.demo;

import com.bl.demo.Exception.ExceptionTypeClass;
import com.bl.demo.Exception.MoodAnalyzerException;

import java.util.Objects;

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
            else if(message.equals(""))
                throw new MoodAnalyzerException(ExceptionTypeClass.EMPTYEXCEPTION);
            else
                return "Happy";
        }catch (NullPointerException e){
            throw new MoodAnalyzerException(ExceptionTypeClass.NULLEXCEPTION);
        }
    }

    @Override
    public boolean equals(Object obj) {
        return (((MoodAnalyzer) obj).message==this.message);
    }

}
