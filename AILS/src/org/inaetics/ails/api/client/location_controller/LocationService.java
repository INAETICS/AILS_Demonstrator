package org.inaetics.ails.api.client.location_controller;

import java.util.List;
import java.util.Optional;

import org.inaetics.ails.api.model.Location;
import org.inaetics.ails.api.model.User;

/**
 * Location Services
 * 
 * @author Jessy Naus
 * @version 0.1.0
 * @since 20-10-2015
 */
public interface LocationService {
    
    /**
     * Get the user list from the server.
     * 
     * @return List of users.
     */
    public List<User> getUsers();

    /**
     * Display a list of users.
     * 
     * @param users List of users
     */
    public void displayUserlist(List<User> users);

    /**
     * Get the location of a given user.
     * 
     * @param user @NotNull The given user.
     * 
     * @return An optional containing the location of the given user if the operation
     * succeeded, otherwise returns an empty optional.
     */
    public Optional<Location> queryUserLocation(User user);

    /**
     * Display a location.
     * 
     * @param location Location to be displayed.
     */
    public void displayLocation(Location location);
}
