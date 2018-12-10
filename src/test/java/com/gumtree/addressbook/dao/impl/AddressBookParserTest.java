package com.gumtree.addressbook.dao.impl;

import java.io.FileNotFoundException;

import static org.junit.Assert.assertEquals;
import org.junit.Before;
import org.junit.Test;

import com.gumtree.addressbook.dao.impl.AddressBookParser;

/**
 * The Class AddressBookParser.
 */
public class AddressBookParserTest {
    
    AddressBookParser adr;
    
    @Before
    public void setUp() {
        adr = new AddressBookParser();
    }

    @Test
    public void testProcessInputFile() throws FileNotFoundException {
        assertEquals(6, adr.processInputFile("src/test/resources/addressTest.txt").size());
    }
}
