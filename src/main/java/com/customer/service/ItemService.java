package com.customer.service;

import com.customer.beans.Customer;
import com.customer.beans.Item;
import com.customer.controller.AddResponse;
import com.customer.repository.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

/**
 * This class represents a service that handles Item-related operations in the application.
 * It provides functionality to Create, Read, Update, and Delete Item information in the database.
 * This service communicates with the ItemRepository to perform CRUD operations on Customer_db entities.
 *
 * Usage:
 * The ItemService should be autowired into other components that require Item-related functionalities.
 */

@Service
public class ItemService {

    @Autowired
    ItemRepository itemRep;

    /**
     * Get item information by the specified item ID.
     *
     * @return All the Customer objects.
     */
    public List<Item> getItems(){
        return itemRep.findAll();
    }


    /**
     * Get item information by the specified item ID.
     *
     * @param Id The ID of the item to retrieve.
     * @return The Item object corresponding to the given ID.
     */
    public Item getItemById(int Id){
        List<Item> items = itemRep.findAll();
        Item item = null;
        for(Item i: items){
            if(i.getId() == Id){
                item = i;
            }
        }
        return item;
    }

    /**
     * Create a new item with the provided item object.
     *
     * @param item The Item object representing the item to be created.
     * @return The newly created item object with a generated ID.
     */
    public Item createItem(Item item){
        return itemRep.save(item);
    }

    /**
     * Update a new item with the provided item object.
     *
     * @param item The Item object representing the item to be updated.
     * @return The updated Item object.
     */
    public Item updateItem(Item item){
        return itemRep.save(item);
    }


    /**
     * Delete an item with the provided Id.
     *
     * @param Id The ID of the item to delete.
     * @return The deleted Id.
     */
    public AddResponse deleteItem(int Id){
        itemRep.deleteById(Id);
        AddResponse res = new AddResponse();
        res.setMsg("Item deleted");
        res.setId(Id);
        return res;
    }
}