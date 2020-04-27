package com.bl.demo;

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
        if(message.toLowerCase().contains("sad"))
            return "Sad";
        return "Happy";
    }
}
