package org.inaetics.ails.api.server.database;

import java.util.List;
import java.util.Optional;

/**
 * Database Access Objects (DAOs) provide methods to access a specific database table. It acts as a
 * mapping between model objects and their respective database tables.
 * 
 * @author L. Buit, N. Korthout, J. Naus
 * @version 1.0.0
 * @since 28-10-2015
 * @param <K> The type of uniquely identifying key this implementation uses.
 * @param <T> The type of object this implementation maps to database methods.
 */
public interface DAO<K, T> {

    /**
     * Store the object t in the database.
     * 
     * @param t @NotNull The object to store.
     */
    K store(T object);

    /**
     * Delete the object t from the database.
     * 
     * @param t @NotNull The object to delete.
     */
    void delete(K key);

    /**
     * Update the object t in the database.
     * 
     * @param t @NotNull The object to update.
     */
    void update(T object);

    /**
     * Find an object in the database, using its uniquely identifying key.
     * 
     * @param key @NotNull The uniquely identifying key of the object to find.
     * @return An Optional containing the object if found, or an empty Optional if not.
     */
    Optional<T> find(K key);

    /**
     * Get a List of all objects of type <T> stored in the database.
     * 
     * @return List of found objects.
     */
    List<T> getAll();

}
