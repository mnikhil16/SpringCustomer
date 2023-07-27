package com.customer.repository;

import com.customer.beans.Store;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * This interface represents the repository for managing Store entities in the data store.
 * It provides methods to perform CRUD (Create, Read, Update, Delete) operations on Store objects.
 *
 * The StoreRepository interface extends JpaRepository from Spring Data JPA,
 * which provides convenient methods for interacting with the data store.
 *
 * Usage:
 * The StoreRepository is used to interact with the underlying data store (e.g., a database)
 * and perform operations related to Store entities.
 * It provides methods to find, save, update, and delete Store objects in the data store.
 */
@Repository
public interface StoreRepository extends JpaRepository<Store, Integer> {
    // Methods from JpaRepository are inherited automatically.
}
