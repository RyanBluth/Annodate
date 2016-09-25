package com.annodate;

import com.annodate.annotations.MinLength;
import com.annodate.exception.TypeNotSupportedException;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

@RunWith(JUnit4.class)
public class MinLengthTest {

    class TestClass{

        @MinLength(2)
        ArrayList<String> invalidCollection = new ArrayList<String>( Arrays.asList(""));

        @MinLength(2)
        String invalidString = "2";

        @MinLength(2)
        int[] invalidArray = {2} ;

        @MinLength(2)
        ArrayList<String> validCollection = new ArrayList<String>( Arrays.asList("", ""));

        @MinLength(2)
        String validString = "2234567";

        @MinLength(2)
        int[] validArray = {1, 2};

    }

    class InvalidTypeTestClass{

        @MinLength(2)
        int invalidType = 5;

    }

    @Test
    public void testMinLength(){
        MinLengthTest.TestClass c = new MinLengthTest.TestClass();
        List<AnnodateError> errors = Annodate.validate(c);

        assertEquals( errors.size(), 3);
        assertTrue( errors.get(0).getField().equals("invalidCollection"));
        assertTrue( errors.get(1).getField().equals("invalidString"));
        assertTrue( errors.get(2).getField().equals("invalidArray"));
    }

    @Test
    public void testInvalidType(){
        MinLengthTest.InvalidTypeTestClass c = new MinLengthTest.InvalidTypeTestClass();
        try{
            Annodate.validate(c);
            fail();
        }catch ( Exception ex ){
            assertTrue( ex instanceof TypeNotSupportedException );
        }
    }
}
