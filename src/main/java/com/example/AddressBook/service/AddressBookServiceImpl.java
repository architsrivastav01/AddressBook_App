package com.example.AddressBook.service;

import com.example.AddressBook.dto.AddressDTO;
import com.example.AddressBook.exception.AddressNotFoundException;
import com.example.AddressBook.model.Address;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class AddressBookServiceImpl implements AddressBookService {

    public AddressBookServiceImpl(List<Address> addressList) {
        this.addressList = addressList;
    }

    private List<Address> addressList = new ArrayList<>();

    @Override
    public List<AddressDTO> getAllAddresses() {
        return addressList.stream()
                .map(address -> new AddressDTO(
                        address.getId(),
                        address.getName(),
                        address.getStreet(),
                        address.getCity(),
                        address.getState(),
                        address.getZip()))
                .collect(Collectors.toList());
    }

    @Override
    public AddressDTO getAddressById(Long id) {
        return addressList.stream()
                .filter(address -> address.getId().equals(id))
                .findFirst()
                .map(address -> new AddressDTO(
                        address.getId(),
                        address.getName(),
                        address.getStreet(),
                        address.getCity(),
                        address.getState(),
                        address.getZip()))
                .orElseThrow(() -> new AddressNotFoundException(id));
    }

    @Override
    public AddressDTO createAddress(AddressDTO addressDTO) {
        Address address = new Address(
                addressDTO.getId(),
                addressDTO.getName(),
                addressDTO.getStreet(),
                addressDTO.getCity(),
                addressDTO.getState(),
                addressDTO.getZip());
        addressList.add(address);
        return addressDTO;
    }

    @Override
    public AddressDTO updateAddress(Long id, AddressDTO addressDTO) {
        return addressList.stream()
                .filter(a -> a.getId().equals(id))
                .findFirst()
                .map(existingAddress -> {
                    int index = addressList.indexOf(existingAddress);
                    Address updatedAddress = new Address(
                            addressDTO.getId(),
                            addressDTO.getName(),
                            addressDTO.getStreet(),
                            addressDTO.getCity(),
                            addressDTO.getState(),
                            addressDTO.getZip());
                    addressList.set(index, updatedAddress);
                    return addressDTO;
                })
                .orElseThrow(() -> new AddressNotFoundException(id));
    }

    @Override
    public void deleteAddress(Long id) {
        boolean removed = addressList.removeIf(address -> address.getId().equals(id));
        if (!removed) {
            throw new AddressNotFoundException(id);
        }
    }
}
