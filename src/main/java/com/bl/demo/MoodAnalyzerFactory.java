package com.bl.demo;

import com.bl.demo.Exception.ExceptionTypeClass;
import com.bl.demo.Exception.MoodAnalyzerException;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class MoodAnalyzerFactory {

    static Class moodObject;

    public static void createMoodAnalyzerObject(String className){
        try {
            moodObject = Class.forName(className);
        } catch (ClassNotFoundException e) {
            throw new MoodAnalyzerException(ExceptionTypeClass.NOSUCHCLASSEXCEPTION);
        }
    }

    public static Object returnMoodAnalyzerObject(String className,boolean methodException){
        createMoodAnalyzerObject(className);
        try {
            Constructor constructor;
            if(methodException==true)
                constructor = moodObject.getDeclaredConstructor(Integer.class);
            else
                constructor = moodObject.getDeclaredConstructor();
            return constructor.newInstance();
        } catch (NoSuchMethodException e) {
            throw new MoodAnalyzerException(ExceptionTypeClass.NOSUCHMETHODEXCEPTION);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static Object returnMoodAnalyzerObject(String className,Class parameterType, String message){
        createMoodAnalyzerObject(className);
        try {
            Constructor constructor = moodObject.getDeclaredConstructor(parameterType);
            return constructor.newInstance(message);
        } catch (NoSuchMethodException e) {
            throw new MoodAnalyzerException(ExceptionTypeClass.NOSUCHMETHODEXCEPTION);
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
