package com.bl.demo;

public class MoodAnalyzer {
    String message;

    String analyseMood(String message){
        if(message.toLowerCase().contains("happy"))
            return "Happy";
        return "Sad";
    }
}
