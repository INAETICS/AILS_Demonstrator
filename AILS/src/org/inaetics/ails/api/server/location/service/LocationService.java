package org.inaetics.ails.api.server.location.service;

import java.util.Optional;
import java.util.UUID;

import org.inaetics.ails.api.common.model.Location;
import org.inaetics.ails.api.common.model.AnonUser;

/**
 * This service provides functions to find {@link Location Locations} of {@link AnonUser Users}.
 * 
 * @author L. Buit, N. Korthout, J. Naus
 * @version 1.0.0
 * @since 22-10-2015
 */
public interface LocationService {

    /**
     * Find the Location of a {@link AnonUser}.
     * 
     * @param uuid @NotNull Universally unique identifier identifying the User of which to find the
     *        Location.
     * @return An Optional containing the Location object if found, or an empty Optional if not.
     */
    Optional<Location> locate(UUID uuid);

}
