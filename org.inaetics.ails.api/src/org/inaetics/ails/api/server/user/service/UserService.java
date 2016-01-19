package org.inaetics.ails.api.server.user.service;

import java.util.List;
import com.google.common.base.Optional;
import java.util.UUID;

import org.inaetics.ails.api.common.model.Accuracy;
import org.inaetics.ails.api.common.model.Location;
import org.inaetics.ails.api.common.model.User;

/**
 * This service provides functions to add and get {@link User Users}.
 * 
 * @author L. Buit, N. Korthout, J. Naus
 * @version 2.0.0
 * @since 20-10-2015
 */
public interface UserService {

    /**
     * Add a User to the system.
     * 
     * @param name @NotNull The name of the new user.
     * @param accuracy @NotNull The accuracy with which the user likes to be located.
     * @return A UUID belonging to the new User.
     * @since 2.0.0
     */
    UUID add(String name, Accuracy accuracy);

    /**
     * Retrieve a List of all Users known by this service.
     * 
     * @return A List containing all the Users.
     */
    List<User> getAll();

    /**
     * Retrieve a specific User known by this service, identified by its UUID.
     * 
     * @param uuid @NotNull Universally unique identifier identifying the User to retrieve.
     * @return An Optional containing the User object if found, or an empty Optional if not.
     */
    Optional<User> find(UUID uuid);

    /**
     * Find the Location of a {@link User}.
     * 
     * @param uuid @NotNull Universally unique identifier identifying the User of which to find the
     *        Location.
     * @return An Optional containing the Location object if found, or an empty Optional if not.
     */
    Optional<Location> locate(UUID uuid);


}
