package org.inaetics.ails.api.server.location.provider;

import com.google.common.base.Optional;
import java.util.UUID;

import org.inaetics.ails.api.common.model.Location;
import org.inaetics.ails.api.common.model.User;

/**
 * A LocationProvider provides a way to find a {@link Location}.
 * 
 * @author L. Buit, N. Korthout, J. Naus
 * @version 0.1.0
 * @since 28-10-2015
 */
public interface LocationProvider {

    /**
     * Find the Location of a {@link User}.
     * 
     * @param uuid @NotNull Universally unique identifier identifying the User of which to find the
     *        Location.
     * @return An Optional containing the Location object if found, or an empty Optional if not.
     */
    Optional<Location> locate(UUID uuid);

}
