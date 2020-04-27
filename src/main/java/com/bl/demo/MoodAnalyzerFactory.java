package com.bl.demo;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class MoodAnalyzerFactory {

    static Class moodObject;

    public static void createMoodAnalyzerObject(String className){
        try {
             moodObject = Class.forName(className);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static Object returnMoodAnalyzerObject(String className){
        createMoodAnalyzerObject(className);
        try {
            Constructor constructor = moodObject.getDeclaredConstructor();
            return constructor.newInstance();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        return null;
    }
}
