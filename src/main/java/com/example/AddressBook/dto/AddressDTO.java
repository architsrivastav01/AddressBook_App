package com.example.AddressBook.dto;

import jakarta.persistence.Table;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;


public class AddressDTO {

    @NotNull(message = "ID must not be null")
    private Long id;

    @NotEmpty(message = "Name must not be empty")
    @Size(min = 2, max = 100, message = "Name must be between 2 and 100 characters")
    private String name;

    @NotEmpty(message = "Street must not be empty")
    private String street;

    @NotEmpty(message = "City must not be empty")
    private String city;

    @NotEmpty(message = "State must not be empty")
    private String state;

    @NotEmpty(message = "Zip must not be empty")
    private String zip;

    public AddressDTO(Long id, String name, String street, String city, String state, String zip) {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getZip() {
        return zip;
    }

    public void setZip(String zip) {
        this.zip = zip;
    }
// Getters and Setters
}
