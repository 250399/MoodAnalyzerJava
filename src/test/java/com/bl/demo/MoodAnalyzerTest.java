package com.bl.demo;

import com.bl.demo.Exception.ExceptionTypeClass;
import com.bl.demo.Exception.MoodAnalyzerException;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class MoodAnalyzerTest {
    MoodAnalyzer moodObject;

    @Test
    public void givenMessage_WhenSad_ReturnsSad(){
        moodObject = new MoodAnalyzer();
        Assert.assertEquals("Sad",moodObject.analyseMood("I am in Sad mood"));
    }

    @Test
    public void givenMessage_WhenHappy_ReturnsHappy(){
        moodObject  = new MoodAnalyzer();
        Assert.assertEquals("Happy",moodObject.analyseMood("I am in Any mood"));
    }

    @Test
    public void givenMessageSad_WhenInConstructor_ReturnsSad(){
        Assert.assertEquals( "Sad",new MoodAnalyzer("I am in Sad mood").analyseMood());
    }

    @Test
    public void givenMessageHappy_WhenInConstructor_ReturnsHappy(){
        Assert.assertEquals("Happy",new MoodAnalyzer("I am in Happy mood").analyseMood());
    }

    @Test
    public void givenMessageNull_WhenInConstructor_ThrowsCustomException(){
        try {
            moodObject = new MoodAnalyzer(null);
            moodObject.analyseMood();
        }catch (MoodAnalyzerException e){
            Assert.assertEquals("Mood cannot be null",e.getNotice());
        }
    }

    @Test
    public void givenEmptyMessage_ShouldThrow_EmptyException(){
        try {
            moodObject = new MoodAnalyzer("");
            moodObject.analyseMood();
        }catch (MoodAnalyzerException e){
            Assert.assertEquals("Mood cannot be empty",e.getNotice());
        }
    }

    @Test
    public void givenClassName_ReturnsMoodAnalyzerObject(){
        moodObject = new MoodAnalyzer();
        MoodAnalyzer obj = (MoodAnalyzer) MoodAnalyzerFactory.returnMoodAnalyzerObject("com.bl.demo.MoodAnalyzer",false);
        Assert.assertTrue(moodObject.equals(obj));
    }

    @Test
    public void givenClassName_WhenImproper_ShouldReturnException(){
        try {
            MoodAnalyzerFactory.returnMoodAnalyzerObject("com.bl.demo.WrongClass",false);
        }catch (MoodAnalyzerException e){
            Assert.assertEquals("No such class found",e.getNotice());
        }
    }

    @Test
    public void givenClass_WhenConstructor_NotProper_ThrowsException(){
        try {
            MoodAnalyzerFactory.returnMoodAnalyzerObject("com.bl.demo.MoodAnalyzer",true);
        }catch (MoodAnalyzerException e){
            Assert.assertEquals("No such method found",e.getNotice());
        }
    }

    @Test
    public void givenClassName_ReturnsMoodAnalyzerObject_ForParameterizedConstructor(){
        moodObject =  new MoodAnalyzer("I am in happy mood");
        Object obj = MoodAnalyzerFactory.returnMoodAnalyzerObject("com.bl.demo.MoodAnalyzer",String.class,"I am in happy mood");
        Assert.assertTrue(moodObject.equals(obj));
    }

    @Test
    public void givenClassName_WhenImproper_ShouldReturnException_ForParameterizedConstructor(){
        try {
            MoodAnalyzerFactory.returnMoodAnalyzerObject("com.bl.demo.WrongClass",String.class,"I am in happy mood");
        }catch (MoodAnalyzerException e){
            Assert.assertEquals("No such class found",e.getNotice());
        }
    }

    @Test
    public void givenClassName_WhenConstructorImproper_ShouldReturnException_ForParameterized(){
        try {
            MoodAnalyzerFactory.returnMoodAnalyzerObject("com.bl.demo.MoodAnalyzer",Integer.class,"I am in happy mood");
        }catch (MoodAnalyzerException e){
            Assert.assertEquals("No such method found",e.getNotice());
        }
    }

    @Test
    public void givenHappyMessage_UsingReflection_WhenProperReturnHappy(){
        Assert.assertEquals("Happy",MoodAnalyzerFactory.invokeMethod("com.bl.demo.MoodAnalyzer","analyseMood",String.class,"I am in happy mood"));
    }

}