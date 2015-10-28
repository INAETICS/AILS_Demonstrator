package org.inaetics.ails.api.server.streaming_profile;

import org.inaetics.ails.api.common.model.UserWiFiProfile;

/**
 * This service provides functions to add new {@link UserWiFiProfile UserWiFiProfiles}. These
 * UserWiFiProfiles can be added to a {@link BufferService Buffer}.
 * 
 * @author L. Buit, N. Korthout, J. Naus
 * @version 0.1.0
 * @since 28-10-2015
 */
public interface StreamingProfileService {

    /**
     * Add a new UserWiFiProfile, so that it can be used by the {@link BufferService Buffer}.
     * 
     * @param userWiFiProfile @NotNull The LocationProfile to add.
     */
    void add(UserWiFiProfile userWiFiProfile);

}
