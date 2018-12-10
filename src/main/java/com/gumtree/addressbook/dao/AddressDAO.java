package com.gumtree.addressbook.dao;

import com.gumtree.addressbook.model.Address;
import com.gumtree.addressbook.model.Gender;

/**
 * The Interface AddressDAO.
 */
public interface AddressDAO {
    
    /**
     * Gets the oldest person.
     * Return Null if AddressRepository is Empty.
     *
     * @return the oldest person
     */
    public Address getOldestPerson(); 
    
    /**
     * Gets the count based on gender.
     *
     * @param gender the gender
     * @return the count based on gender
     */
    public long getCountBasedOnGender(final Gender gender);
    
    /**
     * Gets the address by name.
     * Assumes that Name is unique in Address Repository.
     * Returns the first matched Address by name.
     *
     * @param name the name
     * @return the address by name
     */
    public Address getAddressByName(final String name);
}
