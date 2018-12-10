package com.gumtree.addressbook.exception;

public class InvalidAddressException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    public InvalidAddressException(final String message) {
        super(message);
    }
}
