package org.inaetics.ails.api.server.streaming_profile.service;

import org.inaetics.ails.api.common.model.AnonUserWiFiProfile;

/**
 * This service provides functions to add new {@link UserWiFiProfile UserWiFiProfiles} to the system. These
 * UserWiFiProfiles can be used to find the {@link Location} of a {@link AnonUser} via a {@link WiFiProfile}.
 * 
 * @author L. Buit, N. Korthout, J. Naus
 * @version 0.1.2
 * @since 28-10-2015
 */
public interface StreamingProfileService {

    /**
     * Add a new AnonUserWiFiProfile to the system.
     * 
     * @param anonUserWiFiProfile @NotNull The AnonUserWiFiProfile to add.
     */
    void add(AnonUserWiFiProfile anonUserWiFiProfile);

}
