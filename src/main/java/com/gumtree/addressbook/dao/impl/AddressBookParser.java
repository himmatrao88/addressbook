package com.gumtree.addressbook.dao.impl;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import com.gumtree.addressbook.exception.InvalidAddressException;
import com.gumtree.addressbook.model.Address;
import com.gumtree.addressbook.model.Gender;
import com.gumtree.addressbook.model.Address.AddressBuilder;

/**
 * The Class AddressBookParser.
 */
@Component
public class AddressBookParser {
    
    /** The Constant DATE_COULD_NOT_BE_PARSED_EXP_MSG. */
    private static final String DATE_COULD_NOT_BE_PARSED_EXP_MSG = "Date Could not be parsed.";
    
    /** The Constant GENDER_COULD_NOT_BE_PARSED_EXP_MSG. */
    private static final String GENDER_COULD_NOT_BE_PARSED_EXP_MSG = "Gender Could not be parsed.";
    
    /** The Constant FORMAT_OF_LINE_INCORRECT_EXP_MSG. */
    private static final String FORMAT_OF_LINE_INCORRECT_EXP_MSG = "Format for Address line incorrect.";
    
    /** The Constant COMMA. */
    public static final String COMMA = ",";
    
    /** The Constant DATE_FORMATTER. */
    private static final DateTimeFormatter DATE_FORMATTER = DateTimeFormatter.ofPattern("dd/MM/yy");
    
    /**
     * Process input file.
     *
     * @param inputFilePath the input file path
     * @return the list
     * @throws FileNotFoundException the file not found exception
     */
    List<Address> processInputFile(final String inputFilePath) throws FileNotFoundException {
        List<Address> inputList = new ArrayList<Address>();
        BufferedReader br = null;
        try{
          br = new BufferedReader(new FileReader(inputFilePath));
          inputList = br.lines().map(mapToAddress).filter(add -> add != null).collect(Collectors.toList());
        }catch (FileNotFoundException e) {
            System.err.println("File not found at given location: "+inputFilePath);
            throw e;
        }finally {
            if(br != null) {
                try {
                    br.close();
                } catch (IOException e) {
                    System.out.println("Unable to close the buffer Reader");
                }
            }
        }
        return inputList ;
    }
    
    /** The map to address. */
    private static Function<String, Address> mapToAddress = (line) -> {
        String[] p = line.split(COMMA);
        AddressBuilder builder = new AddressBuilder();
        try {
            if(p.length != 3) {
                throw new InvalidAddressException(FORMAT_OF_LINE_INCORRECT_EXP_MSG);
            }
            builder.name(p[0].trim())
                    .gender(parseGender(p[1].trim()))
                    .dateOfBirth(parseDate(p[2].trim()));
            return builder.build();
        } catch (InvalidAddressException ae) {
            System.err.println("Unable to parse line: "+line+" Reason: "+ae.getMessage());
            System.err.println("Skipping the above line");
        }
        return null;
      };
      
      /**
       * Parses the gender.
       *
       * @param gender the gender
       * @return the gender
       * @throws InvalidAddressException the invalid address exception
       */
      private static Gender parseGender(final String gender) throws InvalidAddressException {
          try {
              return Gender.fromString(gender);
          } catch (IllegalArgumentException | NullPointerException e) {
              throw new InvalidAddressException(GENDER_COULD_NOT_BE_PARSED_EXP_MSG);
          }
      }
      
      /**
       * Parses the date.
       *
       * @param date the date
       * @return the local date
       * @throws InvalidAddressException the invalid address exception
       */
      private static LocalDate parseDate(final String date) throws InvalidAddressException {
          try {
              return LocalDate.parse(date, DATE_FORMATTER);
          } catch (Exception e) {
              throw new InvalidAddressException(DATE_COULD_NOT_BE_PARSED_EXP_MSG);
          }
      }
}
