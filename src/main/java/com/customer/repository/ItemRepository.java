package com.customer.repository;

import com.customer.beans.Item;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * This interface represents the repository for managing Item entities in the data store.
 * It provides methods to perform CRUD (Create, Read, Update, Delete) operations on Item objects.
 *
 * The ItemRepository interface extends JpaRepository from Spring Data JPA,
 * which provides convenient methods for interacting with the data store.
 *
 * Usage:
 * The ItemRepository is used to interact with the underlying data store (e.g., a database)
 * and perform operations related to Item entities.
 * It provides methods to find, save, update, and delete Item objects in the data store.
 */
@Repository
public interface ItemRepository extends JpaRepository<Item, Integer> {
    // Methods from JpaRepository are inherited automatically.
}
