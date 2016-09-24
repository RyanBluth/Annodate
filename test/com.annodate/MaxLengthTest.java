package com.annodate;

import com.annodate.annotations.MaxLength;
import com.annodate.exception.TypeNotSupportedException;
import org.junit.Rule;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

@RunWith(JUnit4.class)
public class MaxLengthTest {

    class TestClass{

        @MaxLength(1)
        ArrayList<String> validCollection = new ArrayList<String>( Arrays.asList(""));

        @MaxLength(1)
        String validString = "1";

        @MaxLength(1)
        int[] validArray = {1} ;

        @MaxLength(1)
        ArrayList<String> invalidCollection = new ArrayList<String>( Arrays.asList("", ""));

        @MaxLength(1)
        String invalidString = "1234567";

        @MaxLength(1)
        int[] invalidArray = {1, 2};

    }

    class InvalidTypeTestClass{

        @MaxLength(1)
        int invalidType = 5;

    }

    @Test
    public void testMaxLength(){
        MaxLengthTest.TestClass c = new MaxLengthTest.TestClass();
        List<AnnodateError> errors = Annodate.validate(c);

        assertEquals( errors.size(), 3);
        assertTrue( errors.get(0).getField().equals("invalidCollection"));
        assertTrue( errors.get(1).getField().equals("invalidString"));
        assertTrue( errors.get(2).getField().equals("invalidArray"));
    }

    @Test
    public void testInvalidType(){
        MaxLengthTest.InvalidTypeTestClass c = new MaxLengthTest.InvalidTypeTestClass();
        try{
            Annodate.validate(c);
            fail();
        }catch ( Exception ex ){
            assertTrue( ex instanceof TypeNotSupportedException );
        }
    }
}
