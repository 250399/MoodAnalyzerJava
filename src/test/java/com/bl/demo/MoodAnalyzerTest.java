package com.bl.demo;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class MoodAnalyzerTest {
    MoodAnalyzer moodObject;

    @Test
    public void givenSadMessage_ReturnsSad(){
        moodObject = new MoodAnalyzer();
        Assert.assertEquals("Sad",moodObject.analyseMood("I am in Sad mood"));
    }

}