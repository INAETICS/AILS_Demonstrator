package org.inaetics.ails.api.client.location_controller;

import java.util.List;
import java.util.Optional;

import org.inaetics.ails.api.common.model.Location;
import org.inaetics.ails.api.common.model.AnonUser;

/**
 * Location Services
 * 
 * @author L. Buit, N. Korthout, J. Naus
 * @version 0.1.0
 * @since 20-10-2015
 */
public interface LocationService {

    /**
     * Get the {@link AnonUser} list from the server.
     * 
     * @return List of users.
     */
    public List<AnonUser> getUsers();

    /**
     * Display a list of users.
     * 
     * @param users List of users
     */
    public void displayUserlist(List<AnonUser> users);

    /**
     * Get the location of a given {@link AnonUser}.
     * 
     * @param user @NotNull The given {@link AnonUser}.
     * 
     * @return An optional containing the {@link Location} of the given user if the operation
     *         succeeded, otherwise returns an empty optional.
     */
    public Optional<Location> queryUserLocation(AnonUser user);

    /**
     * Display a {@link Location}.
     * 
     * @param location {@link Location} to be displayed.
     */
    public void displayLocation(Location location);
}
