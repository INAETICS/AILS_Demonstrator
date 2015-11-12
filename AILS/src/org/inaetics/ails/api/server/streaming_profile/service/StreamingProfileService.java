package org.inaetics.ails.api.server.streaming_profile.service;

import org.inaetics.ails.api.common.model.UserWiFiProfile;

/**
 * This service provides functions to add new {@link UserWiFiProfile UserWiFiProfiles} to the system. These
 * UserWiFiProfiles can be used to find the {@link Location} of a {@link AnonUser} via a {@link WiFiProfile}.
 * 
 * @author L. Buit, N. Korthout, J. Naus
 * @version 0.1.1
 * @since 28-10-2015
 */
public interface StreamingProfileService {

    /**
     * Add a new UserWiFiProfile to the system.
     * 
     * @param userWiFiProfile @NotNull The UserWiFiProfile to add.
     */
    void add(UserWiFiProfile userWiFiProfile);

}
