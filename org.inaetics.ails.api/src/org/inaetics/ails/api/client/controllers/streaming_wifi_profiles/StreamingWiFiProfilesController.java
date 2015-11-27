package org.inaetics.ails.api.client.controllers.streaming_wifi_profiles;

/**
 * The Streaming Service provides methods to start and stop streaming UserWiFiProfiles to the
 * server.
 * 
 * @author L. Buit, N. Korthout, J. Naus
 * @version 1.0.0
 * @since 24-11-2015
 */
public interface StreamingWiFiProfilesController {

    /**
     * Starts streaming {@link UserWiFiProfile UserWiFiProfiles} to the server.
     * 
     * @param period The period the learning mode should wait in between sending WiFiProfiles. Must
     *        be positive.
     * @since 1.0.0
     */
    void startStreaming(int period);

    /**
     * Stops streaming {@link UserWiFiProfile UserWiFiProfiles} to the server.
     */
    void stopStreaming();
}
