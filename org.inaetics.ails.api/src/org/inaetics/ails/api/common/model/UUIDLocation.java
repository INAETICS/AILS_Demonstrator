package org.inaetics.ails.api.common.model;

import java.util.UUID;

import com.google.common.base.Preconditions;

/**
 * UUIDLocation can be used to store a {@link Location} that specifically belong to a User via its
 * {@link UUID}. For example, when we know the Location of a User for certain, we can store that in
 * this class.
 * 
 * @author L. Buit, N. Korthout, J. Naus
 * @version 1.0.0
 * @since 28-10-2015
 */
public class UUIDLocation implements Key<UUID> {

    private final UUID uuid;
    private final Location location;

    /**
     * Constructor
     * 
     * @param uuid @NotNull The uuid of the User the location belongs to.
     * @param location @NotNull The location belonging to the user.
     */
    public UUIDLocation(UUID uuid, Location location) {
        super();
        this.uuid = Preconditions.checkNotNull(uuid, "uuid is not set");
        this.location = Preconditions.checkNotNull(location, "location is not set");
    }

    /**
     * Retrieve the uuid.
     * 
     * @return the uuid.
     */
    public UUID getUUID() {
        return uuid;
    }

    /**
     * Retrieve the location.
     * 
     * @return the location
     */
    public Location getLocation() {
        return location;
    }

    /**
     * @since 0.2.0
     */
    @Override
    public UUID getKey() {
        return uuid;
    }

}
