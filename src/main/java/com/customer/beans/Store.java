package com.customer.beans;

import jakarta.persistence.*;

/**
 * This class represents a Store object with details like id, branch, item id, customer id, address id.
 * It is a Java bean class with getters, setters, and a parameterized constructor for easy data access.
 *
 * Usage:
 * The Customer class can be used to store and retrieve information about a customer in the system.
 */
@Entity
@Table(name = "store")
public class Store {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    int id;

    @Column(name = "branch")
    String branch;

    @ManyToMany(cascade = CascadeType.ALL)
    @Column(name = "item_id")
    int itemId;

    @OneToMany(cascade = CascadeType.ALL)
    @Column(name = "customer_id")
    int customerId;

    @OneToOne(cascade = CascadeType.ALL)
    @Column(name = "address_id")
    int addressId;

    /**
     * Parameterized constructor to create a Customer object with specified details.
     *
     * @param id            The id of the store.
     * @param branch        The branch of the store.
     * @param itemId        The id of the item in the store
     * @param customerId    The id of the customer who purchases items in the store.
     * @param addressId     The address of the store.
     */
    public Store(int id, String branch, int itemId, int customerId, int addressId) {
        this.id = id;
        this.branch = branch;
        this.itemId = itemId;
        this.customerId = customerId;
        this.addressId = addressId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getBranch() {
        return branch;
    }

    public void setBranch(String branch) {
        this.branch = branch;
    }

    public int getItemId() {
        return itemId;
    }

    public void setItemId(int itemId) {
        this.itemId = itemId;
    }

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public int getAddressId() {
        return addressId;
    }

    public void setAddressId(int addressId) {
        this.addressId = addressId;
    }
}
