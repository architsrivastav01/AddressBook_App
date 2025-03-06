package com.example.AddressBook.exception;

public class AddressNotFoundException extends AddressBookException {
    public AddressNotFoundException(Long id) {
        super("Address with ID " + id + " not found.");
    }
}
