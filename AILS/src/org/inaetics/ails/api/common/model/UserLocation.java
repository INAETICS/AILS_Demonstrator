package org.inaetics.ails.api.common.model;

import com.google.common.base.Preconditions;

/**
 * A UserLocation can used to store a {@link Location Locations} that specifically belong to a
 * {@link User}. For example, when we know for certain the Location of a User we can store that in
 * this class.
 * 
 * @author L. Buit, N. Korthout, J. Naus
 * @version 0.1.0
 * @since 28-10-2015
 */
public class UserLocation {

    private final User user;
    private final Location location;

    /**
     * Constructor for UserLocation.
     * 
     * @param user @NotNull The user the location belongs to.
     * @param location @NotNull The location belonging to the user.
     */
    public UserLocation(User user, Location location) {
        super();
        this.user = Preconditions.checkNotNull(user, "user is not set");
        this.location = Preconditions.checkNotNull(location, "location is not set");
    }

    /**
     * Retrieve the user.
     * 
     * @return the user
     */
    public User getUser() {
        return user;
    }

    /**
     * Retrieve the location.
     * 
     * @return the location
     */
    public Location getLocation() {
        return location;
    }

}
