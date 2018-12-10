package com.gumtree.addressbook.exception;

/**
 * The Class InvalidAddressException.
 */
public class InvalidAddressException extends RuntimeException {

    /** The Constant serialVersionUID. */
    private static final long serialVersionUID = 1L;

    /**
     * Instantiates a new invalid address exception.
     *
     * @param message the message
     */
    public InvalidAddressException(final String message) {
        super(message);
    }
}
