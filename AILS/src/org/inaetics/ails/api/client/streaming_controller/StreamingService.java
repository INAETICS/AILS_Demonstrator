package org.inaetics.ails.api.client.streaming_controller;

import org.inaetics.ails.api.common.model.AnonUser;

/**
 * The Streaming Service provides methods to start and stop streaming UserWiFiProfiles to the
 * server.
 * 
 * @author L. Buit, N. Korthout, J. Naus
 * @version 1.0.0
 * @since 11-11-2015
 */
public interface StreamingService {

    /**
     * Starts streaming {@link UserWiFiProfile UserWiFiProfiles} to the server.
     * 
     * @param anonUser The anonymous user that decorates the {@link UserWiFiProfile UserWiFiProfiles}.
     */
    void startStreaming(AnonUser anonUser);

    /**
     * Stops streaming {@link UserWiFiProfile UserWiFiProfiles} to the server.
     */
    void stopStreaming();
}
