package com.customer.service;

import com.customer.beans.Inventory;
import com.customer.repository.InventoryRepository;
import com.customer.controller.AddResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

/**
 * This class represents a service that handles Inventory-related operations in the application.
 * It provides functionality to Create, Read, Update, and Delete Inventory information in the database.
 * This service communicates with the InventoryRepository to perform CRUD operations on Customer_db entities.
 * Usage:
 * The InventoryService should be autowired into other components that require Inventory-related functionalities.
 */

@Service
public class InventoryService {

    @Autowired
    InventoryRepository inventoryRep;

    /**
     * Get inventory information.
     *
     * @return All the Inventory objects.
     */
    public List<Inventory> getInventories(){
        return inventoryRep.findAll();
    }


    /**
     * Get inventory information by the specified inventory ID.
     *
     * @param Id The ID of the inventory to retrieve.
     * @return The Inventory object corresponding to the given ID.
     */
    public Inventory getInventoryById(int Id){
        List<Inventory> inventories = inventoryRep.findAll();
        Inventory inventory = null;
        for(Inventory i: inventories){
            if(i.getId() == Id){
                inventory = i;
            }
        }
        return inventory;
    }

    /**
     * Create a new inventory with the provided inventory object.
     *
     * @param inventory The Inventory object representing the inventory to be created.
     * @return The newly created inventory object with a generated ID.
     */
    public Inventory createInventory(Inventory inventory){
        return inventoryRep.save(inventory);
    }

    /**
     * Update a new inventory with the provided inventory object.
     *
     * @param inventory The Inventory object representing the inventory to be updated.
     * @return The updated Inventory object.
     */
    public Inventory updateInventory(Inventory inventory){
        return inventoryRep.save(inventory);
    }


    /**
     * Delete an inventory with the provided Id.
     *
     * @param Id The ID of the inventory to delete.
     * @return The deleted Id.
     */
    public AddResponse deleteInventory(int Id){
        inventoryRep.deleteById(Id);
        AddResponse res = new AddResponse();
        res.setMsg("Inventory deleted");
        res.setId(Id);
        return res;
    }
}
