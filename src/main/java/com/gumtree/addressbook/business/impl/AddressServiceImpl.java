package com.gumtree.addressbook.business.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gumtree.addressbook.business.AddressService;
import com.gumtree.addressbook.dao.AddressDAO;

@Service
public class AddressServiceImpl implements AddressService{
    
    @Autowired
    private AddressDAO addressDAO;
    
    @Override
    public String getOldestPersonName() {
        return null;
    }
    
    @Override
    public long getCountOfMales() {
        return 0L;
    }
    
    @Override
    public long getDifferenceInDays(final String name1, final String name2) {
        return 0L;
    }
}
