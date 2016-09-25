package com.annodate;


import com.annodate.annotations.MatchRegex;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import java.util.List;

@RunWith(JUnit4.class)
public class RegexTest {

    class TestClass{

        @MatchRegex("test")
        String valid = "test";

        @MatchRegex("test")
        String invalid = "testt";

    }

    @Test
    public void testEmail(){
        TestClass tc = new TestClass();
        List<AnnodateError> errors = Annodate.validate( tc );
        Assert.assertEquals( 1, errors.size());
        Assert.assertTrue( errors.get(0).getField().equals( "invalid" ) );
    }

}
