package org.inaetics.ails.api.server.streaming_profile.service;

import org.inaetics.ails.api.common.model.UUIDWiFiProfile;

/**
 * This service provides functions to add new {@link UUIDWiFiProfile UUIDWiFiProfiles} to the system. These
 * UUIDWiFiProfiles can be used to find the {@link Location} of a {@link User} via a {@link WiFiProfile}.
 * 
 * @author L. Buit, N. Korthout, J. Naus
 * @version 0.1.2
 * @since 28-10-2015
 */
public interface StreamingProfileService {

    /**
     * Add a new UUIDUserWiFiProfile to the system.
     * 
     * @param uuidUserWiFiProfile @NotNull The UUIDWiFiProfile to add.
     */
    void add(UUIDWiFiProfile uuidUserWiFiProfile);

}
