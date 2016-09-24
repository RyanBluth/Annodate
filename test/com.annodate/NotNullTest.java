package com.annodate;

import com.annodate.annotations.NotNull;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

@RunWith(JUnit4.class)
public class NotNullTest {

    class TestClass{

        @NotNull
        String nullableIsNull = null;

        @NotNull
        String nullableNotNull = "1234567";

        @NotNull
        int notNullable = 5;

    }

    @Test
    public void testNotNull(){
        TestClass c = new TestClass();
        List<AnnodateError> errors = Annodate.validate(c);

        assertEquals( errors.size(), 1);
        assertTrue( errors.get(0).getField().equals("nullableIsNull"));
    }

}
