package com.bl.demo;

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
    public void givenMessageNull_WhenInConstructor_ReturnsSad(){
        Assert.assertEquals("Sad",new MoodAnalyzer(null).analyseMood());
    }

}