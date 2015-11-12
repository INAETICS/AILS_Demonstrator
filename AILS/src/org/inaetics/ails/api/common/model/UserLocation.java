package org.inaetics.ails.api.common.model;

import java.util.UUID;

import com.google.common.base.Preconditions;

/**
 * UserLocation can be used to store a {@link Location} that specifically belong to a {@link AnonUser}.
 * For example, when we know the Location of a User for certain, we can store that in this class.
 * 
 * @author L. Buit, N. Korthout, J. Naus
 * @version 0.2.0
 * @since 28-10-2015
 */
public class UserLocation implements Key<UUID> {

    private final AnonUser user;
    private final Location location;

    /**
     * Constructor for UserLocation.
     * 
     * @param user @NotNull The user the location belongs to.
     * @param location @NotNull The location belonging to the user.
     * @since 0.1.0
     */
    public UserLocation(AnonUser user, Location location) {
        super();
        this.user = Preconditions.checkNotNull(user, "user is not set");
        this.location = Preconditions.checkNotNull(location, "location is not set");
    }

    /**
     * Retrieve the user.
     * 
     * @return the user
     * @since 0.1.0
     */
    public AnonUser getUser() {
        return user;
    }

    /**
     * Retrieve the location.
     * 
     * @return the location
     * @since 0.1.0
     */
    public Location getLocation() {
        return location;
    }

    /**
     * @since 0.2.0
     */
    @Override
    public UUID getKey() {
        return user.getUuid();
    }

}
