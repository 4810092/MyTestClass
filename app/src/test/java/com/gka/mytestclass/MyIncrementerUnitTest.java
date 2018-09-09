package com.gka.mytestclass;

import com.gka.mytestclass.incrementer.MyIncrementer;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class MyIncrementerUnitTest {


    private MyIncrementer myIncrementer;

    @Before
    public void setUp() {
        myIncrementer = new MyIncrementer();
    }


    @Test
    public void testIncrement() {

        assertEquals(myIncrementer.getNumber(), 0);

        myIncrementer.incrementNumber();
        myIncrementer.incrementNumber();
        myIncrementer.incrementNumber();

        assertEquals(myIncrementer.getNumber(), 3);

        myIncrementer.setMaximumValue(6);

        assertEquals(myIncrementer.getNumber(), 3);


        myIncrementer.setMaximumValue(2);

        assertEquals(myIncrementer.getNumber(), 0);

    }

    @Test
    public void testCurrentValue() {

        for (long i = 1; i <= Integer.MAX_VALUE; i++) {
            myIncrementer.incrementNumber();
            assertEquals(myIncrementer.getNumber(), i);
        }

        myIncrementer.incrementNumber();

        assertEquals(myIncrementer.getNumber(), 0);


        myIncrementer.setMaximumValue(0);

        assertEquals(myIncrementer.getNumber(), 0);

        myIncrementer.incrementNumber();

        assertEquals(myIncrementer.getNumber(), 0);


    }

    @Test(expected = RuntimeException.class)
    public void testMaxToNegative() {
        myIncrementer.setMaximumValue(-2);
    }

    @Test(expected = RuntimeException.class)
    public void testMaxToExtraLarge() {
        myIncrementer.setMaximumValue(Integer.MAX_VALUE + 10);
    }
}