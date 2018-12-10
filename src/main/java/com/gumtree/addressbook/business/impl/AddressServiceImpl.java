package com.gumtree.addressbook.business.impl;

import java.time.temporal.ChronoUnit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gumtree.addressbook.business.AddressService;
import com.gumtree.addressbook.dao.AddressDAO;
import com.gumtree.addressbook.model.Address;
import com.gumtree.addressbook.model.Gender;

/**
 * The Class AddressServiceImpl.
 */
@Service
public class AddressServiceImpl implements AddressService{
    
    /** The address DAO. */
    @Autowired
    private AddressDAO addressDAO;
    
    @Override
    public String getOldestPersonName() {
        Address address = addressDAO.getOldestPerson();
        if(address == null){
            System.err.println("WARN: List it empty");
            return null;
        } else {
            return address.getName();
        }
    }
    
    @Override
    public long getCountOfMales() {
        return addressDAO.getCountBasedOnGender(Gender.MALE);
    }
    
    @Override
    public long getDifferenceInDays(final String name1, final String name2) {
        Address ad1 = addressDAO.getAddressByName(name1);
        Address ad2 = addressDAO.getAddressByName(name2);
        if(ad1 == null || ad2 == null) {
            System.err.println("WARN: No address found for supplied name.");
            return 0L;
        }
        return ChronoUnit.DAYS.between(ad1.getDateOfBirth(), ad2.getDateOfBirth());
    }
}
