package com.customer.beans;

import jakarta.persistence.*;

/**
 * This class represents an Item object with details like id, name, type, brand, price, items left, manufactured date, expiry date and description about product.
 * It is a Java bean class with getters, setters, and a parameterized constructor for easy data access.
 *
 * Usage:
 * The Item class can be used to store and retrieve information about an item.
 */
@Entity
@Table(name = "item")
public class Item {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    Integer id;

    @Column(name = "name")
    String name;

    @Column(name = "type")
    String type;

    @Column(name = "brand")
    String brand;

    @Column(name = "price")
    Double price;

    @Column(name = "items_left")
    Integer itemsLeft;

    @Column(name = "mfd")
    String manufacturedDate;

    @Column(name = "exd")
    String expiryDate;

    @Column(name = "description")
    String description;

    /**
     * Parameterized constructor to create a Customer object with specified details.
     *
     * @param id               The id of an item.
     * @param name             The name of an item.
     * @param type             The type of item.
     * @param brand            The brand of an item.
     * @param price            The price of an item.
     * @param itemsLeft        The quantity of items left.
     * @param manufacturedDate The manufactured date of an item.
     * @param expiryDate       The expiryDate of an item.
     * @param description      The description of an item.
     */
    public Item(Integer id, String name, String type, String brand, Double price, Integer itemsLeft, String manufacturedDate, String expiryDate, String description) {
        this.id = id;
        this.name = name;
        this.type = type;
        this.brand = brand;
        this.price = price;
        this.itemsLeft = itemsLeft;
        this.manufacturedDate = manufacturedDate;
        this.expiryDate = expiryDate;
        this.description = description;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Integer getItemsLeft() {
        return itemsLeft;
    }

    public void setItemsLeft(Integer itemsLeft) {
        this.itemsLeft = itemsLeft;
    }

    public String getManufacturedDate() {
        return manufacturedDate;
    }

    public void setManufacturedDate(String manufacturedDate) {
        this.manufacturedDate = manufacturedDate;
    }

    public String getExpiryDate() {
        return expiryDate;
    }

    public void setExpiryDate(String expiryDate) {
        this.expiryDate = expiryDate;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
