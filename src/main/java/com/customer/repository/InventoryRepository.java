package com.customer.repository;

import com.customer.beans.Inventory;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * This interface represents the repository for managing Inventory entities in the data store.
 * It provides methods to perform CRUD (Create, Read, Update, Delete) operations on Inventory objects.
 *
 * The InventoryRepository interface extends JpaRepository from Spring Data JPA,
 * which provides convenient methods for interacting with the data store.
 *
 * Usage:
 * The InventoryRepository is used to interact with the underlying data store (e.g., a database)
 * and perform operations related to Inventory entities.
 * It provides methods to find, save, update, and delete Inventory objects in the data store.
 */
public interface InventoryRepository extends JpaRepository<Inventory, Integer> {
    // Methods from JpaRepository are inherited automatically.
}
