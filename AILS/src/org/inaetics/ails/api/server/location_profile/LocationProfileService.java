package org.inaetics.ails.api.server.location_profile;

import org.inaetics.ails.api.common.model.RawLocationProfile;

/**
 * This service provides functions to add new {@link RawLocationProfile LocationProfiles}. These
 * LocationProfiles can be used by the {@link LocationService} to locate a {@link User}'s device.
 * 
 * @author L. Buit, N. Korthout, J. Naus
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
    void add(RawLocationProfile locationProfile);

}
