package com.annodate;


import com.annodate.annotations.MatchPattern;
import com.annodate.annotations.MatchRegex;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import java.util.List;

@RunWith(JUnit4.class)
public class PatternTest {

    class TestClass{

        @MatchPattern("aA##$@@--#")
        String valid = "tE34!aA--1";

        @MatchPattern("aA##$@@--#")
        String invalid = "tE34!aA~-1";

        @MatchPattern("aA##$@@--#")
        String valid1 = "tE34\\aA--1";

        @MatchPattern("aA##$@@--#")
        String invalid1 = "TE34!aA--1";

    }

    @Test
    public void testMatches(){
        TestClass tc = new TestClass();
        List<AnnodateError> errors = Annodate.validate( tc );
        Assert.assertEquals( 2, errors.size());
        Assert.assertTrue( errors.get(0).getField().equals( "invalid" ) );
        Assert.assertTrue( errors.get(1).getField().equals( "invalid1" ) );
    }

}
