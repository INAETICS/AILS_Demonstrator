package org.inaetics.ails.api.client.streaming_controller;

/**
 * The Streaming Service provides methods to start and stop streaming UserWiFiProfiles to the
 * server.
 * 
 * @author L. Buit, N. Korthout, J. Naus
 * @version 0.1.0
 * @since 11-11-2015
 */
public interface StreamingService {

    /**
     * Starts streaming {@link UserWiFiProfile UserWiFiProfiles} to the server.
     */
    void startStreaming();

    /**
     * Stops streaming {@link UserWiFiProfile UserWiFiProfiles} to the server.
     */
    void stopStreaming();
}
