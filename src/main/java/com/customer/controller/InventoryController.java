package com.customer.controller;

import com.customer.beans.Inventory;
import com.customer.service.InventoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
/**
 * This class represents the RESTful controller for managing Inventory-related endpoints.
 * It handles HTTP requests for creating, reading, updating, and deleting Inventory information.
 * The InventoryController maps incoming HTTP requests to appropriate methods to process them.
 * It interacts with the InventoryService to perform operations on inventory data.
 * Endpoints:
 * - GET /inventories: Retrieves all the inventories' information.
 * - GET /getInventoryById/{inventoryId}: Retrieve inventory information by the specified ID.
 * - POST /createInventory: Creates a new inventory using the provided inventory data.
 * - PUT /updateInventory: Update inventory information.
 * - DELETE /deleteInventoryById/{inventoryId}: Delete the inventory with the given ID from the system.
 * Usage:
 * The InventoryController should be registered with the Spring application context and
 * automatically handle incoming HTTP requests to the specified endpoints.
 */
@RestController
public class InventoryController {

    @Autowired
    InventoryService service;

    /**
     * Returns all the inventory objects.
     * URL : "http://localhost8080/inventories"
     * @return  All inventories as an arrayList of inventory JSON objects.
     */
    @GetMapping("/Inventories")
    public List<Inventory> getAllInventories(){
        return service.getInventories();
    }

    /**
     * Returns the customer object with given inventoryId.
     * URL : "http://localhost8080/getInventoryById/"
     * @param inventoryId as an input.
     * @return ResponseEntity with inventory information if found, or 404 if not found.
     * @throws if inventory object not found with given inventoryId.
     */
    @GetMapping("/getInventoryById/{inventoryId}")
    public ResponseEntity<Inventory> getInventoryById(@PathVariable(value = "inventoryId") int inventoryId) {

        try {
            Inventory inventory = service.getInventoryById(inventoryId);
            return new ResponseEntity<Inventory>(inventory, HttpStatus.OK);
        }
        catch(Exception e){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    /**
     * Creates the inventory object.
     * URL : "http://localhost8080/createInventory"
     * @param  inventory object as an input.
     * @return  inventory JSON object.
     */
    @PostMapping("/createInventory")
    public Inventory createInventory(@RequestBody Inventory inventory){

        return service.createInventory(inventory);
    }

    /**
     * Updates the inventory object.
     * URL : "http://localhost8080/updateInventory"
     * @param  inventory object as an input.
     * @return ResponseEntity with inventory information if updated, or 404 if not found.
     * @throws  if customer object not found.
     */
    @PutMapping("/updateInventory")
    public ResponseEntity<Inventory> updateInventory(@RequestBody Inventory inventory){
        try{
            Inventory updatedInventory = service.updateInventory(inventory);
            return new ResponseEntity<Inventory>(updatedInventory,HttpStatus.OK);
        }
        catch(Exception e){
            return new ResponseEntity<>(HttpStatus.CONFLICT);
        }

    }

    /**
     * Deletes the inventory object with specific id
     * URL : "http://localhost8080/deleteInventoryById/"
     * @param inventoryId as an input.
     * @return AddResponse with inventoryId which is deleted.
     */
    @DeleteMapping("/deleteInventoryById/{inventoryId}")
    public AddResponse deleteInventory(@PathVariable(value = "inventoryId") int inventoryId){
        return service.deleteInventory(inventoryId);
    }
}