package com.annodate;

import com.annodate.annotations.NotNull;
import com.annodate.annotations.OneOf;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

@RunWith(JUnit4.class)
public class OneOfTest {

    class TestClass{

        @OneOf({"a", "b", "c"})
        String valid1 = "a";


        @OneOf({"1", "2", "3"})
        int valid2 = 2;

        @OneOf({"a", "b", "c"})
        String invalid1 = "d";


        @OneOf({"1", "2", "3"})
        int invalid2 = 4;

    }

    @Test
    public void testOneOf(){
        TestClass c = new TestClass();
        List<AnnodateError> errors = Annodate.validate(c);

        assertEquals( errors.size(), 2);
        assertTrue( errors.get(0).getField().equals("invalid1"));
        assertTrue( errors.get(1).getField().equals("invalid2"));
    }

}
