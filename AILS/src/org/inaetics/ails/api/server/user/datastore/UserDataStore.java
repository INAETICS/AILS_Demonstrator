package org.inaetics.ails.api.server.user.datastore;

import java.util.Optional;
import java.util.UUID;

import org.inaetics.ails.api.common.model.User;

/**
 * The UserDataStore can be used to store {@link User Users}.
 * 
 * @author L. Buit, N. Korthout, J. Naus
 * @version 0.1.0
 * @since 29-10-2015
 */
public interface UserDataStore {
 
    /**
     * Store a new User.
     * 
     * @param user @NotNull The User to store.
     */
    void storeUser(User user);

    /**
     * Retrieve a specific User known by this data store, identified by its UUID.
     * 
     * @param uuid @NotNull Universally unique identifier identifying the User to retrieve.
     * @return An Optional containing the User object if found, or an empty Optional if not.
     */
    Optional<User> getUser(UUID uuid);
 
}
