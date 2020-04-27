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
        try {
            if(message.toLowerCase().contains("sad"))
                return "Sad";
            return "Happy";
        }catch (NullPointerException e){
            return "Sad";
        }
    }
}
