package org.inaetics.ails.api.server.location;

import java.util.Optional;
import java.util.UUID;

import org.inaetics.ails.api.model.Location;
import org.inaetics.ails.api.model.User;

/**
 * This service provides functions to find {@link Location Locations} of {@link User Users}.
 * 
 * @author nicokorthout
 * @version 0.1.0
 * @since 22-10-2015
 */
public interface LocationService {

    /**
     * Find the Location of a {@link User}.
     * 
     * @param uuid @NotNull Universally unique identifier identifying the User to get the Location from. 
     * @return An Optional containing the Location object if found, or an empty Optional if not.
     */
    Optional<Location> findByUserUUID(UUID uuid);
    
}
