package com.customer.controller;

import com.customer.beans.Item;
import com.customer.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
/**
 * This class represents the RESTful controller for managing Item-related endpoints.
 * It handles HTTP requests for creating, reading, updating, and deleting Item information.
 * The ItemController maps incoming HTTP requests to appropriate methods to process them.
 * It interacts with the ItemService to perform operations on item data.
 * Endpoints:
 * - GET /items: Retrieves all the items' information.
 * - GET /getItemById/{itemId}: Retrieve item information by the specified ID.
 * - POST /createItem: Creates a new item using the provided customer data.
 * - PUT /updateItem: Update customer information.
 * - DELETE /deleteItemById/{itemId}: Delete the item with the given ID from the system.
 * Usage:
 * The ItemController should be registered with the Spring application context and
 * automatically handle incoming HTTP requests to the specified endpoints.
 */
@RestController
public class ItemController {

    @Autowired
    ItemService service;

    /**
     * Returns all the customer objects.
     * URL : "http://localhost8080/Items"
     * @return  All items as an arrayList of item JSON objects.
     */
    @GetMapping("/Items")
    public List<Item> getAllItems(){
        return service.getItems();
    }

    /**
     * Returns the Item object with given itemId.
     * URL : "http://localhost8080/getItemById/"
     * @param itemId as an input.
     * @return ResponseEntity with item information if found, or 404 if not found.
     * @throws if item object not found with given Id.
     */
    @GetMapping("/getItemById/{itemId}")
    public ResponseEntity<Item> getItemById(@PathVariable(value = "itemId") int itemId) {

        try {
            Item item = service.getItemById(itemId);
            return new ResponseEntity<Item>(item, HttpStatus.OK);
        }
        catch(Exception e){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    /**
     * Creates the item object.
     * URL : "http://localhost8080/createItem"
     * @param  item object as an input.
     * @return  item JSON object.
     */
    @PostMapping("/createItem")
    public Item createItem(@RequestBody Item item){

        return service.createItem(item);
    }

    /**
     * Updates the item object.
     * URL : "http://localhost8080/updateItem"
     * @param  item object as an input.
     * @return ResponseEntity with item information if updated, or 404 if not found.
     * @throws  if item object not found.
     */
    @PutMapping("/updateItem")
    public ResponseEntity<Item> updateItem(@RequestBody Item item){
        try{
            Item updatedItem = service.updateItem(item);
            return new ResponseEntity<Item>(updatedItem,HttpStatus.OK);
        }
        catch(Exception e){
            return new ResponseEntity<>(HttpStatus.CONFLICT);
        }

    }

    /**
     * Deletes the item object with specific id
     * URL : "http://localhost8080/deleteItemById/"
     * @param itemId as an input.
     * @return AddResponse with itemId which is deleted.
     */
    @DeleteMapping("/deleteItemById/{itemId}")
    public AddResponse deleteItem(@PathVariable(value = "itemId") int itemId){
        return service.deleteItem(itemId);
    }
}