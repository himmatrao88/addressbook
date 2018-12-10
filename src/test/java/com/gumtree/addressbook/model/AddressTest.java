package com.gumtree.addressbook.model;

import java.time.LocalDate;

import org.junit.Test;

import com.gumtree.addressbook.model.Address;
import com.gumtree.addressbook.model.Gender;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

public class AddressTest {
    
    @Test
    public void testEqualsAndHashCode() {
        Address ad1 = new Address.AddressBuilder()
                .name("Himmat Rao").gender(Gender.MALE).dateOfBirth(LocalDate.of(1988,  8, 22)).build();
        Address ad2 = new Address.AddressBuilder()
                .name("Rajiv Gandhi").gender(Gender.MALE).dateOfBirth(LocalDate.of(1984, 5, 23)).build();
        Address ad3 = new Address.AddressBuilder()
                .name("Himmat Rao").gender(Gender.MALE).dateOfBirth(LocalDate.of(1988,  8, 22)).build();
      assertEquals(ad1, ad3);
      assertNotEquals(ad1, ad2);
    }

}
