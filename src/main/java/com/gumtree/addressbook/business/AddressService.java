package com.gumtree.addressbook.business;

/**
 * The Interface AddressService.
 */
public interface AddressService {
    
    /**
     * Gets the oldest person name.
     *
     * @return the oldest person name
     */
    String getOldestPersonName();
    
    /**
     * Gets the count of males.
     *
     * @return the count of males
     */
    long getCountOfMales();
    
    /**
     * Gets the difference in days.
     *
     * @param name1 the name 1
     * @param name2 the name 2
     * @return the difference in days
     */
    long getDifferenceInDays(String name1, String name2);
}
