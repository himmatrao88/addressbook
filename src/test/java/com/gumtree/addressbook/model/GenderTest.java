package com.gumtree.addressbook.model;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.gumtree.addressbook.model.Gender;

/**
 * The Test calss for Enum Gender.
 */
public class GenderTest {
    
    @Test
    public void testMale() {
        assertEquals("Male", Gender.MALE.getValue());
    }
    
    @Test
    public void testFemale() {
        assertEquals("Female", Gender.FEMALE.getValue());

    }
    
    @Test(expected = NullPointerException.class)
    public void testForNullPointerException() {
        Gender.fromString(null);
    }
    
    @Test(expected = IllegalArgumentException.class)
    public void testForIllegalArgumentException() {
        Gender.fromString("Him");
    }

}
