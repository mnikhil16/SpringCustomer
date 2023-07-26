package com.customer.beans;

import jakarta.persistence.*;

/**
 * This class represents an Address object with details such as id, D_no, street, city, state and pin code.
 * It is a Java bean class with getters, setters, and a parameterized constructor for easy data access.
 *
 * Usage:
 * The Address class can be used to store and retrieve address information of a customer or any entity.
 * It is commonly used as a property of the Customer class to represent a customer's address.
 */
@Entity
@Table(name = "address")
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    int id;
    @Column(name = "dno")
    String D_No;
    @Column(name = "street")
    String street;
    @Column(name = "city")
    String city;
    @Column(name = "state")
    String state;
    @Column(name = "pin_code")
    int pinCode;

    public Address() {
    }

    /**
     * Parameterized constructor to create an Address object with specified details.
     *
     * @param d_No       The door number.
     * @param street     The street address.
     * @param city       The city name.
     * @param state      The state name.
     * @param pinCode    The pin code or ZIP code.
     */
    public Address(int id, String d_No, String street, String city, String state, int pinCode) {
        this.id = id;
        D_No = d_No;
        this.street = street;
        this.city = city;
        this.state = state;
        this.pinCode = pinCode;
    }

    /**
     * Get the id.
     *
     * @return The id as an int.
     */
    public int getId() {
        return id;
    }

    /**
     * Set the id.
     *
     * @param id The id to set.
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Get the door number.
     *
     * @return The door number as a String.
     */
    public String getD_No() {
        return D_No;
    }

    /**
     * Set the door number.
     *
     * @param d_No The door number to set.
     */
    public void setD_No(String d_No) {
        D_No = d_No;
    }

    /**
     * Get the street address.
     *
     * @return The street address as a String.
     */
    public String getStreet() {
        return street;
    }

    /**
     * Set the street address.
     *
     * @param street The street address to set.
     */
    public void setStreet(String street) {
        this.street = street;
    }

    /**
     * Get the city name.
     *
     * @return The city name as a String.
     */
    public String getCity() {
        return city;
    }

    /**
     * Set the city name.
     *
     * @param city The city name to set.
     */
    public void setCity(String city) {
        this.city = city;
    }

    /**
     * Get the state name.
     *
     * @return The state name as a String.
     */
    public String getState() {
        return state;
    }

    /**
     * Set the state name.
     *
     * @param state The state name to set.
     */
    public void setState(String state) {
        this.state = state;
    }

    /**
     * Get the pin code.
     *
     * @return The pin code as an int.
     */
    public int getPinCode() {
        return pinCode;
    }

    /**
     * Set the pin code.
     *
     * @param pinCode The pin code to set.
     */
    public void setPinCode(int pinCode) {
        this.pinCode = pinCode;
    }
}

