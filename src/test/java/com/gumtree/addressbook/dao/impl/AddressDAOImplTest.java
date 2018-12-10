package com.gumtree.addressbook.dao.impl;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import org.junit.Before;
import org.junit.Test;
import org.springframework.test.util.ReflectionTestUtils;

import com.gumtree.addressbook.dao.AddressDAO;
import com.gumtree.addressbook.dao.impl.AddressDAOImpl;
import com.gumtree.addressbook.model.Address;
import com.gumtree.addressbook.model.Gender;


public class AddressDAOImplTest {
    
    AddressDAO adr ;
    
    List<Address> addressList;
    
    private List<Address> getListOfAddress() {
        return Arrays.asList(
                new Address.AddressBuilder()
                .name("Ranbir Kapoor")
                .gender(Gender.MALE)
                .dateOfBirth(LocalDate.of(1988, 8, 22)).build(),
                
                new Address.AddressBuilder()
                .name("Sachin Tendular")
                .gender(Gender.MALE)
                .dateOfBirth(LocalDate.of(1973, 4, 24)).build(),
                
                new Address.AddressBuilder()
                .name("Indira Gandhi")
                .gender(Gender.FEMALE)
                .dateOfBirth(LocalDate.of(1925, 3, 11)).build(),
                
                new Address.AddressBuilder()
                .name("Gaytri Devi")
                .gender(Gender.FEMALE)
                .dateOfBirth(LocalDate.of(1932, 11, 13)).build(),
                
                new Address.AddressBuilder()
                .name("Rajiv Gandhi")
                .gender(Gender.MALE)
                .dateOfBirth(LocalDate.of(1944, 2, 11)).build()
                
                
                );
    }
    
    @Before
    public void setUp() {
       adr = new AddressDAOImpl();
       addressList = new ArrayList<>();
       addressList.addAll(getListOfAddress());
       ReflectionTestUtils.setField(adr, "addressList", addressList);
    }
    
    @Test
    public void testGetOldestPerson() {
        Address address = new Address.AddressBuilder()
                .name("Indira Gandhi")
                .gender(Gender.FEMALE)
                .dateOfBirth(LocalDate.of(1925, 3, 11)).build();
        assertEquals(address, adr.getOldestPerson());
    }
    
    @Test
    public void testGetAddressByName() {
        Address address = new Address.AddressBuilder()
                .name("Gaytri Devi")
                .gender(Gender.FEMALE)
                .dateOfBirth(LocalDate.of(1932, 11, 13)).build();
        assertEquals(address, adr.getAddressByName("Gaytri Devi"));
    }
    
    @Test
    public void testGetCountBasedOnGenderMale() {
        assertEquals(3, adr.getCountBasedOnGender(Gender.MALE));
    }
    
    @Test
    public void testGetCountBasedOnGenderFemale() {
        assertEquals(2, adr.getCountBasedOnGender(Gender.FEMALE));
    }
    
    @Test
    public void testGetAddressByName_NULL() {
        assertNull(adr.getAddressByName("Virat Kohli"));
    }
}
