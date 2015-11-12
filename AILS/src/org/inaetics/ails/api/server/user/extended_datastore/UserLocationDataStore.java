package org.inaetics.ails.api.server.user.extended_datastore;

import java.util.Optional;
import java.util.UUID;

import org.inaetics.ails.api.common.model.Location;
import org.inaetics.ails.api.common.model.UserLocation;

/**
 * The UserLocationDataStore can be used to store {@link UserLocation UserLocations}. This enhances
 * Users with Location information. This information can then be used to retrieve the Location of a
 * {@link AnonUser}.
 * 
 * @author L. Buit, N. Korthout, J. Naus
 * @version 0.1.0
 * @since 29-10-2015
 */
public interface UserLocationDataStore {

    /**
     * Store a UserLocation in the data store.
     * 
     * @param userLocation @NotNull The UserLocation to store.
     */
    void storeUserLocation(UserLocation userLocation);

    /**
     * Retrieve a specific User's Location known by this data store.
     * 
     * @param uuid The Univerally unique identifier identifying the {@link AnonUser} of which to
     *        retrieve the location.
     * @return An Optional containing the Location if found, or an empty Optional if not.
     */
    Optional<Location> getLocation(UUID uuid);

}
