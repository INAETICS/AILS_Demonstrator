package org.inaetics.ails.api.server.user.service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.inaetics.ails.api.common.model.Location;
import org.inaetics.ails.api.common.model.User;
import org.inaetics.ails.api.common.model.AnonUser;

/**
 * This service provides functions to add and get {@link AnonUser Users}.
 * 
 * @author L. Buit, N. Korthout, J. Naus
 * @version 1.1.0
 * @since 20-10-2015
 */
public interface UserService {

    /**
     * Add a new User, so it can be retrieved later.
     * 
     * @param user @NotNull The new MacUser to add.
     * @since 2.0.0
     */
    AnonUser add(String name, byte[] mac);

    /**
     * Retrieve a List of all Users known by this service.
     * 
     * @return A List containing all the Users.
     */
    List<AnonUser> getAll();

    /**
     * Retrieve a specific User known by this service, identified by its UUID.
     * 
     * @param uuid @NotNull Universally unique identifier identifying the User to retrieve.
     * @return An Optional containing the User object if found, or an empty Optional if not.
     */
    Optional<AnonUser> find(UUID uuid);

    /**
     * Find the Location of a {@link AnonUser}.
     * 
     * @param uuid @NotNull Universally unique identifier identifying the User of which to find the
     *        Location.
     * @return An Optional containing the Location object if found, or an empty Optional if not.
     */
    Optional<Location> locate(UUID uuid);


}
