package com.gumtree.addressbook.model;

/**
 * The Enum Gender.
 */
public enum Gender {
    
    /** The male. */
    MALE("Male"),
    
    /** The female. */
    FEMALE("Female"),
    
    /** The unknown. */
    UNKNOWN("Unknown");
    
    /** The value. */
    public final String value;
    
    /**
     * Instantiates a new gender.
     *
     * @param value the value
     */
    Gender(final String value) {
        this.value = value;
    }
    
    /**
     * Gets the value.
     *
     * @return the value
     */
    public String getValue() {
        return this.value;
    }

    /**
     * From string.
     *
     * @param value the value
     * @return the gender
     */
    public static Gender fromString(final String value) {
        if (value != null) {
            for (Gender gender : Gender.values()) {
                if (value.equalsIgnoreCase(gender.value)) {
                    return gender;
                }
            }
            throw new IllegalArgumentException("No enumeration constant with value " + value + " found!");
        } else {
            throw new NullPointerException("Null value supplied.");
        }
    }

}
