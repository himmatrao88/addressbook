package com.gumtree.addressbook.dao.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;

import com.gumtree.addressbook.dao.AddressDAO;
import com.gumtree.addressbook.model.Address;
import com.gumtree.addressbook.model.Gender;

/**
 * The Class AddressDAOImpl.
 */
@Repository
public class AddressDAOImpl implements AddressDAO {
    
    /** The address list. */
    private List<Address> addressList;
    
    /** The parser. */
    @Autowired
    private AddressBookParser parser;
    
    /** The file name. */
    @Value("${address.book.filename}")
    private String fileName;
    
    /**
     * Init method for AddressDAOImpl.
     */
    @PostConstruct
    public void init() {
        initializeAddressList();
    }
    
    /**
     * Initialize address list.
     */
    private void initializeAddressList() {
        addressList = new ArrayList<Address>();
        addressList.addAll(parser.processInputFile(fileName));
    }
    
    @Override
    public Address getOldestPerson() {
        Optional<Address> address = addressList.stream()
                                    .sorted((a,b) -> a.getDateOfBirth().compareTo(b.getDateOfBirth()))
                                    .findFirst();
        return address.orElse(null);
    }
    
    @Override
    public long getCountBasedOnGender(final Gender gender) {
        return addressList.stream()
                .filter(address -> gender == address.getGender())
                .count();
    }
    
    @Override
    public Address getAddressByName(final String name) {
        Optional<Address> address = addressList.stream()
                                                .filter(ad -> ad.getName().equalsIgnoreCase(name))
                                                .findFirst();
        return address.orElse(null);
    }
}
