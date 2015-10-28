package org.inaetics.ails.api.server.user;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.inaetics.ails.api.common.model.Location;
import org.inaetics.ails.api.common.model.User;

/**
 * This service provides functions to add and get {@link User Users}.
 * 
 * @author L. Buit, N. Korthout, J. Naus
 * @version 0.1.0
 * @since 20-10-2015
 */
public interface UserService {

    /**
     * Add a new User, so it can be retrieved later.
     * 
     * @param user @NotNull The new User to add.
     */
    void add(User user);

    /**
     * Retrieve a List of all Users known by this service.
     * 
     * @return A List containing all the Users.
     */
    List<User> getAll();

    /**
     * Retrieve a specific User known by this service, by its unique key.
     * 
     * @param id @NotNull The uniquely identifying key of the User to retrieve.
     * @return An Optional containing the User object if found, or an empty Optional if not.
     */
    Optional<User> findById(Object id);
    
    /**
     * Given a UUID of a user, retrieve its location
     * 
     * @param id @NotNull Uniqely identifying ID that 
     */
    Optional<Location> locateUser(UUID id);


}
