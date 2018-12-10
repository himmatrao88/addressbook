package com.gumtree.addressbook.business.impl;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

import java.time.LocalDate;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;
import org.springframework.test.util.ReflectionTestUtils;

import com.gumtree.addressbook.business.AddressService;
import com.gumtree.addressbook.business.impl.AddressServiceImpl;
import com.gumtree.addressbook.dao.AddressDAO;
import com.gumtree.addressbook.model.Address;
import com.gumtree.addressbook.model.Gender;

public class AddressServiceImplTest {
    
    AddressService service;
    
    AddressDAO dao;
    
    @Before
    public void setUp() {
        dao = Mockito.mock(AddressDAO.class);
        service = new AddressServiceImpl();
        ReflectionTestUtils.setField(service, "addressDAO", dao);
     }
    
    @Test
    public void testGetCountOfMales() {
        when(dao.getCountBasedOnGender(Gender.MALE)).thenReturn(3L);
        assertEquals(3L, service.getCountOfMales());
    }
    
    @Test
    public void testGetDifferenceInDays_BothNamesNull() {
        assertEquals(0, service.getDifferenceInDays(null, null));
    }
    
    @Test
    public void testGetDifferenceInDays() {
        final String name1 = "Himmat Rao";
        final String name2 = "Rajiv Gandhi";
        Address ad1 = new Address.AddressBuilder()
                .name(name1).gender(Gender.MALE).dateOfBirth(LocalDate.of(1988,  8, 22)).build();
        Address ad2 = new Address.AddressBuilder()
                .name(name2).gender(Gender.MALE).dateOfBirth(LocalDate.of(1984, 5, 23)).build();
        when(dao.getAddressByName(name1)).thenReturn(ad1);
        when(dao.getAddressByName(name2)).thenReturn(ad2);
        assertEquals(1552, service.getDifferenceInDays(name2, name1));
    }
    
    @Test
    public void testGetDifferenceInDaysReverse() {
        final String name1 = "Himmat Rao";
        final String name2 = "Rajiv Gandhi";
        Address ad1 = new Address.AddressBuilder()
                .name(name1).gender(Gender.MALE).dateOfBirth(LocalDate.of(1988,  8, 22)).build();
        Address ad2 = new Address.AddressBuilder()
                .name(name2).gender(Gender.MALE).dateOfBirth(LocalDate.of(1984, 5, 23)).build();
        when(dao.getAddressByName(name1)).thenReturn(ad1);
        when(dao.getAddressByName(name2)).thenReturn(ad2);
        assertEquals(-1552, service.getDifferenceInDays(name1, name2));
    }
    
    @Test
    public void testGetDifferenceInDays_NameNotFound() {
        final String name1 = "Himmat Rao";
        final String name2 = "Rajiv Gandhi";
        Address ad1 = new Address.AddressBuilder()
                .name(name1).gender(Gender.MALE).dateOfBirth(LocalDate.of(1988,  8, 22)).build();
        when(dao.getAddressByName(name1)).thenReturn(ad1);
        when(dao.getAddressByName(name2)).thenReturn(null);
        assertEquals(0, service.getDifferenceInDays(name2, name2));
    }
    
    @Test
    public void testGetDifferenceInDays_BothNameNotFound() {
        final String name1 = "Himmat Rao";
        final String name2 = "Rajiv Gandhi";
        when(dao.getAddressByName(name1)).thenReturn(null);
        when(dao.getAddressByName(name2)).thenReturn(null);
        assertEquals(0, service.getDifferenceInDays(name1, name2));
    }
    
    @Test
    public void testGetOldestPersonName() {
        final String name1 = "Indira Gandhi";
        Address ad1 = new Address.AddressBuilder()
                .name(name1).gender(Gender.MALE).dateOfBirth(LocalDate.of(1988,  8, 22)).build();
        when(dao.getOldestPerson()).thenReturn(ad1);
        assertEquals(name1, service.getOldestPersonName());
    }
    
    @Test
    public void testGetOldestPersonName_EmptyList() {
        when(dao.getOldestPerson()).thenReturn(null);
        assertEquals(null, service.getOldestPersonName());
    }

}
