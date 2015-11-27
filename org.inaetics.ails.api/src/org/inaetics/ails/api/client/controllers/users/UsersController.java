package org.inaetics.ails.api.client.controllers.users;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.inaetics.ails.api.common.model.User;
import org.inaetics.ails.api.common.model.Location;

/**
 * The Users Controller Service provides a way to get a list of user and to retrieve the location of
 * a specific user given his/her UUID.
 * 
 * @author L. Buit, N. Korthout, J. Naus
 * @version 0.1.0
 * @since 24-11-2015
 */
public interface UsersController {

    /**
     * Retrieve a List of all Users known by this service.
     * 
     * @return A List containing all the Users.
     */
    List<User> getAll();

    /**
     * Get a location for an user given his/her UUID if known.
     * 
     * @param uuid The user's UUID.
     * 
     * @return An optional containing the last known location for the given user, else an empty
     *         optional.
     */
    Optional<Location> getLocationForUser(UUID uuid);
}
