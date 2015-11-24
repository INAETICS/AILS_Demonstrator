package org.inaetics.ails.api.client.controllers.streaming_wifi_profiles;

/**
 * The Streaming Service provides methods to start and stop streaming UserWiFiProfiles to the
 * server.
 * 
 * @author L. Buit, N. Korthout, J. Naus
 * @version 0.1.0
 * @since 24-11-2015
 */
public interface StreamingWiFiProfilesController {

    /**
     * Starts streaming {@link UserWiFiProfile UserWiFiProfiles} to the server.
     */
    void startStreaming();

    /**
     * Stops streaming {@link UserWiFiProfile UserWiFiProfiles} to the server.
     */
    void stopStreaming();
}
