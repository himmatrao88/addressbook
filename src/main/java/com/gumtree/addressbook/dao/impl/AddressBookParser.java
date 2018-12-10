package com.gumtree.addressbook.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.gumtree.addressbook.model.Address;

/**
 * The Class AddressBookParser.
 */
@Component
public class AddressBookParser {
    
    /**
     * Process input file.
     *
     * @param inputFilePath the input file path
     * @return the list
     */
    List<Address> processInputFile(final String inputFilePath) {
        return new ArrayList<>();
    }
}
