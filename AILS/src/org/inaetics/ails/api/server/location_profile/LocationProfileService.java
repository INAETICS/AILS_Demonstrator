package org.inaetics.ails.api.server.location_profile;

import org.inaetics.ails.api.model.LocationProfile;

/**
 * This service provides functions to add new {@link LocationProfile LocationProfiles}. These
 * LocationProfiles can be used by the {@link LocationService} to locate a {@link User}'s device.
 * 
 * @author nicokorthout
 * @version 0.1.0
 * @since 22-10-2015
 */
public interface LocationProfileService {

    /**
     * Add a new LocationProfile. So it can be used by the {@link LocationService} to locate a
     * {@link User}'s device.
     * 
     * @param locationProfile @NotNull The LocationProfile to add.
     */
    void add(LocationProfile locationProfile);

}
