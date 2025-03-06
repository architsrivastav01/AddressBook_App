package com.example.AddressBook.service;

import com.example.AddressBook.dto.AddressDTO;

import java.util.List;

public interface AddressBookService {

    /**
     * Retrieves all addresses.
     *
     * @return a list of all addresses
     */
    List<AddressDTO> getAllAddresses();

    /**
     * Retrieves an address by its ID.
     *
     * @param id the ID of the address to retrieve
     * @return the address with the specified ID
     */
    AddressDTO getAddressById(Long id);

    /**
     * Creates a new address.
     *
     * @param addressDTO the address data to create
     * @return the created address data
     */
    AddressDTO createAddress(AddressDTO addressDTO);

    /**
     * Updates an existing address by its ID.
     *
     * @param id          the ID of the address to update
     * @param addressDTO the new address data
     * @return the updated address data
     */
    AddressDTO updateAddress(Long id, AddressDTO addressDTO);

    /**
     * Deletes an address by its ID.
     *
     * @param id the ID of the address to delete
     */
    void deleteAddress(Long id);
}
