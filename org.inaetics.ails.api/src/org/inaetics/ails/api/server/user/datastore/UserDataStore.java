package org.inaetics.ails.api.server.user.datastore;

import java.util.List;
import com.google.common.base.Optional;
import java.util.UUID;

import org.inaetics.ails.api.common.model.User;

/**
 * The UserDataStore can be used to store {@link User Users}.
 * 
 * @author L. Buit, N. Korthout, J. Naus
 * @version 2.0.0
 * @since 29-10-2015
 */
public interface UserDataStore {
 
    /**
     * Store a new User.
     * 
     * @param user @NotNull The User to store.
     * @return UUID belonging to new user.
     * @since 2.0.0
     */
    UUID storeUser(User user);

    /**
     * Retrieve a specific User known by this data store, identified by its UUID.
     * 
     * @param uuid @NotNull Universally unique identifier identifying the User to retrieve.
     * @return An Optional containing the User object if found, or an empty Optional if not.
     * @since 0.1.0
     */
    Optional<User> getUser(UUID uuid);
    
    /**
     * Retrieve a list of all User's known in the system.
     * 
     * @return List of all users known to the system.
     * @since 1.0.0
     */    
    List<User> getAllUsers();
 
}
