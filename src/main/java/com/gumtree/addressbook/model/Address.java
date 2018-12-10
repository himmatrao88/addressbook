package com.gumtree.addressbook.model;

import java.time.LocalDate;

/**
 * The Class Address.
 */
public class Address {
    
    /** The name. */
    private String name;
    
    /** The gender. */
    private Gender gender;
    
    /** The date of birth. */
    private LocalDate dateOfBirth;
    
    /**
     * Gets the name.
     *
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * Gets the gender.
     *
     * @return the gender
     */
    public Gender getGender() {
        return gender;
    }

    /**
     * Gets the date of birth.
     *
     * @return the date of birth
     */
    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    /**
     * The Class AddressBuilder.
     */
    public static class AddressBuilder {
        /** The name. */
        private String name;
        
        /** The gender. */
        private Gender gender;
        
        /** The date of birth. */
        private LocalDate dateOfBirth;
        
        /**
         * Name.
         *
         * @param name the name
         * @return the address builder
         */
        public AddressBuilder name(final String name) {
            this.name = name;
            return this;
        }
        
        /**
         * Gender.
         *
         * @param Gender the gender
         * @return the address builder
         */
        public AddressBuilder gender(final Gender gender) {
            this.gender = gender;
            return this;
        }
        
        /**
         * Date of birth.
         *
         * @param dateOfBirth the date of birth
         * @return the address builder
         */
        public AddressBuilder dateOfBirth(final LocalDate dateOfBirth) {
            this.dateOfBirth = dateOfBirth;
            return this;
        }
        
        /**
         * Builds the.
         *
         * @return the address
         */
        public Address build() {
            Address address = new Address();
            address.name = name;
            address.gender = gender;
            address.dateOfBirth = dateOfBirth;
            return address;
        }
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((dateOfBirth == null) ? 0 : dateOfBirth.hashCode());
        result = prime * result + ((gender == null) ? 0 : gender.hashCode());
        result = prime * result + ((name == null) ? 0 : name.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Address other = (Address) obj;
        if (dateOfBirth == null) {
            if (other.dateOfBirth != null)
                return false;
        } else if (!dateOfBirth.equals(other.dateOfBirth))
            return false;
        if (gender != other.gender)
            return false;
        if (name == null) {
            if (other.name != null)
                return false;
        } else if (!name.equals(other.name))
            return false;
        return true;
    }
    
    
}
